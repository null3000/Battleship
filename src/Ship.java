
public class Ship {

    private int length;
    private int xPos;
    private int yPos;
    private String orientation;
    private boolean sunk = false;
    private int[] coordinates;
    private int hits = 0;


    public Ship(int length, int xPos, int yPos, String orientation) {
        this.length = length;
        this.xPos = xPos;
        this.yPos = yPos;
        this.orientation = orientation;

        this.coordinates = new int[length];
        for(int i = 0; i < length; i++){
            if(orientation.equals("horizontal")){
                this.coordinates[i] = xPos + i;
            } else if(orientation.equals("vertical")){
                this.coordinates[i] = yPos + i;
            }
        }


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

    public int getHits() {
        return this.hits;
    }

    public void addHit() {
        this.hits = hits++;
    }

    public int[] getCoordinates(){
        return this.coordinates;
    }








}