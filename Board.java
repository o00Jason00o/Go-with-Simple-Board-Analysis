/**
 * A class that represents the go! board
 * 
 * @author Jason Chen
 * @date 4/29/2020
 */


import java.util.*;
public class Board {

    private int[][] board;

    /**
    *Constructor, create a 19*19 2D int *array with 0s
    */
    public Board(){
        board = new int[19][19];
    }

    /**
     * Getter of the game board
     * @return the board
     */
    public int[][] getBoard(){
      return board;
    }

    /**
     * Copy another board to the current board
     * @param target
     */
    public void copy(int[][] target){
      board = target;
    }

    /**
     * The getter of a box
     * @param h The horizontal position of the box
     * @param v The vertical position of the box
     * @return the int value of the box
     */
    public int getBox(int h, int v){
        return board[h - 1][v - 1];
    }

    /**
     * Converts the int box to stone/mark
     * @param h The horizontal position of the box
     * @param v The vertical position of the box
     * @return The stone
     */
    private String getStone(int h, int v){
        if(this.getBox(h , v) == 1)
          return "⚫";
        if(this.getBox(h , v) == 2)
          return "⚪";
        if(this.getBox(h , v) == -1)
          return " ◍";
        if(this.getBox(h , v) == 3)
          return " ○";
        if(this.getBox(h , v) == 4)
          return " ●";
        return " ";
    }
    
    /**
     * Removes the stone from the box / setting the box value to 0
     * @param h The horizontal position of the box
     * @param v The vertical position of the box
     */
    public void removeStone(int h, int v){
        if((h == 4 || h == 16 || h == 10) && (v == 4 || v == 16 || v == 10))
          board[h - 1][v - 1] = -1;
        else
          board[h - 1][v - 1] = 0;
    }

    /**
     * Place a stone and check if any enemy piece should be removed
     * @param h The horizontal position of the box to be placed
     * @param v The vertical position of the box to be placed
     * @param color
     */
    public void placeStone(int h, int v, int color){
        board[h - 1][v - 1] = color;
        checkForEnemyRemove(h, v);
        /*if(isSurrounded(h, v, color)){
          ArrayList<ArrayList<Integer>> group = findGroup(h, v, color, new ArrayList<ArrayList<Integer>>());
          for(ArrayList<Integer> i: group){
            removeStone(i.get(0), i.get(1));
          }
        };*/
    }

    /**
     * Remove the stones surrounded after a stone is placed in the box
     * @param h The horizontal position of the box to be placed
     * @param v The vertical position of the box to be placed
     */
    private void checkForEnemyRemove(int h, int v){
        int player = this.getBox(h, v);
        if(player == 1){
          if(v < 19 && getBox(h, v + 1) == 2){ //checks the right
            if(isSurrounded(h, v + 1, 2)){
              ArrayList<ArrayList<Integer>> group = findGroup(h, v + 1, 2, new ArrayList<ArrayList<Integer>>());
              removeGroup(group);
              //System.out.println("removed group from " + h + " " + (v + 1));
            }
          }

          if(v > 1 && getBox(h, v - 1) == 2){ //checks the left
            if(isSurrounded(h, v - 1, 2)){
              ArrayList<ArrayList<Integer>> group = findGroup(h, v - 1, 2, new ArrayList<ArrayList<Integer>>());
              removeGroup(group);
              //System.out.println("removed group from " + h + " " + (v - 1));
            }
          }

          if(h < 19 && getBox(h + 1, v) == 2){ //checks the top
            if(isSurrounded(h + 1, v, 2)){
              ArrayList<ArrayList<Integer>> group = findGroup(h + 1, v, 2, new ArrayList<ArrayList<Integer>>());
              removeGroup(group);
              //System.out.println("removed group from " + (h + 1) + " " + v);
            }
          } 

          if(h > 1 && getBox(h - 1, v) == 2){ //checks the bottom
            if(isSurrounded(h - 1, v, 2)){
              ArrayList<ArrayList<Integer>> group = findGroup(h - 1, v, 2, new ArrayList<ArrayList<Integer>>());
              removeGroup(group);
              //System.out.println("removed group from " + (h - 1) + " " + v);
            }
          }
        }

        if(player == 2){ //samething as above but for a different player
          if(v < 19 && getBox(h, v + 1) == 1){
            if(isSurrounded(h, v + 1, 1)){
              ArrayList<ArrayList<Integer>> group = findGroup(h, v + 1, 1, new ArrayList<ArrayList<Integer>>());
              removeGroup(group);
              //System.out.println("removed group from " + h + " " + (v + 1));
            }
          }

          if(v > 1 && getBox(h, v - 1) == 1){
            if(isSurrounded(h, v - 1, 1)){
              ArrayList<ArrayList<Integer>> group = findGroup(h, v - 1, 1, new ArrayList<ArrayList<Integer>>());
              removeGroup(group);
              //System.out.println("removed group from " + h + " " + (v - 1));
            }
          }

          if(h < 19 && getBox(h + 1, v) == 1){
            if(isSurrounded(h + 1, v, 1)){
              ArrayList<ArrayList<Integer>> group = findGroup(h + 1, v, 1, new ArrayList<ArrayList<Integer>>());
              removeGroup(group);
              //System.out.println("removed group from " + (h + 1) + " " + v);
            }
          } 

          if(h > 1 && getBox(h - 1, v) == 1){
            if(isSurrounded(h - 1, v, 1)){
              ArrayList<ArrayList<Integer>> group = findGroup(h - 1, v, 1, new ArrayList<ArrayList<Integer>>());
              removeGroup(group);
              
            }
          }
        }
    }

