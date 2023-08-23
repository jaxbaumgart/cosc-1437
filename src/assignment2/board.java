// Assignment 2b DONE
package assignment2;

public class board {
    public static void main(String[] args) {
        // Creates 10x10 "board".
        String [][] board = new String[10][10];

        // Fills board with periods.
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                board[i][j] = ".";
            }
        }

        // Fills 10 random spaces with "$".
        for (int i = 1; i <= 10;) {
            int row = (int) (Math.random() * 9) + 1;
            int column = (int) (Math.random() * 9) + 1;
            // Only changes cell if not already "$".
            if (!board[row][column].equals("$")) {
                board[row][column] = "$";
                i++;
            }
        }

        // Fills random cell with "B".
        for (int i = 0; i < 1;) {
            int row = (int) (Math.random() * 9) + 1;
            int column = (int) (Math.random() * 9) + 1;
            // Only changes cell if ".".
            if (board[row][column].equals(".")) {
                board[row][column] = "B";
                i++;
            }
        }

        // Prints board.
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
