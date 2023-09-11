import java.util.Scanner;
import java.util.ArrayList;
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
    public boolean checkHit(int xPos, int yPos) {
        boolean hit = false;
        if (board[xPos][yPos].equals(shipEmoji)) {
            hit = true;
        }
        return hit;


    }

    

    // write a function in Board that checks if the missile xPos and yPos hits a ship, and add a hit to the proper ship if it does
    public Ship getHitShip(int missileXPos, int missileYPos, ArrayList<Ship> ships) {
        // go through each ship one at a time
        for (int i = 0; i < ships.size(); i++) {
            Ship currentShip = ships.get(i);
            // Loop through each of the ships coordinates individually
            for (int j = 0; j < ships.get(i).getCoordinates().length; j++) {
                if (currentShip.getOrientation().equals("vertical")) {
                    if (currentShip.getXPos() == missileXPos && currentShip.getCoordinates()[j] == missileYPos) {
                        return currentShip;
                    }
                }
            }
        }
        for (int i = 0; i < ships.size(); i++) {
            Ship currentShip = ships.get(i);
            // Loop through each of the ships coordinates individually
            for (int j = 0; j < ships.get(i).getCoordinates().length; j++) {
                if (currentShip.getOrientation().equals("horizontal")) {
                    if (currentShip.getYPos() == missileYPos && currentShip.getCoordinates()[j] == missileXPos) {
                        return currentShip;
                    }
                }
            }

        }
        return ships.get(0);
    }




}