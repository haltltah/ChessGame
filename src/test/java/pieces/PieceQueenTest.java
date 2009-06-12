package pieces;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Square;

import api.IPiece;
import api.PieceColor;
import api.PieceType;
import junit.framework.TestCase;

public class PieceQueenTest extends TestCase {

	List<Square> pieceQueenAllowedPositionsOK = new ArrayList<Square>();
	List<Square> pieceKingAllowedPositionsLonger = new ArrayList<Square>();
	List<Square> pieceKingAllowedPositionsShorter = new ArrayList<Square>();
	List<Square> pieceQueenAllowedePositionsDiffContent = new ArrayList<Square>();
	List<Square> pieceQueenAllowedePositionsatA1 = new ArrayList<Square>();

	/*
	 * List<Square> pieceQueenAllowedePositionsatH1 = new ArrayList<Square>();
	 * List<Square> pieceQueenAllowedePositionsatA8 = new ArrayList<Square>();
	 * List<Square> pieceQueenAllowedePositionsatH8 = new ArrayList<Square>();
	 * List<Square> pieceQueenAllowedePositionsatC8 = new ArrayList<Square>();
	 * List<Square> pieceQueenAllowedePositionsatD1 = new ArrayList<Square>();
	 */

	public void testCreate() {
		IPiece pieceQueenWhite = new PieceQueen(PieceColor.White);
		assertEquals(PieceColor.White, pieceQueenWhite.getColor());
		assertEquals(PieceType.Queen, pieceQueenWhite.getType());
		assertEquals(PieceDefault.QUEEN_STRENGHT, pieceQueenWhite
				.getPieceStrength());
		assertEquals(PieceType.Queen.getPrintable(), pieceQueenWhite
				.getPrintableRepresentation());

		IPiece pieceQueenBlack = new PieceQueen(PieceColor.Black);
		assertEquals(PieceColor.Black, pieceQueenBlack.getColor());
		assertEquals(PieceType.Queen, pieceQueenBlack.getType());
		assertEquals(PieceDefault.QUEEN_STRENGHT, pieceQueenBlack
				.getPieceStrength());
		assertEquals(Character.toUpperCase(PieceType.Queen.getPrintable()),
				pieceQueenBlack.getPrintableRepresentation());
	}

	public void testSetPieceState() {
		IPiece pieceQueenWhite = new PieceQueen(PieceColor.White);
		pieceQueenWhite.setPieceStrength(true);
		assertEquals(IPiece.QUEEN_STRENGHT,
				(pieceQueenWhite.getPieceStrength()));
		pieceQueenWhite.setPieceStrength(false);
		assertEquals(IPiece.QUEEN_STRENGHT,
				(pieceQueenWhite.getPieceStrength()));
		pieceQueenWhite.setPieceStrength(true);
		assertEquals(IPiece.QUEEN_STRENGHT,
				(pieceQueenWhite.getPieceStrength()));
	}

	public void testSetGetPiecePosition() {
		IPiece pieceQueenWhite = new PieceQueen(PieceColor.White);
		pieceQueenWhite.setPiecePosition(Board.boardPositions[0][7]);
		assertEquals(Board.boardPositions[0][7], pieceQueenWhite
				.getPiecePosition());
	}

	public void testGetAllowedMovedForPieceType() {
		Board.setBoardPositions();
		populateAllowedPositions();
		IPiece queen1 = new PieceQueen(PieceColor.White);
		queen1.setPiecePosition(Board.boardPositions[3][3]);

		assertTrue(pieceQueenAllowedPositionsOK.equals(queen1
				.getAllowedMovedForPieceType()));

		assertFalse(pieceKingAllowedPositionsLonger.equals(queen1
				.getAllowedMovedForPieceType()));

		assertFalse(pieceKingAllowedPositionsShorter.equals(queen1
				.getAllowedMovedForPieceType()));

		System.out.println("queenA1");
		IPiece queenA1 = new PieceQueen(PieceColor.White);
		queenA1.setPiecePosition(Board.boardPositions[0][0]);
		List<Square> temp = new ArrayList<Square>();
		temp = queenA1.getAllowedMovedForPieceType();
		System.out.println("in test queesnA1 allowed pos obatined");
		for (Square s : temp)
			System.out.println(s.getSquareName() + " ");
		assertTrue(pieceQueenAllowedePositionsatA1.equals(temp));

		/*
		 * System.out.println("queenH1"); IPiece queenH1 = new
		 * PieceQueen(PieceColor.White);
		 * queenH1.setPiecePosition(Board.boardPositions[0][7]);
		 * assertTrue(pieceQueenAllowedePositionsatH1
		 * .equals(queenH1.getAllowedMovedForPieceType()));
		 * 
		 * System.out.println("queenC8"); IPiece queenC8 = new
		 * PieceQueen(PieceColor.White);
		 * queenC8.setPiecePosition(Board.boardPositions[7][2]);
		 * assertTrue(pieceQueenAllowedePositionsatC8
		 * .equals(queenC8.getAllowedMovedForPieceType())); /IPiece queen2 = new
		 * PieceQueen(PieceColor.White); queen2.setPiecePosition(3, 3);
		 * assertTrue
		 * (pieceQueenAllowedPositionsOK.equals(queen2.getAllowedMovedForPieceType
		 * ()));
		 */
	}

