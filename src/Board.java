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

    public boolean checkValidPlacement(int OrientationChoice, int length, int xPos, int yPos) {

        boolean valid = true;
//        check if a ship is already in the location
        if (OrientationChoice == 1) {
            for (int i = 0; i < length; i++) {
                if (board[xPos][yPos + i].equals(" \uD83D\uDEA2 ")) {
                    valid = false;
                }
            }
        } else if (OrientationChoice == 2)  {
            for (int i = 0; i < length; i++) {
                if (board[xPos + i][yPos].equals(" \uD83D\uDEA2 ")) {
                    valid = false;
                }
            }
        }

//        check if the ship is out of bounds on the Board
        if(OrientationChoice == 1) {
            if(xPos + length > 9) {
                valid = false;
            }
        } else if(OrientationChoice == 2) {
            if(yPos + length > 9) {
                valid = false;
            }
        }

        return valid;

    }

}