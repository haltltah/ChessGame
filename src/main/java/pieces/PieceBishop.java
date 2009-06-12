package pieces;

import api.IPiece;
import api.PieceColor;
import api.PieceType;

/**
 * <p>
 * Bishop piece type.
 * </p>
 * 
 * @author lhirian
 */
public class PieceBishop extends PieceDefault {

	/**
	 * <p>
	 * Create a PieceBishop of specified color
	 * </p>
	 * 
	 * @param color
	 */
	public PieceBishop(PieceColor color) {
		super(color);
		setAttributes(color, PieceType.Bishop, IPiece.BISHOP_STRENGHT);
		setPrintableRepresentation(color);
	}
}
