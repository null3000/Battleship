import java.util.ArrayList;
import java.util.Scanner;

public class Player {


//		create a player that has a board, a list ships, name
//		place ships on the board


		private String name;
		private Board board;

		private VisibleBoard visibleBoard;

//		create an array list of ships
		private ArrayList<Integer> possibleLengths = new ArrayList<Integer>();


		private ArrayList<Ship> ships = new ArrayList<Ship>();
//		with lengths of  1:2s 2:3s 1:4s 1:5s




		public Player(String name) {
			this.name = name;
			this.board = new Board();
			this.board.setupBoard();
			this.visibleBoard = new VisibleBoard();
			this.visibleBoard.setupBoard();



		}


		// Function to place the ships
		public void placeShips(){
				setupPossibleLengths();
				while(possibleLengths.size() > 0) {
						System.out.println(name + " place your ships");
						System.out.println("How would you like to orient your ship");
						System.out.println("1. Horizontal");
						System.out.println("2. Vertical");
						// Take their input for orientation AND validate it is only 1 or 2, if 1 set it horizontal if 2 set it vertical
						Scanner scanner = new Scanner(System.in);
						int choice = intInput();
						while (choice != 1 && choice != 2) {
								System.out.println("Please enter a valid choice");
								choice = intInput();
						}

						// Print the values for lengths and take user input for what length ship they want to place
						printPossibleLengths();
						int length = 0;
						System.out.println("What length do you choose?");
						length = intInput();
						// Check if length is equal to one of the values in possible lengths
						while (!possibleLengths.contains(length)) {
								System.out.println("Please enter a valid length");
								length = intInput();
						}
						// Remove already used lengths from the possibleLengths ArrayList
						possibleLengths.remove(possibleLengths.indexOf(length));

						// Take inputs for where user wants for X and Y coordinates of ship
						System.out.println("What column do you want to place your ship?");
						int col = intInput();
						System.out.println("What row do you want to place your ship?");
						int row = intInput();
						// Check if the placement is valid
						while (!board.checkValidPlacement(choice, length, col, row)){
								System.out.println("Please enter a valid placement");
								System.out.println("What column do you want to place your ship?");
								col = intInput();
								System.out.println("What row do you want to place your ship?");
								row = intInput();
						}
						if (choice == 1) {
								Ship ship = new Ship(length, col, row, "horizontal");
								ships.add(ship);
								board.placeShip("horizontal", length, col, row);
						} else if (choice == 2) {
								Ship ship = new Ship(length, col, row, "vertical");
								ships.add(ship);
								board.placeShip("vertical", length, col, row);
						}
							board.printBoard();
				}
		}

		public void setupPossibleLengths() {
				possibleLengths.add(2);
				possibleLengths.add(3);
				possibleLengths.add(3);
				possibleLengths.add(4);
				possibleLengths.add(5);
		}

		public void printPossibleLengths(){
//				print all lengths in possibleLengths
				System.out.print("You have the possible lengths of: ");
				for(int i = 0; i < possibleLengths.size(); i++) {
						System.out.print(possibleLengths.get(i) + " ");
				}
		}

	// write a function that gets the player's input on where they want to put their missile

		public void fireMissile() {
				Scanner scanner = new Scanner(System.in);
				System.out.println("What column do you want to fire your missile at?");
				int col = intInput();
				System.out.println("What row do you want to fire your missile at");
				int row = intInput();
				// check  to make sure the row is between 0 and 9 and the col is between 0 and 9
				while (row < 0 || row > 8 || col < 0 || col > 8) {
						System.out.println("Please enter a valid position");
						System.out.println("What column do you want to fire your missile at?");
						col = intInput();
						System.out.println("What row do you want to fire your missile at?");
						row = intInput();
				}


				int hit = board.checkHit(col, row);



				if(hit == 1) {
						visibleBoard.markHit(col, row);
						board.markHit(col, row);
						System.out.println("You hit a ship!");
						Ship hitShip = board.getHitShip(col, row, ships);
						hitShip.addHit();
						System.out.println("This ship has " + hitShip.getHits() + " hits");
						System.out.println("You hit the ship with length " + hitShip.getLength());
						hitShip.isSunk(hitShip.getLength(), hitShip.getHits());

			} else if (hit == 2) {
						System.out.println("You already fired at this position, goofball");

				} else if (hit == 3){
						System.out.println("You missed!");
						board.markMiss(col, row);
						visibleBoard.markMiss(col, row);
				}
				board.printBoard();
				System.out.println();
				visibleBoard.printBoard();



		}

		public boolean gameOver() {
				boolean lost = true;
				for(int i = 0; i < ships.size(); i++) {
						if(!ships.get(i).getSunk()) {
								lost = false;
						}
				}
				return lost;
		}




		public Board getPlayersBoard() {
				return this.board;
		}


//		STOLEN CODE VERY HELPFUL THANKS MR. LIN
		static Scanner s = new Scanner(System.in);
		public static int intInput() {
				String uInput = s.nextLine();
				try{
						return Integer.parseInt(uInput);
				}
				catch (Exception e) {
						System.out.println("That is not a number. Try again.");
						return intInput();
				}
		}


		public String getName() {
				return this.name;
		}
}
