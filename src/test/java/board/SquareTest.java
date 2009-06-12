/**
 * 
 */
package board;

import junit.framework.TestCase;

/**
 * @author hirian
 * 
 */
public class SquareTest extends TestCase {
	public void testSquare() {
		Square sq = new Square("a1", 0, 0);
		assertEquals("a1", sq.getSquareName());
		assertEquals(0, sq.getSquareRow());
		assertEquals(0, sq.getSquareColumn());
	}
}