	private void populateAllowedPositions() {
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[3][2]);// "c4");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[3][1]);// "b4");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[3][0]);// "a4");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[3][4]);// "e4");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[3][5]);// "f4");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[3][6]);// "g4");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[3][7]);// "h4");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[2][3]);// "d3");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[1][3]);// "d2");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[0][3]);// "d1");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[4][3]);// "d5");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[5][3]);// "d6");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[6][3]);// "d7");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[7][3]);// "d8");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[2][2]);// "c3");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[1][1]);// "b2");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[0][0]);// "a1");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[4][2]);// "c5");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[5][1]);// "b6");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[6][0]);// "a7");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[2][4]);// "e3");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[1][5]);// "f2");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[0][6]);// "g1");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[4][4]);// "e5");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[5][5]);// "f6");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[6][6]);// "g7");
		pieceQueenAllowedPositionsOK.add(Board.boardPositions[7][7]);// "h8");

		pieceKingAllowedPositionsLonger.add(Board.boardPositions[3][2]);// "c4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[3][1]);// "b4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[3][0]);// "a4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[3][4]);// "e4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[3][5]);// "f4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[3][6]);// "g4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[3][7]);// "h4");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[2][3]);// "d3");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[1][3]);// "d2");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[0][3]);// "d1");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[4][3]);// "d5");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[5][3]);// "d6");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[5][3]);// "d6");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[6][3]);// "d7");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[7][3]);// "d8");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[2][2]);// "c3");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[1][1]);// "b2");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[0][0]);// "a1");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[4][2]);// "c5");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[5][1]);// "b6");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[6][0]);// "a7");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[2][4]);// "e3");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[1][5]);// "f2");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[0][6]);// "g1");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[4][4]);// "e5");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[5][5]);// "f6");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[6][6]);// "g7");
		pieceKingAllowedPositionsLonger.add(Board.boardPositions[7][7]);// "h8");

		pieceKingAllowedPositionsShorter.add(Board.boardPositions[6][6]);// "g7");
		pieceKingAllowedPositionsShorter.add(Board.boardPositions[7][7]);// "h8");

		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[0][1]);// "b1");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[0][2]);// "c1");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[0][3]);// "d1");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[0][4]);// "e1");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[0][5]);// "f1");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[0][6]);// "g1");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[0][7]);// "h1");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[1][0]);// "a2");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[2][0]);// "a3");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[3][0]);// "a4");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[4][0]);// "a5");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[5][0]);// "a6");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[6][0]);// "a7");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[7][0]);// "a8");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[1][1]);// "b2");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[2][2]);// "c3");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[3][3]);// "d4");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[4][4]);// "e5");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[5][5]);// "f6");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[6][6]);// "g7");
		pieceQueenAllowedePositionsatA1.add(Board.boardPositions[7][7]);// "h8");

		/*
		 * pieceQueenAllowedePositionsatH1.add("g1");
		 * pieceQueenAllowedePositionsatH1.add("f1");
		 * pieceQueenAllowedePositionsatH1.add("e1");
		 * pieceQueenAllowedePositionsatH1.add("d1");
		 * pieceQueenAllowedePositionsatH1.add("c1");
		 * pieceQueenAllowedePositionsatH1.add("b1");
		 * pieceQueenAllowedePositionsatH1.add("a1");
		 * pieceQueenAllowedePositionsatH1.add("h2");
		 * pieceQueenAllowedePositionsatH1.add("h3");
		 * pieceQueenAllowedePositionsatH1.add("h4");
		 * pieceQueenAllowedePositionsatH1.add("h5");
		 * pieceQueenAllowedePositionsatH1.add("h6");
		 * pieceQueenAllowedePositionsatH1.add("h7");
		 * pieceQueenAllowedePositionsatH1.add("h8");
		 * pieceQueenAllowedePositionsatH1.add("g2");
		 * pieceQueenAllowedePositionsatH1.add("f3");
		 * pieceQueenAllowedePositionsatH1.add("e4");
		 * pieceQueenAllowedePositionsatH1.add("d5");
		 * pieceQueenAllowedePositionsatH1.add("c6");
		 * pieceQueenAllowedePositionsatH1.add("b7");
		 * pieceQueenAllowedePositionsatH1.add("a8");
		 * 
		 * pieceQueenAllowedePositionsatC8.add("b8");
		 * pieceQueenAllowedePositionsatC8.add("a8");
		 * pieceQueenAllowedePositionsatC8.add("d8");
		 * pieceQueenAllowedePositionsatC8.add("e8");
		 * pieceQueenAllowedePositionsatC8.add("f8");
		 * pieceQueenAllowedePositionsatC8.add("g8");
		 * pieceQueenAllowedePositionsatC8.add("h8");
		 * pieceQueenAllowedePositionsatC8.add("c7");
		 * pieceQueenAllowedePositionsatC8.add("c6");
		 * pieceQueenAllowedePositionsatC8.add("c5");
		 * pieceQueenAllowedePositionsatC8.add("c4");
		 * pieceQueenAllowedePositionsatC8.add("c3");
		 * pieceQueenAllowedePositionsatC8.add("c2");
		 * pieceQueenAllowedePositionsatC8.add("c1");
		 * pieceQueenAllowedePositionsatC8.add("b7");
		 * pieceQueenAllowedePositionsatC8.add("a6");
		 * pieceQueenAllowedePositionsatC8.add("d7");
		 * pieceQueenAllowedePositionsatC8.add("e6");
		 * pieceQueenAllowedePositionsatC8.add("f5");
		 * pieceQueenAllowedePositionsatC8.add("g4");
		 * pieceQueenAllowedePositionsatC8.add("h3");
		 */
	}
}
