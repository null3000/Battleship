
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


    public void isSunk(int length, int hits) {
        if(hits >= length){
            System.out.println("Ship is sunk!");
            this.sunk = true;

        }

    }



    public boolean getSunk(){
        return this.sunk;
    }
    public void setSunk(boolean sunk) {
        this.sunk = sunk;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getXPos() {
        return this.xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public String getOrientation() {
        return this.orientation;
    }








}