package pieces;

import api.IPiece;
import api.PieceColor;
import api.PieceType;
import junit.framework.TestCase;

public class PieceKnightTest extends TestCase {
	public void testCreate() {
		IPiece pieceKinghtWhite = new PieceKnight(PieceColor.White);
		assertEquals(PieceColor.White, pieceKinghtWhite.getColor());
		assertEquals(PieceType.Knight, pieceKinghtWhite.getType());
		assertEquals(PieceDefault.KNIGHT_STRENGHT, pieceKinghtWhite
				.getPieceStrength());
		assertEquals(PieceType.Knight.getPrintable(), pieceKinghtWhite
				.getPrintableRepresentation());

		IPiece pieceKnightBlack = new PieceKnight(PieceColor.Black);
		assertEquals(PieceColor.Black, pieceKnightBlack.getColor());
		assertEquals(PieceType.Knight, pieceKnightBlack.getType());
		assertEquals(PieceDefault.KNIGHT_STRENGHT, pieceKnightBlack
				.getPieceStrength());
		assertEquals(Character.toUpperCase(PieceType.Knight.getPrintable()),
				pieceKnightBlack.getPrintableRepresentation());
	}
}