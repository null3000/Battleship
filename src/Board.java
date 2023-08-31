import java.util.Scanner;

public class Board {

    public String[][] board = new String[9][9];

    public String[][] setupBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " \uD83C\uDF0A ";
            }
        }
        return board;
    }

    public void printBoard() {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void placeShip(String orientation, int length, int xPos, int yPos) {
        if (orientation.equals("horizontal")) {
            for (int i = 0; i < length; i++) {
                board[xPos][yPos + i] = " \uD83D\uDEA2 ";
            }
        } else if (orientation.equals("vertical")) {
            for (int i = 0; i < length; i++) {
                board[xPos + i][yPos] = " \uD83D\uDEA2 ";
            }
        }




    }

}