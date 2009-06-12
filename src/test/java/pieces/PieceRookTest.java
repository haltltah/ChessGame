package pieces;

import api.IPiece;
import api.PieceColor;
import api.PieceType;
import junit.framework.TestCase;

public class PieceRookTest extends TestCase {
	public void testCreate() {
		IPiece pieceRookWhite = new PieceRook(PieceColor.White);
		assertEquals(PieceColor.White, pieceRookWhite.getColor());
		assertEquals(PieceType.Rook, pieceRookWhite.getType());
		assertEquals(PieceDefault.ROOK_STRENGHT, pieceRookWhite
				.getPieceStrength());
		assertEquals(PieceType.Rook.getPrintable(), pieceRookWhite
				.getPrintableRepresentation());

		IPiece pieceRookBlack = new PieceRook(PieceColor.Black);
		assertEquals(PieceColor.Black, pieceRookBlack.getColor());
		assertEquals(PieceType.Rook, pieceRookBlack.getType());
		assertEquals(PieceDefault.ROOK_STRENGHT, pieceRookBlack
				.getPieceStrength());
		assertEquals(Character.toUpperCase(PieceType.Rook.getPrintable()),
				pieceRookBlack.getPrintableRepresentation());
	}
}