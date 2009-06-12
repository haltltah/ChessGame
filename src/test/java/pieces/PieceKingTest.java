package pieces;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Square;

import api.IPiece;
import api.PieceColor;
import api.PieceType;
import junit.framework.TestCase;

public class PieceKingTest extends TestCase {

	List<Square> pieceKingAllowedPositionsOK = new ArrayList<Square>();
	List<Square> pieceKingAllowedPositionsLonger = new ArrayList<Square>();
	List<Square> pieceKingAllowedPositionsShorter = new ArrayList<Square>();
	List<Square> pieceKingAllowedePositionsDiffContent = new ArrayList<Square>();
	List<Square> pieceKingAllowedePositionsatA1 = new ArrayList<Square>();
	List<Square> pieceKingAllowedePositionsatH1 = new ArrayList<Square>();
	List<Square> pieceKingAllowedePositionsatA8 = new ArrayList<Square>();
	List<Square> pieceKingAllowedePositionsatH8 = new ArrayList<Square>();
	List<Square> pieceKingAllowedePositionsatC8 = new ArrayList<Square>();
	List<Square> pieceKingAllowedePositionsatD1 = new ArrayList<Square>();

	public void testCreate() {
		IPiece pieceKingWhite = new PieceKing(PieceColor.White);
		assertEquals(PieceColor.White, pieceKingWhite.getColor());
		assertEquals(PieceType.King, pieceKingWhite.getType());
		assertEquals(PieceDefault.KING_STRENGHT, pieceKingWhite
				.getPieceStrength());
		assertEquals(PieceType.King.getPrintable(), pieceKingWhite
				.getPrintableRepresentation());

		IPiece pieceKingBlack = new PieceKing(PieceColor.Black);
		assertEquals(PieceColor.Black, pieceKingBlack.getColor());
		assertEquals(PieceType.King, pieceKingBlack.getType());
		assertEquals(PieceDefault.KING_STRENGHT, pieceKingBlack
				.getPieceStrength());
		assertEquals(Character.toUpperCase(PieceType.King.getPrintable()),
				pieceKingBlack.getPrintableRepresentation());
	}

	public void testGetAllowedMovedForPieceType() {
		Board.setBoardPositions();
		populateAllowedPositions();

		IPiece pieceKingWhite = new PieceKing(PieceColor.White);
		pieceKingWhite.setPiecePosition(Board.boardPositions[3][3]);
		assertTrue(pieceKingAllowedPositionsOK.equals(pieceKingWhite
				.getAllowedMovedForPieceType()));
		assertTrue(pieceKingAllowedPositionsOK.equals(pieceKingWhite
				.getAllowedMovedForPieceType()));
		assertFalse(pieceKingAllowedPositionsLonger.equals(pieceKingWhite
				.getAllowedMovedForPieceType()));
		/*
		 * assertFalse(pieceKingAllowedPositionsShorter.equals(pieceKingWhite.getAllowedMovedForPieceType
		 * ()));
		 * assertFalse(pieceKingAllowedePositionsDiffContent.equals(pieceKingWhite
		 * .getAllowedMovedForPieceType()));
		 * 
		 * System.out.println("pieceKingWhitedD4"); IPiece pieceKingWhiteA1 =
		 * new PieceKing(PieceColor.White);
		 * pieceKingWhiteA1.setPiecePosition(Board.boardPositions[0][0]);
		 * assertTrue(pieceKingAllowedePositionsatA1.equals(pieceKingWhiteA1.
		 * getAllowedMovedForPieceType()));
		 * 
		 * System.out.println("pieceKingWhitedH1"); IPiece pieceKingWhiteH1 =
		 * new PieceKing(PieceColor.White);
		 * pieceKingWhiteH1.setPiecePosition(Board.boardPositions[0][7]);
		 * assertTrue(pieceKingAllowedePositionsatH1.equals(pieceKingWhiteH1.
		 * getAllowedMovedForPieceType()));
		 * 
		 * System.out.println("pieceKingWhitedA8"); IPiece pieceKingWhiteA8 =
		 * new PieceKing(PieceColor.White);
		 * pieceKingWhiteA8.setPiecePosition(Board.boardPositions[7][0]);
		 * assertTrue(pieceKingAllowedePositionsatA8.equals(pieceKingWhiteA8.
		 * getAllowedMovedForPieceType()));
		 * 
		 * System.out.println("pieceKingWhitedH8"); IPiece pieceKingWhiteH8 =
		 * new PieceKing(PieceColor.White);
		 * pieceKingWhiteH8.setPiecePosition(Board.boardPositions[7][7]);
		 * assertTrue(pieceKingAllowedePositionsatH8.equals(pieceKingWhiteH8.
		 * getAllowedMovedForPieceType()));
		 * 
		 * System.out.println("pieceKingWhitedC8"); IPiece pieceKingWhiteC8 =
		 * new PieceKing(PieceColor.White);
		 * pieceKingWhiteC8.setPiecePosition(Board.boardPositions[7][2]);
		 * assertTrue(pieceKingAllowedePositionsatC8.equals(pieceKingWhiteC8.
		 * getAllowedMovedForPieceType()));
		 * 
		 * System.out.println("pieceKingWhitedD1"); IPiece pieceKingWhiteD1 =
		 * new PieceKing(PieceColor.White);
		 * pieceKingWhiteD1.setPiecePosition(Board.boardPositions[0][3]);
		 * assertTrue(pieceKingAllowedePositionsatD1.equals(pieceKingWhiteD1.
		 * getAllowedMovedForPieceType()));
		 */
	}

