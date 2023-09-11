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


        player2 .fireMissile();





    }
}
