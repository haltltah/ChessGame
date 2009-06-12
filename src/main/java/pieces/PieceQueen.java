package pieces;

import java.util.ArrayList;
import java.util.List;

import board.Board;
import board.Square;

import api.IPiece;
import api.PieceColor;
import api.PieceType;

/**
 * <p>
 * Queen piece type.
 * </p>
 * 
 * @author lhirian
 */
public class PieceQueen extends PieceDefault {

	/**
	 * <p>
	 * Create a PieceQueen of specified color
	 * </p>
	 * 
	 * @param color
	 */
	public PieceQueen(PieceColor color) {
		super(color);
		setAttributes(color, PieceType.Queen, IPiece.QUEEN_STRENGHT);
		setPrintableRepresentation(color);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pieces.PieceDefault#getAllowedMovedForPieceType()
	 */
	@Override
	public List<Square> getAllowedMovedForPieceType() {
		List<Square> moves = new ArrayList<Square>();
		int indexRow = this.getPiecePosition().getSquareRow();
		int indexColumn = this.getPiecePosition().getSquareColumn();
		addPreviousPositionsInRow(moves, indexRow, indexColumn - 1, indexColumn);
		addNextPositionsInRow(moves, indexRow, indexColumn + 1,
				Board.NUMBER_OF_COLUMNS - indexColumn - 1);
		addPreviousPositionsInColumn(moves, indexRow - 1, indexColumn, indexRow);
		addNextPositionsInColumn(moves, indexRow + 1, indexColumn,
				Board.NUMBER_OF_RANKS - indexRow - 1);
		int count = indexRow;
		if (indexRow < indexColumn)
			count = indexColumn;
		addLeftLowPositionsInDiagonal(moves, indexRow - 1, indexColumn - 1,
				count);
		addLeftUpPositionsInDiagonal(moves, indexRow + 1, indexColumn - 1,
				count);
		int count1 = Board.NUMBER_OF_RANKS - indexRow;
		if (indexRow > indexColumn)
			count1 = Board.NUMBER_OF_COLUMNS - indexColumn;
		addRightLowPositionsInDiagonal(moves, indexRow - 1, indexColumn + 1,
				count1 - 1);
		addRightUpPositionsInDiagonal(moves, indexRow + 1, indexColumn + 1,
				count1 - 1);
		return moves;
	}
}
