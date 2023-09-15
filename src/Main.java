import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Battleship!");
        System.out.println("What is Player 1's name?");
        String name = s.nextLine();
        Player player1 = new Player(name);
        System.out.println("What is Player 2's name?");
        String name2 = s.nextLine();
        Player player2 = new Player(name);

        player1.placeShips();
        player1.fireMissile();
        player1.fireMissile();
        player1.fireMissile();
        player1.fireMissile();
        player1.fireMissile();


// Make two boards for each player
        // One for when they place their own ships
        // One for during the game when their guesses and marks their guessed spots either hit or miss etc.





    }
}
