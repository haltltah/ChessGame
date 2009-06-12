/**
 * 
 */
package chess;

import java.util.List;

import pieces.PieceBishop;
import pieces.PieceDefault;
import pieces.PieceKing;
import pieces.PiecePawn;
import pieces.PieceQueen;
import board.Board;
import board.Square;
import api.IGame;
import api.IPiece;
import api.PieceColor;
import junit.framework.TestCase;


/**
 * @author hirian
 *
 */
public class GameTest extends TestCase{
	IGame game1; 
	IGame game2; 
	
	public void setUp() {
		game1 = new Game(); 
		game2 = new Game();
	}
	
	public void testPutPieceAndGetPieceAt() {
		IPiece piece1 = new PieceQueen(PieceColor.White);
		Square position1 = Board.boardPositions[5][3];
		piece1.setPiecePosition(Board.boardPositions[4][3]);
		game1.putPiece(piece1, position1);
		IPiece piece2 = game1.getPieceAt(Board.boardPositions[5][3]);
		assertTrue(PieceQueen.class.equals(piece2.getClass()));
		
		IPiece piece3 = new PieceKing(PieceColor.Black);
		Square position2 = Board.boardPositions[3][5];
		piece3.setPiecePosition(Board.boardPositions[2][4]);
		game2.putPiece(piece3, position2);
		IPiece piece4 = game2.getPieceAt(position2);
		assertTrue(PieceKing.class.equals(piece4.getClass()));
		assertEquals(position2.getSquareColumn(), piece4.getPiecePosition().getSquareColumn());
		
		IPiece piece5 = game1.getPieceAt(position2);
		IPiece piece6 = game2.getPieceAt(position1);
		
		assertTrue(PieceDefault.class.equals(piece5.getClass()));
		assertTrue(PieceDefault.class.equals(piece6.getClass()));
		
		//Position not in positions allowed for PieceType based on current position
		 position1 = Board.boardPositions[3][2];
		 game1.putPiece(piece1, position1);
		 IPiece piece10 = game1.getPieceAt(position1);
		 assertTrue(PieceDefault.class.equals(piece10.getClass()));
		 assertFalse(PieceQueen.class.equals(piece10.getClass()));
	}
}
