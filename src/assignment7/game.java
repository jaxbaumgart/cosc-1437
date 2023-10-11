package assignment7;
import java.util.*;

public class game {
    // ASCII
    static String CLS = "\033[2J\033[1;1H";
    static String Red = "\033[31;1m";
    static String Green = "\033[32;1m";
    static String Yellow = "\033[33;1m";
    static String Blue = "\033[34;1m";
    static String Purple = "\033[35;1m";
    static String Cyan = "\033[36;1m";
    static String White = "\033[37;1m";
    static String Normal = "\033[0m"; // default gray color & reset background to black
    static String WhiteOnRed = "\033[41;1m";
    static String WhiteOnGreen = "\033[42;1m";
    static String WhiteOnYellow = "\033[43;1m";
    static String WhiteOnBlue = "\033[44;1m";
    static String WhiteOnPurple = "\033[45;1m";
    static String WhiteOnCyan = "\033[46;1m";
    public static void main(String[] args) {

        // Create scanner.
        Scanner in = new Scanner(System.in);
        char Choice = ' ';

        // Create player.
        Player P = new Player("Mulder", 'M');

        // Game over variable.
        boolean gameOver = false;
        int finish = 0;

        // Create enemies.
        ArrayList<Enemy> Enemies = new ArrayList<>();
        Enemies.add(new Enemy("Cigarette Smoking Man"));
        Enemies.add(new Enemy("Eugene Tooms"));
        Enemies.add(new Enemy("Donnie Pfaster"));
        Enemies.add(new Enemy("Robert Patrick Modell"));

        // Create PowerUps
        ArrayList<PowerUp> PowerUps = new ArrayList<>();
        PowerUps.add(new PowerUp());
        PowerUps.add(new PowerUp());
        PowerUps.add(new PowerUp());

        // ASCII Art.
        System.out.println(Purple + "T H E" + Blue + "         ,.__                                       " + Red + "XXXXXxX xxxXXXXXX" + Normal);
        System.out.println(Blue + "             ((-\\)),                                       " + Red + "xXX      xXX" + Normal);
        System.out.println(Blue + "             | . . {         ___.                            " + Red + "X      XX" + Normal);
        System.out.println(Purple + "T R U T H" + Blue + "    (  _) )       /(()-/)                            " + Red + "X   xX" + Normal);
        System.out.println(Blue + "              \\ _ /       / /. . |\\                            " + Red + "xx xX" + Normal);
        System.out.println(Blue + "            __-\\_/-__     ||  ]  )|        " + Red + "T  H  E   (X)   F  I  L  E  S" + Normal);
        System.out.println(Purple + "I S" + Blue + "        / \\ \\@//  \\    /|  -  ||                            " + Red + "xX xx" + Normal);
        System.out.println(Blue + "          |  | |{||__|\\   /_\\___/|,                           " + Red + "Xx   Xx" + Normal);
        System.out.println(Blue + "          |  | |}||  ||  |    \\/   \\                         " + Red + "XX     XX   TM" + Normal);
        System.out.println(Purple + "O U T" + Blue + "     |  {.|{/|  ||  | |_| __| |                       " + Red + "xXX       XX" + Normal);
        System.out.println(Blue + "          |  /.|__|  ||  \\___\\_____/                     " + Red + "xXXXXXXXXx XXXXxXx" + Normal);
        System.out.println(Blue + "           \\/ .|=>|  |/   /   o|  \\");
        System.out.println(Purple + "T H E R E" + Normal);

        // Rules explanation.
        System.out.println();
        System.out.println(Yellow + "FBI Special Agent Fox Mulder needs your help!" + Normal);
        System.out.println(Yellow + "A series of Aliens is on the loose!" + Normal);
        System.out.println(Yellow + "Defeat all the aliens to win the game." + Normal);
        System.out.println(Yellow + "Aliens in range will track you and damage your HP." + Normal);
        System.out.println(Yellow + "You will attack any aliens next to you." + Normal);
        System.out.println(Yellow + "The game ends when you run out of HP or you defeat all aliens." + Normal);
        System.out.println(Yellow + "Best of luck!" + Red + " THE TRUTH IS OUT THERE" + Normal);
        System.out.println();
        System.out.println(Green + "Press Enter to Begin >> " + Normal);
        in.nextLine();

        // Main game loop.
        while (!gameOver) {
            P.PrintWorld();
            System.out.println();
            System.out.println( Red + "HP " + P.HP + Normal + " | " + Green + "You are 'M'" + Normal + " | " + Blue + "Enter command A, S, D, W, or Q " + Normal);
            System.out.print("Command >> ");
            Choice = in.next().charAt(0);
            System.out.println();

            // Player Movements
            if (Choice == 'a') {
                P.MoveLeft();
            }

            if (Choice == 's') {
                P.MoveDown();
            }

            if (Choice == 'd') {
                P.MoveRight();
            }

            if (Choice == 'w') {
                P.MoveUp();
            }

            // Enemy Attack
            for (int i=0; i<Enemies.size(); i++)
            {
                if ((Enemies.get(i).Ypos == P.Ypos && (Enemies.get(i).Xpos == P.Xpos+1)) || // player is to the left
                        (Enemies.get(i).Ypos == P.Ypos && (Enemies.get(i).Xpos == P.Xpos-1)) ||  // player is to the right
                        (Enemies.get(i).Xpos == P.Xpos && (Enemies.get(i).Ypos == P.Ypos+1)) ||  // player is above
                        (Enemies.get(i).Xpos == P.Xpos && (Enemies.get(i).Ypos == P.Ypos-1)))    // player is below
                {
                    Enemies.get(i).HP -= P.Attack;    // Player attacks Enemy
                    P.HP -= Enemies.get(i).Attack;    // Enemy attacks Player
                    P.HP -= (100 * Enemies.get(i).Attack) / (100 + P.Armor);

                    if (Enemies.get(i).HP <= 0)    // Enemy dies
                    {
                        P.world[Enemies.get(i).Xpos][Enemies.get(i).Ypos] = ' ';
                        Enemies.remove(i);
                    }
                }
            }

            // Enemy Movement
            for (int i=0; i<Enemies.size(); i++) {
                // Check if enemy in range.
                if (Math.abs(Enemies.get(i).Xpos - P.Xpos) <= Enemies.get(i).Range && Math.abs(Enemies.get(i).Ypos - P.Ypos) <= Enemies.get(i).Range) {
                    if (Enemies.get(i).Xpos > P.Xpos) {
                        Enemies.get(i).MoveLeft();
                    }
                    else {
                        Enemies.get(i).MoveRight();
                    }
                    if (Enemies.get(i).Ypos > P.Ypos) {
                        Enemies.get(i).MoveUp();
                    }
                    else {
                        Enemies.get(i).MoveDown();
                    }
                } else { // Enemy will randomly move if not in range.
                    int R = (int)(Math.random() * 8) + 1;
                    if (R == 1) {
                        Enemies.get(i).MoveLeft();
                    }
                    if (R == 2) {
                        Enemies.get(i).MoveUp();
                    }
                    if (R == 3) {
                        Enemies.get(i).MoveRight();
                    }
                    if (R == 4) {
                        Enemies.get(i).MoveDown();
                    }
                }
            }

            if (P.HP < 1) {
                gameOver = true;
                finish = 1;
            }

            if (Enemies.size() < 1) {
                gameOver = true;
                finish = 2;
            }

            if (Choice == 'q') {
                gameOver = true;
                finish = 3;
            }
        }

        // Win screen
        if (finish == 1) {
            System.out.println(" X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    "\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    "\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    "\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    "\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    "\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    "\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\ /\\\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X");
            System.out.println();
            System.out.println(Red + "Oh no! You ran out of health!" + Normal);
            System.out.println(Red + "You lost the game!" + Normal);
            System.out.println(Red + "Better luck next time!" + Normal);
        }
        // Lose screen
        if (finish == 2) {
            System.out.println(Green + "|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   \n" +
                    " __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|\n" +
                    "|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|\n" +
                    "|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   \n" +
                    " __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|\n" +
                    "|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|\n" +
                    "|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   \n" +
                    " __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|\n" +
                    "|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|\n" +
                    "|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   \n" +
                    " __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|\n" +
                    "|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|\n" +
                    "|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   \n" +
                    " __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|\n" +
                    "|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|\n" +
                    "|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   \n" +
                    " __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|\n" +
                    "|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|\n" +
                    "|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   \n" +
                    " __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|   __|__|" + Normal);
            System.out.println();
            System.out.println(Green + "Congrats! You defeated all the aliens!" + Normal);
            System.out.println(Green + "You won the game!" + Normal);
        }

        if (finish == 3) {
            System.out.println(Red + " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  \n" +
                    "/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/ \\/\n" +
                    " X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X  X" + Normal);
            System.out.println();
            System.out.println(Red + "You quit the game!" + Normal);
        }
    }
}

