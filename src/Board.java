import java.util.Scanner;

public class Board {

    public String[][] board = new String[9][9];
    public String shipEmoji = " \uD83D\uDEA2 ";

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
                board[xPos][yPos + i] = shipEmoji;
            }
        } else if (orientation.equals("vertical")) {
            for (int i = 0; i < length; i++) {
                board[xPos + i][yPos] = shipEmoji;
            }
        }
    }

    public boolean checkValidPlacement(int OrientationChoice, int length, int xPos, int yPos) {

        boolean valid = true;
        //        check if the boat is out of bounds
        if (OrientationChoice == 1) {
            if (yPos + length > 9) {
                valid = false;
            }
        } else if (OrientationChoice == 2) {
            if (xPos + length > 9) {
                valid = false;
            }
        }
        //        check if the boat is overlapping, make sure that the placement is inbounds before checking for overlap
        if (valid) {
            if (OrientationChoice == 1) {
                for (int i = 0; i < length; i++) {
                    if (board[xPos][yPos + i].equals(shipEmoji)) {
                        valid = false;
                    }
                }
            } else if (OrientationChoice == 2) {
                for (int i = 0; i < length; i++) {
                    if (board[xPos + i][yPos].equals(shipEmoji)) {
                        valid = false;
                    }
                }
            }
        }


        return valid;
    }

    // write a function in Board that checks if the missile xPos and yPos hits a ship
    public boolean checkHit(int xPos, int yPos) {
        boolean hit = false;
        if (board[xPos][yPos].equals(shipEmoji)) {
            hit = true;
        }
        return hit;


    }
    // if it does then add 1 to the ships hit count
    // write a function that makes sure you can't hit the same spot repeatedly
    // change the ship emoji to an X after it's been hit there




}