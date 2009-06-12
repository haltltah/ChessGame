package board;

import board.Board;
import pieces.*;
import api.IBoard;
import api.PieceColor;
import api.PieceType;

import util.StringUtil;
import junit.framework.TestCase;
import static util.StringUtil.addNewLineToString;

public class BoardTest extends TestCase {
	private IBoard board;

	public void setUp() {
		board = new Board();
	}

	/*
	 * Test print and pieceCount for a default board layout
	 */
	public void testPrintAndCount() {
		assertEquals(0, board.pieceCount());
		board.initialize();

		assertEquals(32, board.pieceCount());

		String blankRank = StringUtil.addNewLineToString("........");
		assertEquals(addNewLineToString("RNBQKBNR")
				+ addNewLineToString("PPPPPPPP") + blankRank + blankRank
				+ blankRank + blankRank + addNewLineToString("pppppppp")
				+ addNewLineToString("rnbqkbnr"), board.print());
		System.out.println(board.print());
		board.setFlipedBoard(true);
		assertEquals(addNewLineToString("rnbqkbnr")
				+ addNewLineToString("pppppppp") + blankRank + blankRank
				+ blankRank + blankRank + addNewLineToString("PPPPPPPP")
				+ addNewLineToString("RNBQKBNR"), board.print());
		System.out.println("Board fliped");
		System.out.println(board.print());
	}

	/*
	 * Tests getNumberOfSpecifiedPiecesOnBoard() on board created for lesson 5,
	 * ex 7
	 */
	public void testGetNumberOfSpecifiedPiecesOnBoard() {
		createTestBoard();
		assertEquals(3, board.getNumberOfSpecifiedPiecesOnBoard(
				PieceColor.Black, PieceType.Pawn));
		assertEquals(1, board.getNumberOfSpecifiedPiecesOnBoard(
				PieceColor.Black, PieceType.Queen));
	}

	/*
	 * Tests GetPieceAtPosition() on board created for lesson 5, ex 7; both when
	 * board is fliped or not
	 */
	public void testGetPieceAtPosition() {
		createTestBoard();
		assertEquals(Character.toUpperCase(PieceType.Pawn.getPrintable()),
				(board.getPieceAtPosition(Board.boardPositions[6][2]))
						.getPrintableRepresentation());
		assertEquals(PieceType.No_Piece.getPrintable(), (board
				.getPieceAtPosition(Board.boardPositions[3][0]))
				.getPrintableRepresentation());

		assertEquals(PieceType.No_Piece.getPrintable(), (board
				.getPieceAtPosition(Board.boardPositions[3][0]))
				.getPrintableRepresentation());
		assertEquals(PieceType.Knight.getPrintable(), (board
				.getPieceAtPosition(Board.boardPositions[3][5]))
				.getPrintableRepresentation());
	}

	/*
	 * Test addition of a piece on board at specified position
	 */
	public void testAddPieceToBoard() {
		board.addPieceToBoard(new PieceKing(PieceColor.Black),
				Board.boardPositions[5][1]);
		assertEquals(Character.toUpperCase(PieceType.King.getPrintable()),
				(board.getPieceAtPosition(Board.boardPositions[5][1]))
						.getPrintableRepresentation());
		board.addPieceToBoard(new PieceQueen(PieceColor.Black),
				Board.boardPositions[4][1]);
		assertEquals(Character.toUpperCase(PieceType.Queen.getPrintable()),
				(board.getPieceAtPosition(Board.boardPositions[4][1]))
						.getPrintableRepresentation());
		board.addPieceToBoard(new PieceKing(PieceColor.White),
				Board.boardPositions[3][2]);
		assertEquals(PieceType.King.getPrintable(), (board
				.getPieceAtPosition(Board.boardPositions[3][2]))
				.getPrintableRepresentation());
		board.addPieceToBoard(new PieceDefault(PieceColor.No_Color),
				Board.boardPositions[6][2]);
		assertEquals(PieceType.No_Piece.getPrintable(), (board
				.getPieceAtPosition(Board.boardPositions[6][2]))
				.getPrintableRepresentation());

	}

