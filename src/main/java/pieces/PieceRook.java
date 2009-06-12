package pieces;

import api.IPiece;
import api.PieceColor;
import api.PieceType;

/**
 * <p>
 * Rook piece type.
 * </p>
 * 
 * @author lhirian
 */
public class PieceRook extends PieceDefault {

	/**
	 * <p>
	 * Create a PieceRook of specified color
	 * </p>
	 * 
	 * @param color
	 */
	public PieceRook(PieceColor color) {
		super(color);
		setAttributes(color, PieceType.Rook, IPiece.ROOK_STRENGHT);
		setPrintableRepresentation(color);
	}
}