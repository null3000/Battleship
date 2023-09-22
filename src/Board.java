import java.util.ArrayList;
public class Board {

    public String[][] board = new String[9][9];
    public String shipEmoji = " \uD83D\uDEA2 ";
    public String hitEmoji = " \uD83D\uDCA5 ";
    public String missEmoji = " ❌️ ";

    public void setupBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = " \uD83C\uDF0A ";
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public void placeShip(String orientation, int length, int col, int row) {
        // check if the board is horizontal or vertical
        // and place the rest of its "pieces" there
        if (orientation.equals("horizontal")) {
            for (int i = 0; i < length; i++) {
                board[row][col+i] = shipEmoji;
            }
        } else if (orientation.equals("vertical")) {
            for (int i = 0; i < length; i++) {
                board[row+i][col] = shipEmoji;
            }
        }
    }

    // function to check if the ship being placed is in the board
    public boolean checkValidPlacement(int OrientationChoice, int length, int col, int row) {

        boolean valid = true;

        if (col < 0 || col > 8 || row < 0 || row > 8) {
            valid = false;
        }
        //        check if the boat is out of bounds
        if (OrientationChoice == 1) {
            if (col + length > 9) {
                valid = false;
            }
        } else if (OrientationChoice == 2) {
            if (row + length > 9) {
                valid = false;
            }
        }
        //        check if the boat is overlapping, make sure that the placement is inbounds before checking for overlap
        if (valid) {
            if (OrientationChoice == 1) {
                for (int i = 0; i < length; i++) {
		                if (board[row][col + i].equals(shipEmoji)) {
				                valid = false;
				                break;
		                }
                }
            } else if (OrientationChoice == 2) {
                for (int i = 0; i < length; i++) {
		                if (board[row + i][col].equals(shipEmoji)) {
				                valid = false;
				                break;
		                }
                }
            }
        }


        return valid;
    }
    public int checkHit(int col, int row) {
        // 3 Options for checking the hit
        int hit = 3;
        // Option 1: If it's on a ship make it run the 1 case
        if (board[row][col].equals(shipEmoji)) {
            hit = 1;
            // Option 2: If there is already a hit or miss that is placed there
        } else if(board[row][col].equals(hitEmoji) || board[row][col].equals(missEmoji)) {
            hit = 2;
        }
        // Option 3: If it hits water, mark it a miss
        return hit;


    }

    

    // write a function in Board that checks if the missile xPos and yPos hits a ship, and add a hit to the proper ship if it does
    public Ship getHitShip(int missileCol, int missileRow, ArrayList<Ship> ships) {
        // go through each ship one at a time and return the ship that the hit registers on
        for (int i = 0; i < ships.size(); i++) {
            Ship currentShip = ships.get(i);
            // Loop through each of the ships coordinates individually
            for (int j = 0; j < currentShip.getCoordinates().length; j++) {
                if (currentShip.getOrientation().equals("vertical")) {
                    if (currentShip.getCol() == missileCol && currentShip.getCoordinates()[j] == missileRow) {
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
                    if (currentShip.getRow() == missileRow && currentShip.getCoordinates()[j] == missileCol) {
                        return currentShip;
                    }
                }
            }

        }
        return null;
    }


    public void markHit(int col, int row) {
        board[row][col] = hitEmoji;
    }

    public void markMiss(int col, int row) {
        board[row][col] = missEmoji;
    }






}