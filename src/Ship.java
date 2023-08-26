public class Ship {

    private int length;
    private int xPos;
    private int yPos;
    private String orientation;
    private boolean sunk = false;
    private int hits = 0;


    public Ship(int length, int xPos, int yPos, String orientation) {
        this.length = length;
        this.xPos = xPos;
        this.yPos = yPos;
        this.orientation = orientation;
    }

    public boolean getSunk(){
        return this.sunk;
    }
    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    public static void isSunk(int length, int hits) {

        if(hits >= length){

        }

    }





}