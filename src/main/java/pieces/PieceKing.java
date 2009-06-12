package pieces;

/**
 * <p>
 * King piece type.
 * </p>
 * @author lhirian
 */
import java.util.ArrayList;
import java.util.List;

import api.*;

import board.Square;

public class PieceKing extends PieceDefault {

	/**
	 * <p>
	 * Create a PieceKing of specified color
	 * </p>
	 * 
	 * @param color
	 */
	public PieceKing(PieceColor color) {
		super(color);
		setAttributes(color, PieceType.King, IPiece.KING_STRENGHT);
		setPrintableRepresentation(color);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pieces.PieceDefault#getAllowedMovedForPieceType(java.lang.String)
	 */
	@Override
	public List<Square> getAllowedMovedForPieceType() {
		List<Square> moves = new ArrayList<Square>();
		int indexRow = this.getPiecePosition().getSquareRow();
		int indexColumn = this.getPiecePosition().getSquareColumn();
		addPreviousPositionsInRow(moves, indexRow, indexColumn - 1, 1);
		addNextPositionsInRow(moves, indexRow, indexColumn + 1, 1);
		addPreviousPositionsInColumn(moves, indexRow - 1, indexColumn, 1);
		addNextPositionsInColumn(moves, indexRow + 1, indexColumn, 1);
		addLeftLowPositionsInDiagonal(moves, indexRow - 1, indexColumn - 1, 1);
		addLeftUpPositionsInDiagonal(moves, indexRow + 1, indexColumn - 1, 1);
		addRightLowPositionsInDiagonal(moves, indexRow - 1, indexColumn + 1, 1);
		addRightUpPositionsInDiagonal(moves, indexRow + 1, indexColumn + 1, 1);
		return moves;
	}
}
