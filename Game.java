/**
 * A class that represents the game go!
 * 
 * @author Jason Chen
 * @date 4/29/2020
 */

import java.util.*;
public class Game {
    private Board goBoard;
    public static int currentPlayer;
    private boolean playing = true;
    private boolean blackTurn = true;
    private boolean whiteTurn = true;
    private static final String INVALID_INPUT = "Please enter a valid input: ";
    private Scanner sc;
    
    /**
     * The constructor of the class, initialize the board and scanner
     * @param sc The scanner to be imported
     */
    public Game(Scanner sc){
        goBoard = new Board();
        currentPlayer = 1;
        this.sc = sc;
        goBoard.placeStone(4, 4, -1); //just indicators for the players
        goBoard.placeStone(16, 4, -1);
        goBoard.placeStone(4, 16, -1);
        goBoard.placeStone(16, 16, -1);
        goBoard.placeStone(10, 10, -1);
        goBoard.placeStone(4, 10, -1);
        goBoard.placeStone(10, 4, -1);
        goBoard.placeStone(10, 16, -1);
        goBoard.placeStone(16, 10, -1);
        System.out.println("To place a stone, the player will need type the horizontal label then the vertical label of the box with a space between.\nFor example,\n1 19 will place a stone one the top right corner");
        System.out.println("Type STOP when the game is finished");
      }

    /**
     * The getter of the board
     * @return The board
     */
    public Board getBoard(){
        return goBoard;
    }

    /**
     * Initialize the game
     */
    public void game(){
        while(playing){
            if(currentPlayer == 1)
              System.out.print("black: ");
            else
              System.out.print("white: ");
            String playerMove = sc.nextLine();
            this.playerInput(playerMove);
            if(playing)
              goBoard.printBoard();
        }
        gameEnd();
    }

    /**
     * Calcultes the points and ends the game
     */
    public void gameEnd(){
      for(int h = 4; h <= 16; h = h + 6){
        for(int v = 4; v <= 16; v = v + 6){
          if(goBoard.getBox(h, v) == -1)
            goBoard.placeStone(h, v, 0); //remove the indicators for convience
        }
      }

      System.out.println("please select your died pieces (type in the position of a stone or STOP)");
      while(blackTurn){
        currentPlayer = 1;
        System.out.print("black: ");
        String playerMove = sc.nextLine();
        this.playerEndInput(playerMove);
        goBoard.printBoard();
      }// Letting the black player to remove the died pieces
      while(whiteTurn){
        currentPlayer = 2;
        System.out.print("white: ");
        String playerMove = sc.nextLine();
        this.playerEndInput(playerMove);
        goBoard.printBoard();
      }// Letting the white player to remove the died pieces
      
      for(int h = 1; h <= 19; h++){
        for(int v = 1; v <= 19; v++){
          determineBlankSpaces(h, v);//assigning the blank spaces
        }
      }
      goBoard.printBoard();
      if(calculatePoints() >= 185)
        System.out.println("black won with " + calculatePoints() + " points");
      else
        System.out.println("white won with " + (361 - calculatePoints()) + " points");
    }

    /**
     * Determine and assign the blank spaces(connected to the given coordinate) to the players
     * @param h The horizontal value of the box
     * @param v The vertical value of the box
     */
    private void determineBlankSpaces(int h, int v){
      if(goBoard.getBox(h, v) != 0)
        return;
      int blackCount = 0;
      int whiteCount = 0;
      ArrayList<ArrayList<Integer>> searched = new ArrayList<ArrayList<Integer>>();
      ArrayList<ArrayList<Integer>> group = goBoard.findGroup(h, v, 0, new ArrayList<ArrayList<Integer>>());
      for(ArrayList<Integer> blank: group){
        int hori = blank.get(0);
        int vert = blank.get(1);

        if(vert < 19 && goBoard.getBox(hori, vert + 1) > 0 && !goBoard.contains(searched, hori, vert + 1)){
          ArrayList<Integer> temp = new ArrayList<Integer>();
          temp.add(hori);
          temp.add(vert + 1);
          searched.add(temp);
        }

        if(vert > 1 && goBoard.getBox(hori, vert - 1) > 0 && !goBoard.contains(searched, hori, vert - 1)){
          ArrayList<Integer> temp = new ArrayList<Integer>();
          temp.add(hori);
          temp.add(vert - 1);
          searched.add(temp);
        }

        if(hori < 19 && goBoard.getBox(hori + 1, vert) > 0 && !goBoard.contains(searched, hori + 1, vert)){
          ArrayList<Integer> temp = new ArrayList<Integer>();
          temp.add(hori + 1);
          temp.add(vert);
          searched.add(temp);
        }

        if(hori < 1 && goBoard.getBox(hori - 1, vert) > 0 && !goBoard.contains(searched, hori - 1, vert)){
          ArrayList<Integer> temp = new ArrayList<Integer>();
          temp.add(hori - 1);
          temp.add(vert);
          searched.add(temp);
        }
      }

      for(ArrayList<Integer> cords: searched){
        if(goBoard.getBox(cords.get(0), cords.get(1)) == 1)
          blackCount++;
        if(goBoard.getBox(cords.get(0), cords.get(1)) == 2)
          whiteCount++;
      }//see which player have more occupation to the blank spot

      if(blackCount >= whiteCount){
        for(ArrayList<Integer> i: group)
          goBoard.placeStone(i.get(0), i.get(1), 3);
      }else{
        for(ArrayList<Integer> i: group)
          goBoard.placeStone(i.get(0), i.get(1), 4);
      }//assign the blanks
    }

