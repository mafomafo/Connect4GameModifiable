import java.util.*;
public class Main {
  public static void main(String[] args) {
        Connect4 game = new Connect4();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter 1 for default game, 2 for custom game, press any other button to quit: ");
        int choice = s.nextInt();
        if (choice == 1){
          game = new Connect4();
        }
        else if (choice == 2){
          System.out.println("Enter the number of rows: ");
          int rows = s.nextInt();
          System.out.println("Enter the number of columns: ");
          int cols = s.nextInt();
          System.out.println("Enter the win condition: ");
          int win = s.nextInt();
          System.out.println("Enter the name of player 1: ");
          String p1 = s.next();
          System.out.println("Enter the name of player 2: ");
          String p2 = s.next();
          System.out.println("Enter the symbol of player 1: ");
          String p1_str = s.next();
          System.out.println("Enter the symbol of player 2: ");
          String p2_str = s.next();
          game = new Connect4(rows, cols, win, p1, p2, p1_str, p2_str);
    }
    game.playGame();
  }

 
}


