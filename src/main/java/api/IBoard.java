package api;

/**
 * <p>
 * Board type.
 * </p>
 * @author hirian
 */

import java.util.List;
import board.Square;

public interface IBoard {
	/**
	 * <p>
	 * Creates default layout of a chess board.
	 * </p>
	 */
	public void initialize();

	/**
	 * <p>
	 * Get number of specified IPiece objects of specified color.
	 * </p>
	 * 
	 * @param color
	 *            - PieceColor
	 * @param type
	 *            - PieceType
	 * @return numberOfSpecifiedPieces
	 */
	int getNumberOfSpecifiedPiecesOnBoard(PieceColor color, PieceType type);

	/**
	 * <p>
	 * Get IPiece object from the specified position from board.
	 * </p>
	 * 
	 * @param position
	 *            - Square
	 * @return numberOfPiecesInRank
	 */
	IPiece getPieceAtPosition(Square position);

	/**
	 * <p>
	 * Adds one IPiece object to board at specified position.
	 * </p>
	 * 
	 * @param piece
	 *            - IPiece
	 *@param position
	 *            - Square
	 */
	void addPieceToBoard(IPiece piece, Square position);

	/**
	 * <p>
	 * Get number of pieces on board.
	 * </p>
	 * 
	 * @return numberOfPieceOnBoard
	 */
	int pieceCount();

	/**
	 * <p>
	 * Get board strength for specified color.
	 * </p>
	 * 
	 * @param color
	 *            - PieceColor value
	 * @return boardStrenght
	 */
	double getBoadStrenght(PieceColor PieceColor);

	/**
	 * <p>
	 * Sets board fliped or not.
	 * </p>
	 * 
	 * @param boardFlipped
	 *            - boolean
	 */
	void setFlipedBoard(boolean boardFlipped);

	/**
	 * <p>
	 * Determine if board fliped or not.
	 * </p>
	 * 
	 * @return boolean
	 */
	boolean isBoardFliped();

	/**
	 * <p>
	 * Get sorted list of IPiece objects of specified color from board.
	 * </p>
	 * 
	 * @param color
	 *            - PieceColor value
	 * @return ArrayList<IPiece>
	 */
	List<IPiece> getColoredPiecesOnBoard(PieceColor color);

	/**
	 * <p>
	 * Get printable representation for board.
	 * </p>
	 * 
	 * @return String
	 */
	String print();

	/**
	 * <p>
	 * Return an ArrayList with all pieces from board, excluding NoPiece objects
	 * </p>
	 */
	List<IPiece> getPiecesOnBoard();
}
