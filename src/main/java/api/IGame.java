/**
 * 
 */
package api;

import board.Square;

/**
 * @author hirian
 * 
 */
public interface IGame {

	/**
	 * <p>
	 * Set piece at position specified on board.
	 * </p>
	 * @param piece
	 * @param position
	 */
	 void putPiece(IPiece piece, Square position);
	 
	 /**
	  * <p>
	  * Get piece at specified position from board
	  * </p>
	  * @param position - Square
	  * @return IPiece
	  */
	 IPiece getPieceAt(Square position);
	 
}
