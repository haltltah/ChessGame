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
public class PiecePawn extends PieceDefault {

	private boolean singlePawnInFile = true;

	/**
	 * <p>
	 * Create a PiecePawn of specified color
	 * </p>
	 * 
	 * @param color
	 */
	public PiecePawn(PieceColor color) {
		super(color);
		setAttributes(color, PieceType.Pawn, IPiece.SINGLE_PAWN_STRENGHT);
		setPrintableRepresentation(color);
	}

	@Override
	public void setPieceStrength(boolean isSingleInColumn) {
		singlePawnInFile = isSingleInColumn;
		if (singlePawnInFile == false)
			pieceStrength = IPiece.MULTIPLE_PAWN_STRENGHT;
		else
			pieceStrength = IPiece.SINGLE_PAWN_STRENGHT;
	}
}
