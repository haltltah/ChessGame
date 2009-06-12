/**
 * 
 */
package api;

import junit.framework.TestCase;

/**
 * @author hirian
 * 
 */
public class PieceTypeTest extends TestCase {
	public void testCreate() {
		assertEquals('p', PieceType.Pawn.getPrintable());
		assertEquals('q', PieceType.Queen.getPrintable());
		assertEquals('k', PieceType.King.getPrintable());
		assertEquals('n', PieceType.Knight.getPrintable());
		assertEquals('r', PieceType.Rook.getPrintable());
		assertEquals('b', PieceType.Bishop.getPrintable());

	}

}
