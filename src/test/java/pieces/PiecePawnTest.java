package pieces;

import api.IPiece;
import api.PieceColor;
import api.PieceType;
import junit.framework.TestCase;

public class PiecePawnTest extends TestCase {
	public void testCreate() {
		IPiece piecePawnWhite = new PiecePawn(PieceColor.White);
		assertEquals(PieceColor.White, piecePawnWhite.getColor());
		assertEquals(PieceType.Pawn, piecePawnWhite.getType());
		assertEquals(PieceDefault.SINGLE_PAWN_STRENGHT, piecePawnWhite
				.getPieceStrength());
		assertEquals(PieceType.Pawn.getPrintable(), piecePawnWhite
				.getPrintableRepresentation());

		IPiece piecePawnBlack = new PiecePawn(PieceColor.Black);
		assertEquals(PieceColor.Black, piecePawnBlack.getColor());
		assertEquals(PieceType.Pawn, piecePawnBlack.getType());
		assertEquals(PieceDefault.SINGLE_PAWN_STRENGHT, piecePawnBlack
				.getPieceStrength());
		assertEquals(Character.toUpperCase(PieceType.Pawn.getPrintable()),
				piecePawnBlack.getPrintableRepresentation());
	}

	public void testSetPieceState() {
		IPiece piecePawnWhite = new PiecePawn(PieceColor.White);
		piecePawnWhite.setPieceStrength(true);
		assertEquals(IPiece.SINGLE_PAWN_STRENGHT, (piecePawnWhite
				.getPieceStrength()));
		piecePawnWhite.setPieceStrength(false);
		assertEquals(IPiece.MULTIPLE_PAWN_STRENGHT, (piecePawnWhite
				.getPieceStrength()));
		piecePawnWhite.setPieceStrength(true);
		assertEquals(IPiece.SINGLE_PAWN_STRENGHT, (piecePawnWhite
				.getPieceStrength()));
	}
}