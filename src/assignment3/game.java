// Assignment 3b
package assignment3;

public class game {
    public static void main(String[] args) {

        // Create "world".
        char[][] world = new char[10][10];

        // Fills world with periods.
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                world[i][j] = '.';
            }
        }

        // Declare instances of enemies.
        Enemy orc = new Enemy ("Orc");
        Enemy troll = new Enemy("Troll");
        Enemy ghoul = new Enemy("Ghoul");
        Enemy demon = new Enemy("Demon");

        // Display enemies on world.
        world[orc.Xpos][orc.Ypos] = orc.Avatar;
        world[troll.Xpos][troll.Ypos] = troll.Avatar;
        world[ghoul.Xpos][ghoul.Ypos] = ghoul.Avatar;
        world[demon.Xpos][demon.Ypos] = demon.Avatar;

        // Prints world.
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.print(world[i][j] + "  ");
            }
            System.out.println();
        }
    }

    }

class Enemy {
    // Variables
    public int Xpos;
    public int Ypos;
    public char Avatar;
    public String Type;
    public int HP;
    public int Attack;
    public int Armor;

    // Constructor
    Enemy(String theType) {
        // Type from declaration, position random.
        Type = theType;
        Xpos = (int) (Math.random() * 9) + 1;
        Ypos = (int) (Math.random() * 9) + 1;

        // Rest dependent on type.
        if (Type.equals("Orc")) {
            Avatar = 'O';
            HP = 20;
            Attack = 5;
            Armor = 20;
        }

        if (Type.equals("Troll")) {
            Avatar = 'T';
            HP = 10;
            Attack = 2;
            Armor = 5;
        }

        if (Type.equals("Ghoul")) {
            Avatar = 'G';
            HP = 50;
            Attack = 15;
            Armor = 100;
        }

        if (Type.equals("Demon")) {
            Avatar = 'D';
            HP = 100;
            Attack = 20;
            Armor = 100;
        }
    }
}