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



		public void placeShips(){
				setupPossibleLengths();
				System.out.println(name + " place your ships");
				System.out.println("How would you like to orient your ship");
				System.out.println("1. Horizontal");
				System.out.println("2. Vertical");
				Scanner scanner = new Scanner(System.in);
				int choice = scanner.nextInt();
				while(choice!=1 && choice!=2){
					System.out.println("Please enter a valid choice");
					choice = scanner.nextInt();
				}
				printPossibleLengths();
				int length = 0;
//				check if length is equal to one of the values in possible lengths
				while(!possibleLengths.contains(length)){
					System.out.println("Please enter a valid length");
					length = scanner.nextInt();
				}
				System.out.println("What length do you choose?");
				length = scanner.nextInt();

				System.out.println("What is the x position of your ship?");
				int xPos = scanner.nextInt();
				System.out.println("What is the y position of your ship?");
				int yPos = scanner.nextInt();

				if(choice == 1) {
						Ship ship = new Ship(length, xPos, yPos, "horizontal");
						ships.add(ship);
						board.placeShip("horizontal", length, xPos, yPos);
				} else if(choice == 2) {
						Ship ship = new Ship(length, xPos, yPos, "vertical");
						ships.add(ship);
						board.placeShip("vertical", length, xPos, yPos);
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


		public void removeLength(ArrayList<Integer> lengths, Integer toBeRemoved) {
				lengths.remove(toBeRemoved);
		}



		public Board getPlayersBoard() {
				return this.board;
		}


}