    /**
     * Removes a group of stones
     * @param group A 2D Integer ArrayList containing the stones to be removed in [h, v] form
     */
    public void removeGroup(ArrayList<ArrayList<Integer>> group){
      for(ArrayList<Integer> i: group){
        removeStone(i.get(0), i.get(1));
      }
    }

    /**
     * Check if the stone should be removed
     * @param h The horizontal value of the stone
     * @param v The vertical value of the stone
     * @param color The color of the stone
     * @return If the stone should be removed
     */
    public boolean isSurrounded(int h, int v, int color){
      boolean output = true;
      ArrayList<ArrayList<Integer>> group = new ArrayList<ArrayList<Integer>>();
      findGroup(h, v, color, group);
      for(ArrayList<Integer> i: group){
        int hori = i.get(0);
        int vert = i.get(1);
        if(vert < 19 && getBox(hori, vert + 1) <= 0) //right
          output = false;
        if(vert > 1 && getBox(hori, vert - 1) <= 0) //left
          output = false;
        if(hori < 19 && getBox(hori + 1, vert) <= 0) //top
          output = false;
        if(hori > 1 && getBox(hori - 1, vert) <= 0) //bottom
          output = false;
        //if(!(getBox(h, v + 1) <= 0 && getBox(h, v - 1) <= 0 && getBox(h + 1, v) <= 0 && getBox(h - 1, v) <= 0))
          //output = false;
      }
      return output;
    }
    
    /**
     * A recurrsive method that find all the connected pieces 
     * @param h The horizontal value to be checked
     * @param v The vertical value to be checked
     * @param color The color of the pieces
     * @param searched A list containing all the searched coordinates
     * @return The position of all the connected pieces
     */
    public ArrayList<ArrayList<Integer>> findGroup(int h, int v, int color, ArrayList<ArrayList<Integer>> searched){
      ArrayList<Integer> temp = new ArrayList<Integer>();
      temp.add(h);
      temp.add(v);
      searched.add(temp); //add current to searched ArrayList
      //Recurse if anything is connected and is not in searched
      if(v != 19 && this.getBox(h, v + 1) == color && !contains(searched, h, v + 1))
        findGroup(h, v + 1, color, searched);

      if(v != 1 && this.getBox(h, v - 1) == color && !contains(searched, h, v - 1))
        findGroup(h, v - 1, color, searched);

      if(h != 19 && this.getBox(h + 1, v) == color && !contains(searched, h + 1, v))
        findGroup(h + 1, v, color, searched);

      if(h != 1 && this.getBox(h - 1, v) == color && !contains(searched, h - 1, v))
        findGroup(h - 1, v, color, searched);
      return searched;
    }

    /**
     * Check if a 2D ArrayList contain a certain coordinate
     * @param searched The ArrayList to be checked
     * @param h The horizontal value
     * @param v The vertical value
     * @return If the 2D ArrayList contains the coordinate
     */
    public boolean contains(ArrayList<ArrayList<Integer>> searched, int h, int v){
      for(ArrayList<Integer> i: searched){
        if(i.get(0) == h && i.get(1) == v)
          return true;
      }
      return false;
    }

    /**
     * Prints the cureent board in the console
     */
    public void printBoard(){
        System.out.println("    1 \u2009 2 \u2009 3 \u2009 4 \u2009 5 \u2009 6 \u2009 7 \u2009 8 \u2009 9  10 " + 
                            "\u200911 \u200912 \u200913 \u200914 \u200915 \u200916 \u200917 \u200918 \u200919");
        System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        for(int h = 1; h <= board.length; h++){
          if(h < 10)
            System.out.print(h + " |");
          if(h >= 10)
            System.out.print(h + "|");
          for(int v = 1; v <= board.length; v++){
            if(getStone(h, v) == " ")
                System.out.print(getStone(h, v) + "\u2009 |");
            else
                System.out.print(getStone(h, v) + " |");
          }
          System.out.println("");
          System.out.println("  ━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        }
      }

}