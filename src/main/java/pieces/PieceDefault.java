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
 * Default piece type.
 * </p>
 * 
 * @author lhirian
 * 
 */
public class PieceDefault implements IPiece {

	protected PieceColor color;
	protected PieceType type;
	protected double pieceStrength;
	protected char printableRepresentation;
	protected Square position;

	/**
	 * <p>
	 * Create a PieceDefault
	 * </p>
	 * 
	 * @param color
	 */
	public PieceDefault(PieceColor color) {
		setAttributes(PieceColor.No_Color, PieceType.No_Piece,
				IPiece.NO_PIECE_STRENGHT);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#compareTo(api.IPiece)
	 */
	@Override
	public int compareTo(IPiece that) {
		int i = -1;
		if (this.getPieceStrength() < that.getPieceStrength())
			i = 1;
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#getColor()
	 */
	@Override
	public PieceColor getColor() {
		return color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#getPieceStrength()
	 */
	@Override
	public double getPieceStrength() {
		return pieceStrength;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#getPrintableRepresentation()
	 */
	@Override
	public char getPrintableRepresentation() {
		return printableRepresentation;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#getType()
	 */
	@Override
	public PieceType getType() {
		return type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#setPieceStrength(boolean)
	 */
	@Override
	public void setPieceStrength(boolean isSingleInColumn) {
		// TODO Auto-generated method stub
		// implemented in PiecePawn
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#setPiecePosition(int, int)
	 */
	@Override
	public void setPiecePosition(Square squareName) {
		this.position = squareName;
	}

	/**
	 * <p>
	 * Set piece printable representation depending on piece color
	 * </p>
	 * 
	 */
	protected void setPrintableRepresentation(PieceColor color) {
		if (PieceColor.Black == color)
			this.printableRepresentation = Character
					.toUpperCase(getPrintableRepresentation());
	}

	/**
	 * Set attributes of a IPiece object
	 * 
	 * @param color
	 *            - PieceColor
	 * @param type
	 *            - PieceType
	 * @param strength
	 *            - double
	 */
	protected void setAttributes(PieceColor color, PieceType type,
			double strength) {
		this.color = color;
		this.type = type;
		this.printableRepresentation = type.getPrintable();
		pieceStrength = strength;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#getAllowedMovedForPieceType(java.lang.String)
	 */
	@Override
	public List<Square> getAllowedMovedForPieceType() {
		Square posToBeRemoved = Board.boardPositions[this.getPiecePosition()
				.getSquareRow()][this.getPiecePosition().getSquareColumn()];
		List<Square> moves = new ArrayList<Square>();
		for (Square[] temp : Board.boardPositions)
			for (Square pos : temp)
				moves.add(pos);
		moves.remove(posToBeRemoved);
		return moves;
	}

	/**
	 * <p>
	 * Add to param moves the allowed moves from same row, at previous columns
	 * for piece at specified indexes
	 * </p>
	 * 
	 * @param moves
	 *            - ArrayList<Square>
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @param count
	 *            - int
	 */
	protected void addPreviousPositionsInRow(List<Square> moves, int indexRow,
			int indexColumn, int count) {
		if (count > 0) {
			count--;
			Square temp = getBoardPositionsForPieceAtIndexes(indexRow,
					indexColumn);
			moves.add(temp);
			indexColumn--;
			addPreviousPositionsInRow(moves, indexRow, indexColumn, count);
			moves.remove(Square.Null);
		}
	}

	/**
	 * <p>
	 * Add to param moves the allowed moves from same row, at next columns for
	 * piece at specified indexes
	 * </p>
	 * 
	 * @param moves
	 *            - ArrayList<Square>
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @param count
	 *            - int
	 */
	protected void addNextPositionsInRow(List<Square> moves, int indexRow,
			int indexColumn, int count) {
		if (count > 0) {
			count--;
			Square temp = getBoardPositionsForPieceAtIndexes(indexRow,
					indexColumn);
			moves.add(temp);
			indexColumn++;
			addNextPositionsInRow(moves, indexRow, indexColumn, count);
			moves.remove(Square.Null);
		}
	}

	/**
	 * <p>
	 * Add to param moves the allowed moves from same column, at previous rows
	 * for piece at specified indexes
	 * </p>
	 * 
	 * @param moves
	 *            - ArrayList<Square>
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @param count
	 *            - int
	 */
	protected void addPreviousPositionsInColumn(List<Square> moves,
			int indexRow, int indexColumn, int count) {
		if (count > 0) {
			count--;
			Square temp = getBoardPositionsForPieceAtIndexes(indexRow,
					indexColumn);
			moves.add(temp);
			indexRow--;
			addPreviousPositionsInColumn(moves, indexRow, indexColumn, count);
			moves.remove(Square.Null);
		}
	}

	/**
	 * <p>
	 * Add to param moves the allowed moves from same column, at next rows for
	 * piece at specified indexes
	 * </p>
	 * 
	 * @param moves
	 *            - ArrayList<Square>
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @param count
	 *            - int
	 */
	protected void addNextPositionsInColumn(List<Square> moves, int indexRow,
			int indexColumn, int count) {
		if (count > 0) {
			count--;
			Square temp = getBoardPositionsForPieceAtIndexes(indexRow,
					indexColumn);
			moves.add(temp);
			indexRow++;
			addNextPositionsInColumn(moves, indexRow, indexColumn, count);
			moves.remove(Square.Null);
		}
	}

	/**
	 * <p>
	 * Add to param moves the allowed moves at previous rows and columns for
	 * piece at specified indexes
	 * </p>
	 * 
	 * @param moves
	 *            - ArrayList<Square>
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @param count
	 *            - int
	 */
	protected void addLeftLowPositionsInDiagonal(List<Square> moves,
			int indexRow, int indexColumn, int count) {
		if (count > 0) {
			count--;
			Square temp = getBoardPositionsForPieceAtIndexes(indexRow,
					indexColumn);
			moves.add(temp);
			indexRow--;
			indexColumn--;
			addLeftLowPositionsInDiagonal(moves, indexRow, indexColumn, count);
			moves.remove(Square.Null);
		}
	}

	/**
	 * <p>
	 * Add to param moves the allowed moves at next rows and previous columns
	 * for piece at specified indexes
	 * </p>
	 * 
	 * @param moves
	 *            - ArrayList<Square>
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @param count
	 *            - int
	 */
	protected void addLeftUpPositionsInDiagonal(List<Square> moves,
			int indexRow, int indexColumn, int count) {
		if (count > 0) {
			count--;
			Square temp = getBoardPositionsForPieceAtIndexes(indexRow,
					indexColumn);
			moves.add(temp);
			indexRow++;
			indexColumn--;
			addLeftUpPositionsInDiagonal(moves, indexRow, indexColumn, count);
			moves.remove(Square.Null);
		}
	}

	/**
	 * <p>
	 * Add to param moves the allowed moves at previous rows and next columns
	 * for piece at specified indexes
	 * </p>
	 * 
	 * @param moves
	 *            - ArrayList<Square>
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @param count
	 *            - int
	 */
	protected void addRightLowPositionsInDiagonal(List<Square> moves,
			int indexRow, int indexColumn, int count) {
		if (count > 0) {
			count--;
			Square temp = getBoardPositionsForPieceAtIndexes(indexRow,
					indexColumn);
			moves.add(temp);
			indexRow--;
			indexColumn++;
			addRightLowPositionsInDiagonal(moves, indexRow, indexColumn, count);
			moves.remove(Square.Null);
		}
	}

	/**
	 * <p>
	 * Add to param moves the allowed moves at next rows and columns for piece
	 * at specified indexes
	 * </p>
	 * 
	 * @param moves
	 *            - ArrayList<Square>
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @param count
	 *            - int
	 */
	protected void addRightUpPositionsInDiagonal(List<Square> moves,
			int indexRow, int indexColumn, int count) {
		if (count > 0) {
			count--;
			Square temp = getBoardPositionsForPieceAtIndexes(indexRow,
					indexColumn);
			moves.add(temp);
			indexRow++;
			indexColumn++;
			addRightUpPositionsInDiagonal(moves, indexRow, indexColumn, count);
			moves.remove(Square.Null);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IPiece#getPiecePosition()
	 */
	@Override
	public Square getPiecePosition() {
		return this.position;
	}

	/**
	 * Get square from board at specified indexes
	 * 
	 * @param indexRow
	 *            - int
	 * @param indexColumn
	 *            - int
	 * @return Square
	 */
	private Square getBoardPositionsForPieceAtIndexes(int indexRow,
			int indexColumn) {
		Square p = Square.Null;
		if (((indexRow >= 0) && (indexColumn >= 0))
				&& ((indexRow <= Board.NUMBER_OF_RANKS - 1) && (indexColumn <= Board.NUMBER_OF_COLUMNS - 1))) {
			p = Board.boardPositions[indexRow][indexColumn];
		}
		return p;
	}
}
