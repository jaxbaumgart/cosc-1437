package assignment4;
import java.util.*;

public class game {
    public static void main(String[] args) {
        // Create scanner.
        Scanner in = new Scanner(System.in);
        String Choice = "";

        // Create player.
        Player P = new Player("Jax", 'J');

        // Create enemies.
        Enemy E1 = new Enemy("Orc");
        Enemy E2 = new Enemy("Troll");
        Enemy E3 = new Enemy("Ghoul");
        Enemy E4 = new Enemy("Demon");

        // Main game loop.
        while (!Choice.equals("q")) {
            P.PrintWorld();
            System.out.println();
            System.out.print("Enter your command >> ");
            Choice = in.nextLine();
            System.out.println();

            if (Choice.equals("a")) {
                P.MoveLeft();
            }

            if (Choice.equals("s")) {
                P.MoveDown();
            }

            if (Choice.equals("d")) {
                P.MoveRight();
            }

            if (Choice.equals("w")) {
                P.MoveUp();
            }

        }
    }
}

class GameObject {
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

    // Constructor
    Enemy(String Race) {
        // Type from declaration, position random.
        Type = Race;
        Xpos = (int) (Math.random() * 40) + 1;
        Ypos = (int) (Math.random() * 20) + 1;

        // Rest dependent on type.
        if (Type.equals("Orc")) {
            Avatar = 'O';
            HP = 20;
            Attack = 5;
            Armor = 20;
            Speed = 5;
        }

        if (Type.equals("Troll")) {
            Avatar = 'T';
            HP = 10;
            Attack = 2;
            Armor = 5;
            Speed = 2;
        }

        if (Type.equals("Ghoul")) {
            Avatar = 'G';
            HP = 50;
            Attack = 15;
            Armor = 100;
            Speed = 15;
        }

        if (Type.equals("Demon")) {
            Avatar = 'D';
            HP = 100;
            Attack = 20;
            Armor = 100;
            Speed = 20;
        }

        world[Xpos][Ypos] = Avatar;

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

        for (int y=0; y<=20; y++) {
            for (int x = 0; x <= 40; x++) {
                world[x][y] = ' ';
            }
        }

        Xpos=2;
        Ypos=2;
        world[2][2]=Avatar;

        for (int x=0; x<=40; x++) {
            world[x][0] = '@';  world[x][20] = '@';
        }
        for (int y=0; y<=20; y++) {
            world[0][y] = '@';  world[40][y] = '@';
        }


        int a = (int)(Math.random()*30)+4;
        int b = (int)(Math.random()*10)+3;
        world[a][b] = '~'; world[a+1][b] = '~'; world[a+2][b] = '~';
        world[a][b+1] = '~'; world[a+1][b+1] = '~'; world[a+2][b+1] = '~';
        world[a][b+2] = '~'; world[a+1][b+2] = '~'; world[a+2][b+2] = '~';
    }
}