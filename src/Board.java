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

    public void placeShip(String orientation, int length, int col, int row) {
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

    public boolean checkValidPlacement(int OrientationChoice, int length, int col, int row) {

        boolean valid = true;

        if (col < 0 || col > 9 || row < 0 || row > 9) {
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
                    if (board[row][col+i].equals(shipEmoji)) {
                        valid = false;
                    }
                }
            } else if (OrientationChoice == 2) {
                for (int i = 0; i < length; i++) {
                    if (board[row+i][col].equals(shipEmoji)) {
                        valid = false;
                    }
                }
            }
        }


        return valid;
    }
    public boolean checkHit(int col, int row) {
        boolean hit = false;
        if (board[row][col].equals(shipEmoji)) {
            hit = true;
            board[row][col] = " \uD83D\uDCA5 ";
        } else if(board[row][col].equals(" \uD83D\uDCA5 ") || board[row][col].equals(" ✖️")) {
            System.out.println("You already fired at this position");
        } else {
            board[row][col] = " ❌ ";
        }
        return hit;


    }

    

    // write a function in Board that checks if the missile xPos and yPos hits a ship, and add a hit to the proper ship if it does
    public Ship getHitShip(int missileCol, int missileRow, ArrayList<Ship> ships) {
        // go through each ship one at a time
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






}