import java.util.*;
public class Connect4{
  private int win_condition;
  private String[][] grid;
  public boolean turn;
  private String p1;
  private String p2;
  private String p1_string;
  private String p2_string;
  public Connect4(int rows, int cols, int win){
    grid = new String[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++)
        grid[i][j] = " - ";
    }
    win_condition = win;
    turn = true;
    p1 = "Player 1";
    p2 = "Player 2";
    p1_string = " X ";
    p2_string = " O ";
    if (rows > win || cols > win){
      if (rows > cols){
        win_condition = cols;
        System.out.println("Win condition was set to value of column size.");
      }
      else if (cols > rows){
      win_condition = rows;
      System.out.println("Win condition was set to value of row size.");
      }
      else 
        win_condition = rows;
      System.out.println("Win condition was set to value of row size.");
    }
    else if (win == 1){
      System.out.println("Win condition was set to row size plus column size divided by 2.");
    win_condition = (rows + cols) / 2;
    }
  }
  public Connect4(int rows, int cols, int win, String pl1, String pl2){
    grid = new String[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++)
        grid[i][j] = " - ";
    }
    win_condition = win;
    turn = true;
    p1 = pl1;
    p2 = pl2;
    p1_string = " X ";
    p2_string = " O ";
      if (rows > win || cols > win){
        if (rows > cols){
          win_condition = cols;
          System.out.println("Win condition was set to value of column size.");
        }
        else if (cols > rows){
        win_condition = rows;
        System.out.println("Win condition was set to value of row size.");
        }
        else 
          win_condition = rows;
        System.out.println("Win condition was set to value of row size.");
      }
      else if (win == 1){
        System.out.println("Win condition was set to row size plus column size divided by 2.");
      win_condition = (rows + cols) / 2;
      }
  }
  public Connect4(int rows, int cols, int win, String pl1, String pl2, String p1_str, String p2_str){
    grid = new String[rows][cols];
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++)
        grid[i][j] = " - ";
    }
    win_condition = win;
    turn = true;
    p1 = pl1;
    p2 = pl2;
    p1_string = " " + p1_str + " ";
    p2_string = " " + p2_str + " ";
    if (rows < win || cols < win){
      if (rows > cols){
        win_condition = cols;
        System.out.println("Win condition was set to value of column size.");
      }
      else if (cols > rows){
      win_condition = rows;
      System.out.println("Win condition was set to value of row size.");
      }
      else 
        win_condition = rows;
      System.out.println("Win condition was set to value of row size.");
    }
    else if (win == 1){
      System.out.println("Win condition was set to row size plus column size divided by 2.");
    win_condition = (rows + cols) / 2;
    }

  }
  public Connect4(){
    grid = new String[6][7];
    for (int i = 0; i < 6; i++){
      for (int j = 0; j < 7; j++)
        grid[i][j] = " - ";
    }
    win_condition = 4;
    turn = true;
    p1 = "Player 1";
    p2 = "Player 2";
    p1_string = " X ";
    p2_string = " O ";
  }
  public int checkWin(){
      int winner = 0;
      if (checkDiagWin_left(p1_string)|| checkDiagWin_right(p1_string)|| checkVerticalWin(p1_string)|| checkHorizontalWin(p1_string)){
        return 1;
      }
      if (checkDiagWin_left(p2_string)||checkDiagWin_right(p2_string)||checkVerticalWin(p2_string)||checkHorizontalWin(p2_string)){
        return 2;
      }
      return winner;
  }
  public boolean checkDiagWin_left(String symbol) {
      int count = 0;

      for (int i = 0; i < grid.length - win_condition + 1; i++) {
          for (int j = 0; j < grid[i].length - win_condition + 1; j++) {
              for (int k = 0; k < win_condition; k++) {
                  if (grid[i + k][j + k].equals(symbol)) {
                      count++;
                      if (count == win_condition) {
                          return true;
                      }
                  } else {
                      count = 0;
                      break;
                  }
              }
              count = 0;
          }
      }
      return false;
  }
  public boolean checkDiagWin_right(String symbol) {
      int count = 1;
      for (int i = 0; i < grid.length - win_condition + 1; i++) {
          for (int j = grid[i].length - 1; j >= win_condition - 1; j--) {
              for (int k = 1; k < win_condition; k++) {
                  if (grid[i][j].equals(symbol) && grid[i + k][j - k].equals(grid[i][j])) {
                      count++;
                      if (count == win_condition) {
                          return true; 
                      }
                  } else {
                      count = 1; 
                      break;
                  }
              }
              count = 1;
          }
      }
      return false; 
  }
  public boolean checkHorizontalWin(String symbol) {
      int count = 0;
      for (int i = 0; i < grid.length; i++) {
          for (int j = 0; j <= grid[i].length - win_condition; j++) {
              for (int k = 0; k < win_condition; k++) {
                  if (grid[i][j + k].equals(symbol)) {
                      count++;
                      if(count == win_condition) {
                          return true;  
                      }
                  } else {
                      count = 0; 
                      break;
                  }
              }
          }
      }
      return false; 
  }
  public boolean checkVerticalWin(String symbol) {
      int count = 0;
      for (int i = 0; i < grid[0].length; i++) {
          for (int j = 0; j <= grid.length - win_condition; j++) {
              for (int k = 0; k < win_condition; k++) {
                  if (grid[j + k][i].equals(symbol)) {
                      count++;
                      if (count == win_condition) {
                          return true;
                      }
                  } else {
                      count = 0;
                      break;
                  }
              }
              count = 0;
          }
      }
      return false;
  }
  public boolean column_full(int column){
    return grid[0][column] != " - ";
  }
  public int nextFreeSlot(int column){
    for (int i = grid.length - 1; i >= 0; i--){
      if (grid[i][column] == " - "){
        return i;
      }
    }
    return -1;
  }
  public void displayWinner(){
    if (checkWin() == 1)
      System.out.println(p1 + " wins!");
    else if (checkWin() == 2)
      System.out.println(p2 + " wins!");
    else if (checkWin() == 0){
      System.out.println("How did no one win?");
    }
  }
  public void displayBoard(){
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        System.out.print(grid[i][j]);
      }
      System.out.println();
    }
  }
  public void placePiece(){
    Scanner scan = new Scanner(System.in);
    int column;
    if (turn)
      System.out.println(p1 + ", enter a column: ");
    else
      System.out.println(p2 + ", enter a column: ");
    try {
      column = (scan.nextInt() - 1);
      if (column_full(column)){
        System.out.println("Column is full. Try again.");
        placePiece();
      }
      else{
        int row = nextFreeSlot(column);
        if (turn)
          grid[row][column] = p1_string;
        else
          grid[row][column] = p2_string;
        turn = !turn;
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
      System.out.println("Since you have input a number that is out of your board's bounds, you will pick another number until it is in bounds.");
      placePiece();
    }
  }
  public void playGame(){
    int winning_player = 0;
    while (winning_player == 0){
      placePiece();
      displayBoard();
      winning_player = checkWin();
    }
    displayWinner();
  }
  
  public static void main(String[] args){

  }
}