class GameObject {
    // ASCII
    static String CLS = "\033[2J\033[1;1H";
    static String Red = "\033[31;1m";
    static String Green = "\033[32;1m";
    static String Yellow = "\033[33;1m";
    static String Blue = "\033[34;1m";
    static String Purple = "\033[35;1m";
    static String Cyan = "\033[36;1m";
    static String White = "\033[37;1m";
    static String Normal = "\033[0m"; // default gray color & reset background to black

    static String WhiteOnRed = "\033[41;1m";
    static String WhiteOnGreen = "\033[42;1m";
    static String WhiteOnYellow = "\033[43;1m";
    static String WhiteOnBlue = "\033[44;1m";
    static String WhiteOnPurple = "\033[45;1m";
    static String WhiteOnCyan = "\033[46;1m";

    // Variables
    static char[][] world = new char[41][21];
    public int Xpos;
    public int Ypos;
    public int HP;
    public int Attack;
    public int Armor;
    public char Avatar;

    // Methods
    void PrintWorld() {
        System.out.print(CLS);
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 40; j++) {
                System.out.print(world[j][i] + " ");
            }
            System.out.println();
        }
    }

    void MoveRight() {
        if (world[Xpos + 1][Ypos] == ' ') {
            world[Xpos][Ypos] = ' ';
            Xpos++;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveLeft() {
        if (world[Xpos - 1][Ypos] == ' ') {
            world[Xpos][Ypos] = ' ';
            Xpos--;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveUp() {
        if (world[Xpos][Ypos - 1] == ' ') {
            world[Xpos][Ypos] = ' ';
            Ypos--;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveDown() {
        if (world[Xpos][Ypos + 1] == ' ') {
            world[Xpos][Ypos] = ' ';
            Ypos++;
            world[Xpos][Ypos] = Avatar;
        }
    }
}


class Enemy extends GameObject {
    // Variables
    public String Type;
    public int Speed;
    public int Range;

    // Constructor
    Enemy(String Race) {
        // Type from declaration, position random.
        Type = Race;
        Xpos = (int) (Math.random() * 39) + 1;
        Ypos = (int) (Math.random() * 19) + 1;
        Avatar = Type.charAt(0);
        HP = (int) (Math.random() * 50 + 1);
        Attack = (int) (Math.random() * 5 + 1);
        Armor = (int) (Math.random() * 10 + 1);
        Speed = (int) (Math.random() * 4 + 1);
        Range = (int) (Math.random() * 10 + 1);
        world[Xpos][Ypos] = Avatar;

    }

    void MoveRight() {
        if (world[Xpos + 1][Ypos] == ' ') {
            world[Xpos][Ypos] = ' ';
            Xpos++;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveLeft() {
        if (world[Xpos - 1][Ypos] == ' ') {
            world[Xpos][Ypos] = ' ';
            Xpos--;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveUp() {
        if (world[Xpos][Ypos - 1] == ' ') {
            world[Xpos][Ypos] = ' ';
            Ypos--;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveDown() {
        if (world[Xpos][Ypos + 1] == ' ') {
            world[Xpos][Ypos] = ' ';
            Ypos++;
            world[Xpos][Ypos] = Avatar;
        }
    }
}

class Player extends GameObject {
    // Variables
    public String Name;
    public int Gold;

    // Constructor
    Player(String N, char A) {

        Name = N;
        Avatar = A;

        for (int y = 0; y <= 20; y++) {
            for (int x = 0; x <= 40; x++) {
                world[x][y] = ' ';
            }
        }

        Xpos = 2;
        Ypos = 2;
        world[2][2] = Avatar;
        HP = 100;
        Attack = 10;

        for (int x = 0; x <= 40; x++) {
            world[x][0] = '@';
            world[x][20] = '@';
        }
        for (int y = 0; y <= 20; y++) {
            world[0][y] = '@';
            world[40][y] = '@';
        }


        int a = (int) (Math.random() * 30) + 4;
        int b = (int) (Math.random() * 10) + 3;
        world[a][b] = '~';
        world[a + 1][b] = '~';
        world[a + 2][b] = '~';
        world[a][b + 1] = '~';
        world[a + 1][b + 1] = '~';
        world[a + 2][b + 1] = '~';
        world[a][b + 2] = '~';
        world[a + 1][b + 2] = '~';
        world[a + 2][b + 2] = '~';
    }

    void MoveRight() {
        if (world[Xpos + 1][Ypos] == ' ' || world[Xpos + 1][Ypos] == '+') {
            if (world[Xpos + 1][Ypos] == '+') {
                HP += 25;
            }
            world[Xpos][Ypos] = ' ';
            Xpos++;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveLeft() {
        if (world[Xpos - 1][Ypos] == ' ' || world[Xpos - 1][Ypos] == '+') {
            if (world[Xpos + 1][Ypos] == '+') {
                HP += 25;
            }
            world[Xpos][Ypos] = ' ';
            Xpos--;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveUp() {
        if (world[Xpos][Ypos - 1] == ' ' || world[Xpos][Ypos - 1] == '+') {
            if (world[Xpos + 1][Ypos] == '+') {
                HP += 25;
            }
            world[Xpos][Ypos] = ' ';
            Ypos--;
            world[Xpos][Ypos] = Avatar;
        }
    }

    void MoveDown() {
        if (world[Xpos][Ypos + 1] == ' ' || world[Xpos][Ypos + 1] == '+') {
            if (world[Xpos + 1][Ypos] == '+') {
                HP += 25;
            }
            world[Xpos][Ypos] = ' ';
            Ypos++;
            world[Xpos][Ypos] = Avatar;
        }
    }
}

class PowerUp extends GameObject {
    // Variables
    public String Type;
    public int Speed;

    // Constructor
    PowerUp() {
        // Type from declaration, position random.
        Type = "PowerUp";
        Xpos = (int) (Math.random() * 39) + 1;
        Ypos = (int) (Math.random() * 19) + 1;
        Avatar = '+';
        HP = 0;
        Attack = 0;
        Armor = 0;
        Speed = 0;
        world[Xpos][Ypos] = Avatar;

    }
}