import java.util.ArrayList;
import java.util.Scanner;

public class Player {


//		create a player that has a board, a list ships, name
//		place ships on the board


		private String name;
		private Board board;

//		create an array list of ships
		private ArrayList<Integer> possibleLengths = new ArrayList<Integer>();


		private ArrayList<Ship> ships = new ArrayList<Ship>();
//		with lengths of  1:2s 2:3s 1:4s 1:5s




		public Player(String name) {
			this.name = name;
			this.board = new Board();
			this.board.setupBoard();


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
						int choice = scanner.nextInt();
						while (choice != 1 && choice != 2) {
								System.out.println("Please enter a valid choice");
								choice = scanner.nextInt();
						}

						// Print the values for lengths and take user input for what length ship they want to place
						printPossibleLengths();
						int length = 0;
						System.out.println("What length do you choose?");
						length = scanner.nextInt();
						// Check if length is equal to one of the values in possible lengths
						while (!possibleLengths.contains(length)) {
								System.out.println("Please enter a valid length");
								length = scanner.nextInt();
						}
						// Remove already used lengths from the possibleLengths ArrayList
						possibleLengths.remove(possibleLengths.indexOf(length));

						// Take inputs for where user wants for X and Y coordinates of ship
						System.out.println("What is the column of your ship?");
						int col = scanner.nextInt();
						System.out.println("What is the row of your ship?");
						int row = scanner.nextInt();
						// Check if the placement is valid
						while (!board.checkValidPlacement(choice, length, col, row)){
								System.out.println("Please enter a valid placement");
								System.out.println("What is the column of your ship?");
								col = scanner.nextInt();
								System.out.println("What is the row of your ship?");
								row = scanner.nextInt();
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
				for(int i = 0; i < ships.size(); i++) {
						System.out.println("Ship " + i + " has length " + ships.get(i).getLength());
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
				System.out.println("Where would you like to fire your missile?");
				Scanner scanner = new Scanner(System.in);
				System.out.println("What is the x position of your missile?");
				int col = scanner.nextInt();
				System.out.println("What is the y position of your missile?");
				int row = scanner.nextInt();
				// check if the row and col are inside the Board
				while (col < 0 || col > 9 || row < 0 || row > 9) {
						System.out.println("Please enter a valid position");
						System.out.println("What is the column position of your missile?");
						col = scanner.nextInt();
						System.out.println("What is the row position of your missile?");
						row = scanner.nextInt();
				}
				if(board.checkHit(col, row)){
						System.out.println("You hit a ship!");
//						make the hit counter go up one on the ship it hit


				} else {
						System.out.println("You missed!");
				}

				Ship hitShip = board.getHitShip(col, row, ships);
				System.out.println("You hit the ship with length" + hitShip.getLength());

		}




		public Board getPlayersBoard() {
				return this.board;
		}





}
