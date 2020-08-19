import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Game go = new Game(sc);
        
        go.getBoard().placeStone(1, 3, 2);
        go.getBoard().placeStone(1, 4, 1);
        go.getBoard().placeStone(1, 13, 1);
        go.getBoard().placeStone(1, 14, 1);
        go.getBoard().placeStone(1, 15, 2);
        go.getBoard().placeStone(1, 17, 2);

        go.getBoard().placeStone(2, 2, 2);
        go.getBoard().placeStone(2, 3, 2);
        go.getBoard().placeStone(2, 4, 1);
        go.getBoard().placeStone(2, 5, 1);
        go.getBoard().placeStone(2, 10, 1);
        go.getBoard().placeStone(2, 11, 1);
        go.getBoard().placeStone(2, 13, 1);
        go.getBoard().placeStone(2, 14, 2);
        go.getBoard().placeStone(2, 15, 2);
        go.getBoard().placeStone(2, 17, 2);

        go.getBoard().placeStone(3, 4, 2);
        go.getBoard().placeStone(3, 5, 1);
        go.getBoard().placeStone(3, 6, 1);
        go.getBoard().placeStone(3, 7, 1);
        go.getBoard().placeStone(3, 8, 1);
        go.getBoard().placeStone(3, 9, 1);
        go.getBoard().placeStone(3, 10, 2);
        go.getBoard().placeStone(3, 11, 2);
        go.getBoard().placeStone(3, 12, 1);
        go.getBoard().placeStone(3, 13, 1);
        go.getBoard().placeStone(3, 14, 1);
        go.getBoard().placeStone(3, 15, 1);
        go.getBoard().placeStone(3, 16, 2);
        go.getBoard().placeStone(3, 17, 2);
        go.getBoard().placeStone(3, 18, 2);
        go.getBoard().placeStone(3, 19, 2);

        go.getBoard().placeStone(4, 1, 2);
        go.getBoard().placeStone(4, 3, 2);
        go.getBoard().placeStone(4, 4, 2);
        go.getBoard().placeStone(4, 6, 1);
        go.getBoard().placeStone(4, 7, 2);
        go.getBoard().placeStone(4, 8, 1);
        go.getBoard().placeStone(4, 9, 2);
        go.getBoard().placeStone(4, 11, 2);
        go.getBoard().placeStone(4, 12, 1);
        go.getBoard().placeStone(4, 14, 2);
        go.getBoard().placeStone(4, 15, 2);
        go.getBoard().placeStone(4, 16, 1);
        go.getBoard().placeStone(4, 17, 1);
        go.getBoard().placeStone(4, 18, 1);
        go.getBoard().placeStone(4, 19, 2);

        go.getBoard().placeStone(5, 2, 2);
        go.getBoard().placeStone(5, 5, 2);
        go.getBoard().placeStone(5, 6, 1);
        go.getBoard().placeStone(5, 7, 2);
        go.getBoard().placeStone(5, 9, 2);
        go.getBoard().placeStone(5, 10, 2);
        go.getBoard().placeStone(5, 11, 2);
        go.getBoard().placeStone(5, 12, 1);
        go.getBoard().placeStone(5, 14, 2);
        go.getBoard().placeStone(5, 16, 2);
        go.getBoard().placeStone(5, 17, 1);
        go.getBoard().placeStone(5, 19, 1);

        go.getBoard().placeStone(6, 3, 2);
        go.getBoard().placeStone(6, 5, 2);
        go.getBoard().placeStone(6, 6, 2);
        go.getBoard().placeStone(6, 7, 2);
        go.getBoard().placeStone(6, 8, 2);
        go.getBoard().placeStone(6, 9, 2);
        go.getBoard().placeStone(6, 10, 1);
        go.getBoard().placeStone(6, 11, 1);
        go.getBoard().placeStone(6, 12, 1);
        go.getBoard().placeStone(6, 14, 2);
        go.getBoard().placeStone(6, 15, 2);
        go.getBoard().placeStone(6, 16, 2);
        go.getBoard().placeStone(6, 17, 1);
        go.getBoard().placeStone(6, 18, 1);
        go.getBoard().placeStone(6, 19, 1);

        go.getBoard().placeStone(7, 4, 2);
        go.getBoard().placeStone(7, 5, 1);
        go.getBoard().placeStone(7, 6, 1);
        go.getBoard().placeStone(7, 7, 1);
        go.getBoard().placeStone(7, 8, 1);
        go.getBoard().placeStone(7, 9, 1);
        go.getBoard().placeStone(7, 10, 1);
        go.getBoard().placeStone(7, 11, 1);
        go.getBoard().placeStone(7, 12, 1);
        go.getBoard().placeStone(7, 14, 2);
        go.getBoard().placeStone(7, 15, 1);
        go.getBoard().placeStone(7, 16, 1);
        go.getBoard().placeStone(7, 17, 1);

        go.getBoard().placeStone(8, 1, 1);
        go.getBoard().placeStone(8, 3, 2);
        go.getBoard().placeStone(8, 4, 1);
        go.getBoard().placeStone(8, 5, 1);
        go.getBoard().placeStone(7, 5, 1);
        go.getBoard().placeStone(8, 7, 1);
        go.getBoard().placeStone(8, 8, 2);
        go.getBoard().placeStone(8, 9, 2);
        go.getBoard().placeStone(8, 10, 1);
        go.getBoard().placeStone(8, 11, 2);
        go.getBoard().placeStone(8, 12, 1);
        go.getBoard().placeStone(8, 14, 2);
        go.getBoard().placeStone(8, 15, 2);
        go.getBoard().placeStone(8, 16, 1);
        go.getBoard().placeStone(8, 17, 1);
        go.getBoard().placeStone(8, 18, 1);
        go.getBoard().placeStone(8, 19, 1);

        go.getBoard().placeStone(9, 1, 1);
        go.getBoard().placeStone(9, 3, 2);
        go.getBoard().placeStone(9, 4, 2);
        go.getBoard().placeStone(9, 5, 1);
        go.getBoard().placeStone(9, 6, 1);
        go.getBoard().placeStone(9, 7, 1);
        go.getBoard().placeStone(9, 8, 1);
        go.getBoard().placeStone(9, 9, 2);
        go.getBoard().placeStone(9, 10, 2);
        go.getBoard().placeStone(9, 11, 2);
        go.getBoard().placeStone(9, 12, 1);
        go.getBoard().placeStone(9, 13, 1);
        go.getBoard().placeStone(9, 14, 2);
        go.getBoard().placeStone(9, 16, 2);
        go.getBoard().placeStone(9, 17, 2);
        go.getBoard().placeStone(9, 18, 1);
        go.getBoard().placeStone(9, 19, 2);
        
        go.getBoard().placeStone(10, 4, 2);
        go.getBoard().placeStone(10, 5, 2);
        go.getBoard().placeStone(10, 6, 2);
        go.getBoard().placeStone(10, 7, 2);
        go.getBoard().placeStone(10, 8, 2);
        go.getBoard().placeStone(10, 12, 2);
        go.getBoard().placeStone(10, 13, 1);
        go.getBoard().placeStone(10, 14, 2);
        go.getBoard().placeStone(10, 15, 2);
        go.getBoard().placeStone(10, 17, 2);
        go.getBoard().placeStone(10, 18, 2);

        go.getBoard().placeStone(11, 2, 2);
        go.getBoard().placeStone(11, 4, 2);
        go.getBoard().placeStone(11, 5, 2);
        go.getBoard().placeStone(11, 8, 2);
        go.getBoard().placeStone(11, 9, 2);
        go.getBoard().placeStone(11, 10, 2);
        go.getBoard().placeStone(11, 11, 2);
        go.getBoard().placeStone(11, 12, 2);
        go.getBoard().placeStone(11, 13, 1);
        go.getBoard().placeStone(11, 14, 1);
        go.getBoard().placeStone(11, 15, 2);
        go.getBoard().placeStone(11, 17, 2);
        go.getBoard().placeStone(11, 18, 2);

        go.getBoard().placeStone(12, 3, 2);
        go.getBoard().placeStone(12, 4, 1);
        go.getBoard().placeStone(12, 5, 2);
        go.getBoard().placeStone(12, 6, 2);
        go.getBoard().placeStone(12, 7, 2);
        go.getBoard().placeStone(12, 8, 1);
        go.getBoard().placeStone(12, 9, 1);
        go.getBoard().placeStone(12, 10, 1);
        go.getBoard().placeStone(12, 11, 1);
        go.getBoard().placeStone(12, 12, 2);
        go.getBoard().placeStone(12, 13, 2);
        go.getBoard().placeStone(12, 15, 2);
        go.getBoard().placeStone(12, 17, 2);

        go.getBoard().placeStone(13, 1, 2);
        go.getBoard().placeStone(13, 3, 2);
        go.getBoard().placeStone(13, 4, 1);
        go.getBoard().placeStone(13, 5, 2);
        go.getBoard().placeStone(13, 6, 2);
        go.getBoard().placeStone(13, 7, 1);
        go.getBoard().placeStone(13, 8, 1);
        go.getBoard().placeStone(13, 11, 1);
        go.getBoard().placeStone(13, 12, 1);
        go.getBoard().placeStone(13, 13, 2);
        go.getBoard().placeStone(13, 14, 2);
        go.getBoard().placeStone(13, 16, 2);
        go.getBoard().placeStone(13, 17, 1);
        go.getBoard().placeStone(13, 18, 2);
        go.getBoard().placeStone(13, 19, 2);

        go.getBoard().placeStone(14, 1, 1);
        go.getBoard().placeStone(14, 2, 2);
        go.getBoard().placeStone(14, 3, 2);
        go.getBoard().placeStone(14, 4, 1);
        go.getBoard().placeStone(14, 6, 2);
        go.getBoard().placeStone(14, 7, 1);
        go.getBoard().placeStone(14, 8, 1);
        go.getBoard().placeStone(14, 9, 1);
        go.getBoard().placeStone(14, 10, 2);
        go.getBoard().placeStone(14, 13, 1);
        go.getBoard().placeStone(14, 14, 2);
        go.getBoard().placeStone(14, 15, 2);
        go.getBoard().placeStone(14, 16, 2);
        go.getBoard().placeStone(14, 17, 1);
        go.getBoard().placeStone(14, 18, 1);
        go.getBoard().placeStone(14, 19, 1);

        go.getBoard().placeStone(15, 1, 1);
        go.getBoard().placeStone(15, 2, 1);
        go.getBoard().placeStone(15, 3, 1);
        go.getBoard().placeStone(15, 4, 1);
        go.getBoard().placeStone(15, 5, 1);
        go.getBoard().placeStone(15, 6, 2);
        go.getBoard().placeStone(15, 7, 2);
        go.getBoard().placeStone(15, 8, 2);
        go.getBoard().placeStone(15, 9, 2);
        go.getBoard().placeStone(15, 10, 1);
        go.getBoard().placeStone(15, 11, 1);
        go.getBoard().placeStone(15, 13, 1);
        go.getBoard().placeStone(15, 14, 2);
        go.getBoard().placeStone(15, 15, 1);
        go.getBoard().placeStone(15, 16, 2);
        go.getBoard().placeStone(15, 17, 1);

        go.getBoard().placeStone(16, 4, 1);
        go.getBoard().placeStone(16, 5, 2);
        go.getBoard().placeStone(16, 6, 2);
        go.getBoard().placeStone(16, 10, 2);
        go.getBoard().placeStone(16, 11, 1);
        go.getBoard().placeStone(16, 14, 1);
        go.getBoard().placeStone(16, 15, 1);
        go.getBoard().placeStone(16, 16, 1);

        go.getBoard().placeStone(17, 3, 1);
        go.getBoard().placeStone(17, 5, 1);
        go.getBoard().placeStone(17, 6, 1);
        go.getBoard().placeStone(17, 7, 2);
        go.getBoard().placeStone(17, 8, 2);
        go.getBoard().placeStone(17, 10, 2);
        go.getBoard().placeStone(17, 11, 2);
        go.getBoard().placeStone(17, 12, 1);
        go.getBoard().placeStone(17, 13, 1);
        go.getBoard().placeStone(17, 16, 1);
        go.getBoard().placeStone(17, 18, 1);

        go.getBoard().placeStone(18, 6, 1);
        go.getBoard().placeStone(18, 7, 1);
        go.getBoard().placeStone(18, 8, 2);
        go.getBoard().placeStone(18, 9, 2);
        go.getBoard().placeStone(18, 10, 1);
        go.getBoard().placeStone(18, 11, 1);
        go.getBoard().placeStone(18, 12, 1);
        
        go.getBoard().placeStone(19, 6, 1);
        go.getBoard().placeStone(19, 7, 2);
        go.getBoard().placeStone(19, 8, 2);
        go.getBoard().placeStone(19, 9, 1);
        go.getBoard().placeStone(19, 10, 1);
        


        




        go.getBoard().printBoard();
        go.game();
    }

}