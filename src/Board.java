import java.util.ArrayList;
public class Board {

    public String[][] board = new String[9][9];
    public String shipEmoji = " \uD83D\uDEA2 ";
    public String hitEmoji = " \uD83D\uDCA5 ";

    public String waveEmoji = " \uD83C\uDF0A ";


    public String missEmoji = " ❌️ ";

    public void setupBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = waveEmoji;
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

//                if the location isnt a ship, and isnt isnt a wave, or a hit, or a miss, then it must be a number
                if(board[i][j].equals(hitEmoji) || board[i][j].equals(missEmoji) || board[i][j].equals(waveEmoji)){
                    System.out.print(board[i][j]);
                } else{
                    System.out.print(shipEmoji);
                }

            }
            System.out.println();
        }
    }

    public void placeShip(String orientation, int length, int col, int row, int shipNum) {
        // check if the board is horizontal or vertical
        // and place the rest of its "pieces" there


        String strShipNum = shipNum + "";
        if (orientation.equals("horizontal")) {
            for (int i = 0; i < length; i++) {
                board[row][col+i] = strShipNum;
            }
        } else if (orientation.equals("vertical")) {
            for (int i = 0; i < length; i++) {
                board[row+i][col] = shipEmoji;
            }
        }
    }

    // function to check if the ship being placed is in the board
    public boolean checkValidPlacement(int OrientationChoice, int length, int col, int row) {

        boolean shipisThere = board[row][col].equals("1") || board[row][col].equals("2") || board[row][col].equals("3") || board[row][col].equals("4") || board[row][col].equals("5");

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
		                if (shipisThere) {
				                valid = false;
				                break;
		                }
                }
            } else if (OrientationChoice == 2) {
                for (int i = 0; i < length; i++) {
		                if (shipisThere) {
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

        // Option 3: If it hits water, mark it a miss
        int hit = 3;
        // Option 1: If it's an integer, it's a ship, mark it a hit
        if(board[row][col].equals("1") || board[row][col].equals("2") || board[row][col].equals("3") || board[row][col].equals("4") || board[row][col].equals("5")) {
            hit = 1;
        }
            // Option 2: If there is already a hit or miss that is placed there
            else if(board[row][col].equals(hitEmoji) || board[row][col].equals(missEmoji)){
                hit = 2;
            }

		    return hit;
    }

    

    // write a function in Board that checks if the missile xPos and yPos hits a ship, and add a hit to the proper ship if it does
    public Ship getHitShip(int missileCol, int missileRow, ArrayList<Ship> ships) {

        //                convert board[missileRow][missileCol] to an int
        int boardInt = Integer.parseInt(board[missileRow][missileCol]);
        boardInt = boardInt - 1;
        return ships.get(boardInt);

    }


    public void markHit(int col, int row) {
        board[row][col] = hitEmoji;
    }

    public void markMiss(int col, int row) {
        board[row][col] = missEmoji;
    }






}