package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        assertEquals(arb.capacity(),10);
        assertEquals(arb.fillCount(), 0);
        arb.enqueue(1);
        assertEquals(arb.fillCount(), 1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(10);
        arb.enqueue(10);
        arb.enqueue(10);
        arb.enqueue(10);
        arb.enqueue(10);
        arb.enqueue(10);
        arb.enqueue(10);
        assertEquals(arb.peek(),1);
        assertEquals(arb.fillCount(), 10);
        assertEquals(arb.dequeue(), 1);
        assertEquals(arb.dequeue(), 2);
        assertEquals(arb.dequeue(), 3);
        arb.dequeue();
    }
}
