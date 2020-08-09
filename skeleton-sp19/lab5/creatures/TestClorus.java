package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

public class TestClorus {
    @Test
    public void testColor() {
        Clorus c = new Clorus(2);
        c.move();
        assertEquals(c.energy(), 1.97,0.01);
        c.stay();
        assertEquals(c.energy(), 1.96, 0.01);
        assertEquals(new Color(34, 0, 231), c.color());
        c.replicate();
        assertEquals(c.energy(), 0.98, 0.01);
    }
}