    /**
     * Calculate the points of the player
     * @return The point black have
     */
    private int calculatePoints(){
      int blackCount = 0;
      for(int h = 1; h <= 19; h++){
        for(int v = 1; v <= 19; v++){
          if(goBoard.getBox(h, v) == 1 || goBoard.getBox(h, v) == 3)
            blackCount++;
        }
      }
      return blackCount;
    }

    /**
     * Takes in the user input and check if its valid. If it is, change the box and the player accordingly. If not, ask for a valid input
     * @param input The user input
     */
    public void playerInput(String input){
        if(input.toUpperCase().equals("STOP")){
          playing = false;
          return;
        }
        int h;
        int v;
        try{
          int spaceIndex = input.indexOf(" ");
          if (spaceIndex == -1){
            secondInput();
            return;
          }
          h = Integer.parseInt(input.substring(0, spaceIndex));
          v = Integer.parseInt(input.substring(spaceIndex + 1, input.length()));
          if(!(h >= 1) || !(h <= 19)){
            secondInput();
            return;
          }
          if(!(v >= 1) || !(v <= 19)){
            secondInput();
            return;
          }
          if(!(getBoard().getBox(h, v) <= 0)){
            secondInput();
            return;
          }
          Board temp = new Board();
          temp.copy(goBoard.getBoard());
          goBoard.placeStone(h, v, currentPlayer);
          if(temp.isSurrounded(h, v, currentPlayer)){
            secondInput();
            return;
          }

        }catch(NumberFormatException ex){
          secondInput();
          return;
        }
          goBoard.placeStone(h, v, currentPlayer);
          switchPlayer();
      }

    /**
     * Takes in the user input and check if its valid. If it is, change the box and the player accordingly. If not, ask for a valid input
     * @param input The user input
     */
    public void playerEndInput(String input){
      if(input.toUpperCase().equals("STOP")){
        if(blackTurn == true)
          blackTurn = false;
        else
          whiteTurn = false;
        return;
      }
      int h;
      int v;
      try{
        int spaceIndex = input.indexOf(" ");
        if (spaceIndex == -1){
          secondEndInput();
          return;
        }
        h = Integer.parseInt(input.substring(0, spaceIndex));
        v = Integer.parseInt(input.substring(spaceIndex + 1, input.length()));
        if(!(h >= 1) || !(h <= 19)){
          secondEndInput();
          return;
        }
        if(!(v >= 1) || !(v <= 19)){
          secondEndInput();
          return;
        }
        if(!(getBoard().getBox(h, v) > 0)){
          secondEndInput();
          return;
        }
      }catch(NumberFormatException ex){
        System.out.println("e");
        secondEndInput();
        return;
      }
      ArrayList<ArrayList<Integer>> group = goBoard.findGroup(h, v, currentPlayer, new ArrayList<ArrayList<Integer>>());
      goBoard.removeGroup(group);
    }

    /**
     * Print out that player entered a invalid input for playerInput and ask for a new one
     */
    private void secondInput(){
        System.out.print(INVALID_INPUT);
        String secondInput = sc.nextLine();
        playerInput(secondInput);
    }

    /**
     * Print out that player entered a invalid input for playerEndInput and ask for a new one
     */
    private void secondEndInput(){
      System.out.print(INVALID_INPUT);
      String secondInput = sc.nextLine();
      playerEndInput(secondInput);
    }

    /**
     * Switches the player
     */
    private void switchPlayer(){
        if(currentPlayer == 1)
            currentPlayer = 2;
        else
            currentPlayer = 1;
    }
}