	private void populateAllowedPositions() {
		pieceKingAllowedPositionsOK.add(Board.boardPositions[3][2]);
		pieceKingAllowedPositionsOK.add(Board.boardPositions[3][4]);// "e4");
		pieceKingAllowedPositionsOK.add(Board.boardPositions[2][3]);// "d3");
		pieceKingAllowedPositionsOK.add(Board.boardPositions[4][3]);// "d5");
		pieceKingAllowedPositionsOK.add(Board.boardPositions[2][2]);// "c3");
		pieceKingAllowedPositionsOK.add(Board.boardPositions[4][2]);// "c5");
		pieceKingAllowedPositionsOK.add(Board.boardPositions[2][4]);// "e3");
		pieceKingAllowedPositionsOK.add(Board.boardPositions[4][4]);// "e5");

		pieceKingAllowedPositionsLonger.add(Board.boardPositions[2][3]);// "c4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[3][4]);// "e4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[1][1]);// "b2");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[2][3]);// "d3");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[4][3]);// "d5");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[2][2]);// "c3");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[4][2]);// "c5");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[2][4]);// "e3");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[4][4]);// "e5");

		/*
		 * pieceKingAllowedPositionsShorter.add(Board.boardPositions"c4");
		 * pieceKingAllowedPositionsShorter.add(Board.boardPositions"e4");
		 * pieceKingAllowedPositionsShorter.add(Board.boardPositions"b2");
		 * pieceKingAllowedPositionsShorter.add(Board.boardPositions"d3");
		 * pieceKingAllowedPositionsShorter.add(Board.boardPositions"d5");
		 * pieceKingAllowedPositionsShorter.add(Board.boardPositions"c3");
		 * pieceKingAllowedPositionsShorter.add(Board.boardPositions"c5");
		 * pieceKingAllowedPositionsShorter.add("e5");
		 * 
		 * pieceKingAllowedePositionsDiffContent.add(Board.boardPositions"c3");
		 * pieceKingAllowedePositionsDiffContent.add(Board.boardPositions"d3");
		 * pieceKingAllowedePositionsDiffContent.add(Board.boardPositions"e3");
		 * pieceKingAllowedePositionsDiffContent.add(Board.boardPositions"c4");
		 * pieceKingAllowedePositionsDiffContent.add(Board.boardPositions"f4");
		 * pieceKingAllowedePositionsDiffContent.add(Board.boardPositions"c5");
		 * pieceKingAllowedePositionsDiffContent.add(Board.boardPositions"d5");
		 * pieceKingAllowedePositionsDiffContent.add(Board.boardPositions"e5");
		 * 
		 * pieceKingAllowedePositionsatA1.add(Board.boardPositions"b1");
		 * pieceKingAllowedePositionsatA1.add(Board.boardPositions"a2");
		 * pieceKingAllowedePositionsatA1.add(Board.boardPositions"b2");
		 * 
		 * pieceKingAllowedePositionsatH1.add(Board.boardPositions"g1");
		 * pieceKingAllowedePositionsatH1.add(Board.boardPositions"h2");
		 * pieceKingAllowedePositionsatH1.add(Board.boardPositions"g2");
		 * 
		 * pieceKingAllowedePositionsatA8.add(Board.boardPositions"b8");
		 * pieceKingAllowedePositionsatA8.add(Board.boardPositions"a7");
		 * pieceKingAllowedePositionsatA8.add(Board.boardPositions"b7");
		 * 
		 * pieceKingAllowedePositionsatH8.add(Board.boardPositions"g8");
		 * pieceKingAllowedePositionsatH8.add(Board.boardPositions"h7");
		 * pieceKingAllowedePositionsatH8.add(Board.boardPositions"g7");
		 * 
		 * pieceKingAllowedePositionsatC8.add(Board.boardPositions"b8");
		 * pieceKingAllowedePositionsatC8.add(Board.boardPositions"d8");
		 * pieceKingAllowedePositionsatC8.add(Board.boardPositions"c7");
		 * pieceKingAllowedePositionsatC8.add(Board.boardPositions"b7");
		 * pieceKingAllowedePositionsatC8.add(Board.boardPositions"d7");
		 * 
		 * pieceKingAllowedePositionsatD1.add(Board.boardPositions"c1");
		 * pieceKingAllowedePositionsatD1.add(Board.boardPositions"e1");
		 * pieceKingAllowedePositionsatD1.add(Board.boardPositions"d2");
		 * pieceKingAllowedePositionsatD1.add(Board.boardPositions"c2");
		 * pieceKingAllowedePositionsatD1.add(Board.boardPositions"e2");
		 */
	}
}
