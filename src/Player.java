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
						System.out.println("What is the x position of your ship?");
						int xPos = scanner.nextInt();
						System.out.println("What is the y position of your ship?");
						int yPos = scanner.nextInt();
						// Check if the placement is valid
						while (!board.checkValidPlacement(choice, length, xPos, yPos)){
								System.out.println("Please enter a valid placement");
								System.out.println("What is the x position of your ship?");
								xPos = scanner.nextInt();
								System.out.println("What is the y position of your ship?");
								yPos = scanner.nextInt();
						}
						if (choice == 1) {
								Ship ship = new Ship(length, xPos, yPos, "horizontal");
								ships.add(ship);
								board.placeShip("horizontal", length, xPos, yPos);
						} else if (choice == 2) {
								Ship ship = new Ship(length, xPos, yPos, "vertical");
								ships.add(ship);
								board.placeShip("vertical", length, xPos, yPos);
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
				System.out.println("Where would you like to fire your missile?");
				Scanner scanner = new Scanner(System.in);
				System.out.println("What is the x position of your missile?");
				int xPos = scanner.nextInt();
				System.out.println("What is the y position of your missile?");
				int yPos = scanner.nextInt();
				// check if the xPos and yPos are inside the Board
				while (xPos < 0 || xPos > 9 || yPos < 0 || yPos > 9) {
						System.out.println("Please enter a valid position");
						System.out.println("What is the x position of your missile?");
						xPos = scanner.nextInt();
						System.out.println("What is the y position of your missile?");
						yPos = scanner.nextInt();
				}
				if(board.checkHit(xPos, yPos)){
						System.out.println("You hit a ship!");
				} else {
						System.out.println("You missed!");
				}

		}
	// write a function that checks if the missile hit a ship

	// write a function that checks if the missile sunk a ship




		public Board getPlayersBoard() {
				return this.board;
		}


}
