package api;

import java.util.List;

import board.Square;

/**
 * <p>
 * Piece data type.
 * </p>
 * 
 * @author lhirian
 * 
 */

public interface IPiece extends Comparable<IPiece> {

	public final static double QUEEN_STRENGHT = 9;
	public final static double ROOK_STRENGHT = 5;
	public final static double BISHOP_STRENGHT = 3;
	public final static double KNIGHT_STRENGHT = 2.5;
	public final static double KING_STRENGHT = 0;
	public final static double SINGLE_PAWN_STRENGHT = 1.0;
	public final static double MULTIPLE_PAWN_STRENGHT = 0.5;
	public final static double NO_PIECE_STRENGHT = 0;

	/**
	 * <p>
	 * Get type of the piece.
	 * </p>
	 * 
	 * @return type enum value
	 */
	PieceType getType();

	/**
	 * <p>
	 * Get color of the piece.
	 * </p>
	 * 
	 * @return color enum value
	 */
	PieceColor getColor();

	/**
	 * <p>
	 * Get strength of the piece.
	 * </p>
	 * 
	 * @return strength value
	 * 
	 */
	double getPieceStrength();

	/**
	 * <p>
	 * Get printable representation of the piece.
	 * </p>
	 * 
	 * @return printable representation value
	 * 
	 */
	char getPrintableRepresentation();

	/**
	 * <p>
	 * Set piece strength depending on pawn state - single on column or not.
	 * </p>
	 * 
	 */
	void setPieceStrength(boolean isSingleInColumn);

	/**
	 * <p>
	 * Get a list containing allowed moved a piece can make, based on piece type
	 * and piece current position
	 * </p>
	 * 
	 * @return List<Square>
	 */
	List<Square> getAllowedMovedForPieceType();

	/**
	 * <p>
	 * Set piece position - row and column.
	 * </p>
	 * 
	 * @param squareName
	 *            - Square
	 */
	void setPiecePosition(Square squareName);

	/**
	 * <p>
	 * Get piece position
	 * </p>
	 * 
	 * @return Square
	 */
	Square getPiecePosition();

	/**
	 * <p>
	 * Compares to piece objects based on piece strength.
	 * </p>
	 * 
	 * @return a negative integer, zero, or a positive integer as this object is
	 *         greater than, equal to, or less than the specified object.
	 */
	int compareTo(IPiece piece);

}
