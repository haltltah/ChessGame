package pieces;

import api.*;

/**
 * <p>
 * Knight piece type.
 * </p>
 * 
 * @author lhirian
 */
public class PieceKnight extends PieceDefault {
	/**
	 * <p>
	 * Create a PieceKnight of specified color
	 * </p>
	 * 
	 * @param color
	 */
	public PieceKnight(PieceColor color) {
		super(color);
		setAttributes(color, PieceType.Knight, IPiece.KNIGHT_STRENGHT);
		setPrintableRepresentation(color);
	}
}