	/*
	 * Test getBoadStrenght on board created for lesson 5, ex 7
	 */
	public void testBoardStrenght() {
		assertEquals(0.0, board.getBoadStrenght(PieceColor.White));
		assertEquals(0.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PieceDefault(PieceColor.No_Color),
				Board.boardPositions[0][0]);
		assertEquals(0.0, board.getBoadStrenght(PieceColor.White));
		assertEquals(0.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PieceQueen(PieceColor.Black),
				Board.boardPositions[5][3]);
		assertEquals(0.0, board.getBoadStrenght(PieceColor.White));
		assertEquals(9.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PieceKing(PieceColor.Black),
				Board.boardPositions[7][1]);
		assertEquals(9.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PieceRook(PieceColor.Black),
				Board.boardPositions[7][2]);
		assertEquals(14.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PieceBishop(PieceColor.Black),
				Board.boardPositions[6][3]);
		assertEquals(17.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PieceKnight(PieceColor.White),
				Board.boardPositions[3][5]);
		assertEquals(2.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PieceQueen(PieceColor.White),
				Board.boardPositions[3][6]);
		assertEquals(11.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PieceKing(PieceColor.White),
				Board.boardPositions[0][5]);
		assertEquals(11.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PiecePawn(PieceColor.White),
				Board.boardPositions[2][5]);
		assertEquals(12.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PiecePawn(PieceColor.White),
				Board.boardPositions[2][7]);
		assertEquals(13.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PiecePawn(PieceColor.White),
				Board.boardPositions[1][5]);
		assertEquals(13.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PiecePawn(PieceColor.White),
				Board.boardPositions[1][6]);
		assertEquals(14.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PieceRook(PieceColor.White),
				Board.boardPositions[0][4]);
		assertEquals(19.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PiecePawn(PieceColor.Black),
				Board.boardPositions[6][0]);
		assertEquals(18.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PiecePawn(PieceColor.Black),
				Board.boardPositions[6][2]);
		assertEquals(19.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PiecePawn(PieceColor.Black),
				Board.boardPositions[5][1]);
		assertEquals(20.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PiecePawn(PieceColor.Black),
				Board.boardPositions[5][6]);
		assertEquals(19.5, board.getBoadStrenght(PieceColor.White));
		assertEquals(21.0, board.getBoadStrenght(PieceColor.Black));
		board.addPieceToBoard(new PiecePawn(PieceColor.Black),
				Board.boardPositions[6][6]);
		assertEquals(21.0, board.getBoadStrenght(PieceColor.Black));

		// Verify that BoardStrenght works OK on Pawns which were on same file
		// but moved or replaced.
		board.addPieceToBoard(new PieceBishop(PieceColor.White),
				Board.boardPositions[1][5]);
		assertEquals(22.5, board.getBoadStrenght(PieceColor.White));
		board.addPieceToBoard(new PiecePawn(PieceColor.White),
				Board.boardPositions[1][5]);
		assertEquals(19.5, board.getBoadStrenght(PieceColor.White));
	}

	/*
	 * public void testBoardPositions() {
	 * assertTrue(board.isInBoardPositions(Board.boardPositions[0][0]));
	 * assertTrue(board.isInBoardPositions(Board.boardPositions[6][0]));
	 * assertTrue(board.isInBoardPositions(Board.boardPositions[7][0]));
	 * assertTrue(board.isInBoardPositions(Board.boardPositions[0][7]));
	 * assertTrue(board.isInBoardPositions(Board.boardPositions[2][2]));
	 * assertTrue(board.isInBoardPositions(Board.boardPositions[0][0]));
	 * assertTrue(board.isInBoardPositions(Board.boardPositions[7][0]));
	 * //assertTrue(board.isInBoardPositions("A8")); //
	 * assertTrue(board.isInBoardPositions("H1"));
	 * //assertTrue(board.isInBoardPositions("C3"));
	 * //assertFalse(board.isInBoardPositions("i3"));
	 * //assertFalse(board.isInBoardPositions("a9"));
	 * //assertFalse(board.isInBoardPositions("a11"));
	 * //assertFalse(board.isInBoardPositions("i33"));
	 * //assertFalse(board.isInBoardPositions("3c")); }
	 */

