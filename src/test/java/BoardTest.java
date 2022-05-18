import org.example.Board;
import org.example.Tile;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {


    @Test
    public void testTile(){
        Tile t = new Tile();
        Assertions.assertFalse( t.getFlag());
    }




}
