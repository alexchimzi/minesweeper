import org.example.Board;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {




    @Test
    public void testvBoardGetterAndSetter(){
        int [][] value = new int [7][7];
        Board testBoard = new Board();
        testBoard.setvBoard( value);
        Assertions.assertEquals(testBoard.getvBoard(),value);
    }
    @Test
    public void testinBoardGetterAndSetter(){
        int [][] value = new int [7][7];
        Board testBoard = new Board();
        testBoard.setInBoard( value);
        Assertions.assertEquals(testBoard.getInBoard(),value);
    }
    @Test
    public void testBombDistribution(){
        int [][] value = new int [7][7];
        Board testBoard = new Board();
        testBoard.setInBoard( value);
        Assertions.assertEquals(testBoard.getInBoard(),value);
    }
}