	/*
	 * Test for a default board layout the white and black pieces on board in
	 * sorted orderer, based on piece strength
	 */
	public void testGetColoredPiecesOnBoard() {
		board.initialize();
		assertEquals(PieceType.Queen, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(0)).getType());
		assertEquals(PieceType.Rook, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(1)).getType());
		assertEquals(PieceType.Rook, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(2)).getType());
		assertEquals(PieceType.Bishop, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(3)).getType());
		assertEquals(PieceType.Bishop, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(4)).getType());
		assertEquals(PieceType.Knight, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(5)).getType());
		assertEquals(PieceType.Knight, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(6)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(7)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(8)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(9)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(10)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(11)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(12)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(13)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(14)).getType());
		assertEquals(PieceType.King, ((board
				.getColoredPiecesOnBoard(PieceColor.White)).get(15)).getType());

		assertEquals(PieceType.Queen, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(0)).getType());
		assertEquals(PieceType.Rook, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(1)).getType());
		assertEquals(PieceType.Rook, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(2)).getType());
		assertEquals(PieceType.Bishop, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(3)).getType());
		assertEquals(PieceType.Bishop, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(4)).getType());
		assertEquals(PieceType.Knight, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(5)).getType());
		assertEquals(PieceType.Knight, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(6)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(7)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(8)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(9)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(10)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(11)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(12)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(13)).getType());
		assertEquals(PieceType.Pawn, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(14)).getType());
		assertEquals(PieceType.King, ((board
				.getColoredPiecesOnBoard(PieceColor.Black)).get(15)).getType());
	}

	public void testGetPiecesOnBoard() {
		board.initialize();
		assertEquals(PieceType.Queen, ((board.getPiecesOnBoard().get(0))
				.getType()));
		assertEquals(PieceType.Rook, ((board.getPiecesOnBoard()).get(1))
				.getType());
		assertEquals(PieceType.Rook, ((board.getPiecesOnBoard()).get(2))
				.getType());
		assertEquals(PieceType.Bishop, ((board.getPiecesOnBoard()).get(3))
				.getType());
		assertEquals(PieceType.Bishop, ((board.getPiecesOnBoard()).get(4))
				.getType());
		assertEquals(PieceType.Knight, ((board.getPiecesOnBoard()).get(5))
				.getType());
		assertEquals(PieceType.Knight, ((board.getPiecesOnBoard()).get(6))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(7))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(8))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(9))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(10))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(11))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(12))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(13))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(14))
				.getType());
		assertEquals(PieceType.King, ((board.getPiecesOnBoard()).get(15))
				.getType());
		assertEquals(PieceType.Queen, ((board.getPiecesOnBoard().get(16))
				.getType()));
		assertEquals(PieceType.Rook, ((board.getPiecesOnBoard()).get(17))
				.getType());
		assertEquals(PieceType.Rook, ((board.getPiecesOnBoard()).get(18))
				.getType());
		assertEquals(PieceType.Bishop, ((board.getPiecesOnBoard()).get(19))
				.getType());
		assertEquals(PieceType.Bishop, ((board.getPiecesOnBoard()).get(20))
				.getType());
		assertEquals(PieceType.Knight, ((board.getPiecesOnBoard()).get(21))
				.getType());
		assertEquals(PieceType.Knight, ((board.getPiecesOnBoard()).get(22))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(23))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(24))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(25))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(26))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(27))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(28))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(29))
				.getType());
		assertEquals(PieceType.Pawn, ((board.getPiecesOnBoard()).get(30))
				.getType());
		assertEquals(PieceType.King, ((board.getPiecesOnBoard()).get(31))
				.getType());

	}

	/*
	 * Creates a board for validating the boardStrength - lesson 5, ex.7
	 */
	private void createTestBoard() {
		board.addPieceToBoard(new PieceKing(PieceColor.Black),
				Board.boardPositions[7][1]);
		board.addPieceToBoard(new PieceRook(PieceColor.Black),
				Board.boardPositions[7][2]);
		board.addPieceToBoard(new PiecePawn(PieceColor.Black),
				Board.boardPositions[6][0]);
		board.addPieceToBoard(new PiecePawn(PieceColor.Black),
				Board.boardPositions[6][2]);
		board.addPieceToBoard(new PieceBishop(PieceColor.Black),
				Board.boardPositions[6][3]);
		board.addPieceToBoard(new PiecePawn(PieceColor.Black),
				Board.boardPositions[5][1]);
		board.addPieceToBoard(new PieceQueen(PieceColor.Black),
				Board.boardPositions[5][4]);
		board.addPieceToBoard(new PieceKnight(PieceColor.White),
				Board.boardPositions[3][5]);
		board.addPieceToBoard(new PieceQueen(PieceColor.White),
				Board.boardPositions[3][6]);
		board.addPieceToBoard(new PiecePawn(PieceColor.White),
				Board.boardPositions[2][5]);
		board.addPieceToBoard(new PiecePawn(PieceColor.White),
				Board.boardPositions[1][6]);
		board.addPieceToBoard(new PieceRook(PieceColor.White),
				Board.boardPositions[0][5]);
	}

}