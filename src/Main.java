import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Battleship!");
        System.out.println("What is Player 1's name?");
        String name = s.nextLine();
        Player player1 = new Player(name);
        System.out.println("What is Player 2's name?");
        name = s.nextLine();
        Player player2 = new Player(name);

        player1.placeShips();
        player2.placeShips();

        while(!player1.gameOver() && !player2.gameOver()){
            System.out.println(player1.getName() + " it is your turn");
            player2.fireMissile();
            if(player2.gameOver()){
                break;
            }
            System.out.println(player2.getName() + " it is your turn");
            player1.fireMissile();
        }

        if(player1.gameOver()){
            System.out.println(player2.getName() + " wins!");
        }else{
            System.out.println(player1.getName() + " wins!");
        }







    }
}
