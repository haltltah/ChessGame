package pieces;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Square;

import junit.framework.TestCase;
import api.IPiece;
import api.PieceColor;
import api.PieceType;

public class PieceDefaultTest extends TestCase {
	List<Square> piecenoPieceAllowedPositionsOK = new ArrayList<Square>();
	List<Square> piecenoPieceAllowedPositionsLonger = new ArrayList<Square>();
	IPiece pieceDefault;
	Board board;

	@Override
	public void setUp() {
		board = new Board();
		pieceDefault = new PieceDefault(PieceColor.No_Color);
		pieceDefault.setPiecePosition(Board.boardPositions[3][3]);
	}

	public void testCreate() {
		assertEquals(PieceColor.No_Color, pieceDefault.getColor());
		assertEquals(PieceType.No_Piece, pieceDefault.getType());
		assertEquals(PieceDefault.NO_PIECE_STRENGHT, pieceDefault
				.getPieceStrength());
		assertEquals(PieceType.No_Piece.getPrintable(), pieceDefault
				.getPrintableRepresentation());
	}

	public void testSetGetPiecePosition() {
		assertEquals(3, pieceDefault.getPiecePosition().getSquareRow());
		assertEquals(3, pieceDefault.getPiecePosition().getSquareColumn());
	}

	public void testGetAllowedMovedForPieceType() {
		// Board.setBoardPositions();
		populateAllowedPositions();
		// Square[] temp = Board.boardPositions[3];
		Square tempS = Board.boardPositions[3][3];
		piecenoPieceAllowedPositionsOK.remove(tempS);
		assertTrue(piecenoPieceAllowedPositionsOK.equals(pieceDefault
				.getAllowedMovedForPieceType()));
		assertFalse(piecenoPieceAllowedPositionsLonger.equals(pieceDefault
				.getAllowedMovedForPieceType()));
	}

	private void populateAllowedPositions() {
		int i = 0;
		for (Square[] row : Board.boardPositions) {

			for (Square pos : row) {
				piecenoPieceAllowedPositionsOK.add(pos);
				System.out.println("Populated");
				piecenoPieceAllowedPositionsLonger.add(pos);
				i++;
			}
		}
		piecenoPieceAllowedPositionsLonger.add(Board.boardPositions[2][2]);
	}
}
