package pieces;

import api.IPiece;
import api.PieceColor;
import api.PieceType;
import junit.framework.TestCase;

public class PieceBishopTest extends TestCase {
	public void testCreate() {
		IPiece pieceBishopWhite = new PieceBishop(PieceColor.White);
		assertEquals(PieceColor.White, pieceBishopWhite.getColor());
		assertEquals(PieceType.Bishop, pieceBishopWhite.getType());
		assertEquals(PieceDefault.BISHOP_STRENGHT, pieceBishopWhite
				.getPieceStrength());
		assertEquals(PieceType.Bishop.getPrintable(), pieceBishopWhite
				.getPrintableRepresentation());

		IPiece pieceBishopBlack = new PieceBishop(PieceColor.Black);
		assertEquals(PieceColor.Black, pieceBishopBlack.getColor());
		assertEquals(PieceType.Bishop, pieceBishopBlack.getType());
		assertEquals(PieceDefault.BISHOP_STRENGHT, pieceBishopBlack
				.getPieceStrength());
		assertEquals(Character.toUpperCase(PieceType.Bishop.getPrintable()),
				pieceBishopBlack.getPrintableRepresentation());
	}
}