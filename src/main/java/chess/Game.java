/**
 * 
 */
package chess;

import java.util.List;

import board.Board;
import board.Square;
import api.IGame;
import api.IPiece;

/**
 * @author hirian
 *
 */
public class Game implements IGame {

	public final Board board = new Board();
	
	Game() {
		board.initialize();
	}
	
	/* (non-Javadoc)
	 * @see api.IGame#getPieceAt(board.Square)
	 */
	@Override
	public IPiece getPieceAt(Square position) {
		return board.getPieceAtPosition(position);
	}

	/* (non-Javadoc)
	 * @see api.IGame#putPiece(api.IPiece, board.Square)
	 */
	@Override
	public void putPiece(IPiece piece, Square position) {
		boolean isInList = true;
		List<Square> temp = piece.getAllowedMovedForPieceType();
		
		if (temp.contains(position))
		{
			System.out.println("Is in list");
			board.addPieceToBoard(piece, position);
		}
		
		else {
			isInList = false;
			System.out.println("Not in list");
		}
	}

}
