
public class Ship {
    private int length;
    private int col;
    private int row;
    private String orientation;
    private boolean sunk = false;
    private int[] coordinates;
    private int hits;


    public Ship(int length, int col, int row, String orientation) {
        this.length = length;
        this.col = col;
        this.row = row;
        this.orientation = orientation;
        this.hits = 0;
        this.coordinates = new int[length];
        for(int i = 0; i < length; i++){
            if(orientation.equals("horizontal")){
                this.coordinates[i] = col + i;
            } else if(orientation.equals("vertical")){
                this.coordinates[i] = row + i;
            }
        }

    }


    // If a ship has taken enough hits, it is sunk
    public void isSunk(int length, int hits) {
        if(hits >= length){
            System.out.println("You sunk my battleship!");
            this.sunk = true;

        }

    }



    public boolean getSunk(){
        return this.sunk;
    }

    public int getLength() {
        return this.length;
    }



    public int getHits() {
        return this.hits;
    }

    public void addHit() {
        this.hits = hits + 1;
    }

}