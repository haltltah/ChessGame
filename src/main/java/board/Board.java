package board;

import java.util.*;

import pieces.*;
import util.StringUtil;
import api.PieceColor;
import api.PieceType;
import api.IBoard;
import api.IPiece;

//listIndex = row * columnWidth + column

/**
 * <p>
 * Board implementation.
 * </p>
 * 
 * @author hirian
 * 
 */
public class Board implements IBoard {
	public final static int NUMBER_OF_RANKS = 8;
	public final static int NUMBER_OF_COLUMNS = 8;
	public static Square[][] boardPositions = new Square[Board.NUMBER_OF_RANKS][Board.NUMBER_OF_COLUMNS];
	private List<ArrayList<IPiece>> boardLayout = new ArrayList<ArrayList<IPiece>>();
	private final static List<String> columns = new ArrayList<String>();
	private int numberOfPieceOnBoard = 0;
	private boolean boardFliped = false;

	/**
	 * <p>
	 * Creates a chess board
	 * </p>
	 */
	public Board() {
		for (int i = 0; i <= NUMBER_OF_RANKS - 1; i++) {
			ArrayList<IPiece> row = new ArrayList<IPiece>(8);
			for (int j = 0; j <= NUMBER_OF_COLUMNS - 1; j++) {
				row.add(new PieceDefault(PieceColor.No_Color));
			}
			boardLayout.add(row);
		}
		setBoardPositions();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#initialize()
	 */
	@Override
	public void initialize() {
		boardLayout.set(0, setDefaultRow(1));
		boardLayout.set(1, setDefaultPawnRow(2));
		boardLayout.set(6, setDefaultPawnRow(7));
		boardLayout.set(7, setDefaultRow(8));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#getNumberOfSpecifiedPiecesOnBoard(api.PieceColor,
	 * api.PieceType)
	 */
	@Override
	public int getNumberOfSpecifiedPiecesOnBoard(PieceColor color,
			PieceType type) {
		List<IPiece> pieces;
		pieces = getColoredPiecesOnBoard(color);
		int numberOfSpecifiedPieces = 0;
		for (IPiece piece : pieces) {
			if (type == piece.getType()) {
				numberOfSpecifiedPieces++;
			}
		}
		return numberOfSpecifiedPieces;
	}

	/**
	 * <p>
	 * Get IPiece object from the specified position from board.
	 * </p>
	 * 
	 * @return numberOfPiecesInRank
	 */
	public IPiece getPieceAtPosition(Square position) {
		int columnIndex = position.getSquareColumn();
		int rankIndex = position.getSquareRow();
		if (boardFliped == true) {
			rankIndex = 8 - rankIndex;
		}
		ArrayList<IPiece> row = boardLayout.get(rankIndex);
		IPiece piece = row.get(columnIndex);
		return piece;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#addPieceToBoard(api.IPiece, java.lang.String)
	 */
	@Override
	public void addPieceToBoard(IPiece piece, Square position) {
		int columnIndex = position.getSquareColumn();
		int rankIndex = position.getSquareRow();
		if (boardFliped == true) {
			rankIndex = 8 - rankIndex;
		}
		add(piece, rankIndex, columnIndex);
		piece.setPiecePosition(position);
	}

	/**
	 * @param piece
	 * @param rankIndex
	 * @param columnIndex
	 */
	private void add(IPiece piece, int rankIndex, int columnIndex) {
		ArrayList<IPiece> row = boardLayout.get(rankIndex);
		row.set(columnIndex, piece);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#getBoadStrenght(api.PieceColor)
	 */
	@Override
	public double getBoadStrenght(PieceColor color) {
		determninePawnStrenghtOnBoard(color);
		double boardStrenght = 0.0;
		for (ArrayList<IPiece> row : boardLayout) {
			for (IPiece piece : row)
				if (color == piece.getColor()) {
					boardStrenght += piece.getPieceStrength();
				}
		}
		return boardStrenght;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#setFlipedBoard(boolean)
	 */
	@Override
	public void setFlipedBoard(boolean boardFlipped) {
		boardFliped = boardFlipped;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#isBoardFliped()
	 */
	public boolean isBoardFliped() {
		return boardFliped;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#getColoredPiecesOnBoard(api.PieceColor)
	 */
	@Override
	public List<IPiece> getColoredPiecesOnBoard(PieceColor color) {
		List<IPiece> coloredPiecesOnBoard = new ArrayList<IPiece>();
		for (List<IPiece> row : boardLayout) {
			for (IPiece piece : row) {
				if (color == piece.getColor())
					coloredPiecesOnBoard.add(piece);
			}
		}
		Collections.sort(coloredPiecesOnBoard);
		return coloredPiecesOnBoard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#print()
	 */
	@Override
	public String print() {
		StringBuilder printBoard = new StringBuilder();
		if (isBoardFliped()) {
			for (List<IPiece> row : boardLayout) {
				printBoard.append(StringUtil.addNewLineToString(printRow(row)));
			}
		} else {
			int i = 7;
			while (i >= 0) {
				printBoard.append(StringUtil
						.addNewLineToString(printRow(boardLayout.get(i))));
				i--;
			}
		}
		return printBoard.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#pieceCount()
	 */
	@Override
	public int pieceCount() {
		for (List<IPiece> col : boardLayout) {
			for (IPiece piece : col) {
				if (piece.getClass() != PieceDefault.class)
					numberOfPieceOnBoard++;
			}
		}
		return numberOfPieceOnBoard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#isInBoardPositions(java.lang.String)
	 */
	private String printRow(List<IPiece> row) {
		StringBuilder temp = new StringBuilder();
		for (IPiece piece : row) {
			temp.append(piece.getPrintableRepresentation());
		}
		return temp.toString();
	}

	/**
	 * <p>
	 * Set possible positions on a table
	 * </p>
	 */
	public final static void setBoardPositions() {
		populateColumns();
		for (int i = 0; i <= Board.NUMBER_OF_RANKS - 1; i++) {
			for (int j = 0; j <= Board.NUMBER_OF_COLUMNS - 1; j++) {
				boardPositions[i][j] = new Square((columns.get(j) + Integer
						.valueOf(i + 1).toString()), i, j);
			}
		}
	}

	/**
	 * <p>
	 * Sets PiecePawn object's strength of specified color depending if they are
	 * single on file or not.
	 * </p>
	 * 
	 * @param color
	 *            - ColorPiece type
	 */
	private void determninePawnStrenghtOnBoard(PieceColor pieceColor) {
		setResetPawnStrenght(pieceColor);
		List<IPiece> pieces = getColoredPiecesOnBoard(pieceColor);
		List<IPiece> pawns = getSpecificTypePiecesOnBoard(pieces,
				PieceType.Pawn);
		for (int i = 0; i <= pawns.size() - 1; i++) {
			int indexColumnPawn1 = (pawns.get(i)).getPiecePosition()
					.getSquareColumn();
			for (int j = i + 1; j <= pawns.size() - 1; j++) {
				if ((pawns.get(j)).getPiecePosition().getSquareColumn() == indexColumnPawn1) {
					(pawns.get(i)).setPieceStrength(false);
					(pawns.get(j)).setPieceStrength(false);
				}
			}
		}
	}

	/**
	 * <p>
	 * Get a list of pieces of specified type
	 * </p>
	 * 
	 * @param pieces
	 * @param pieceType
	 * @return
	 */
	private List<IPiece> getSpecificTypePiecesOnBoard(List<IPiece> pieces,
			PieceType pieceType) {
		ArrayList<IPiece> specificTypePiecesOnBoard = new ArrayList<IPiece>();
		for (IPiece piece : pieces) {
			if (piece.getType() == pieceType)
				specificTypePiecesOnBoard.add(piece);
		}
		return specificTypePiecesOnBoard;
	}

	/**
	 * Set all PiecePawns' strength to 1 for PiecePawn of specified color
	 */
	private void setResetPawnStrenght(PieceColor pieceColor) {
		List<IPiece> pieces;
		pieces = getColoredPiecesOnBoard(pieceColor);
		for (IPiece piece : pieces)
			if (PiecePawn.class == piece.getClass()) {
				piece.setPieceStrength(true);
			}
	}

	/**
	 * <p>
	 * Create default second row or default 7th row for an initial board
	 * depending on index
	 * </p>
	 * 
	 * @param i
	 * @return IPiece[]
	 */
	private ArrayList<IPiece> setDefaultPawnRow(int index) {
		ArrayList<IPiece> row = new ArrayList<IPiece>();
		PieceColor color = PieceColor.Black;
		if (index == 2)
			color = PieceColor.White;
		for (int i = 0; i <= Board.NUMBER_OF_COLUMNS - 1; i++) {
			IPiece piece = new PiecePawn(color);
			row.add(piece);
			;
			piece.setPiecePosition(boardPositions[index - 1][i]);
		}
		return row;
	}

	/**
	 * <p>
	 * Create default first row or default 8th row for an initial board
	 * depending on index
	 * </p>
	 * 
	 * @param i
	 * @return IPiece[]
	 */
	private ArrayList<IPiece> setDefaultRow(int index) {
		ArrayList<IPiece> row = new ArrayList<IPiece>(Board.NUMBER_OF_COLUMNS);
		PieceColor color = PieceColor.Black;
		if (index == 1)
			color = PieceColor.White;
		IPiece piece1 = new PieceRook(color);
		row.add(piece1);
		IPiece piece2 = new PieceKnight(color);
		row.add(piece2);
		IPiece piece3 = new PieceBishop(color);
		row.add(piece3);
		IPiece piece4 = new PieceQueen(color);
		row.add(piece4);
		IPiece piece5 = new PieceKing(color);
		row.add(piece5);
		row.add(piece3);
		row.add(piece2);
		row.add(piece1);
		for (int i = 0; i < row.size(); i++) {
			piece1 = row.get(i);
			piece1.setPiecePosition(boardPositions[index - 1][6]);
			}
		return row;
	}

	private static void populateColumns() {
		columns.add("a");
		columns.add("b");
		columns.add("c");
		columns.add("d");
		columns.add("e");
		columns.add("f");
		columns.add("g");
		columns.add("h");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see api.IBoard#getPiecesOnBoard()
	 */
	@Override
	public List<IPiece> getPiecesOnBoard() {
		List<IPiece> piecesOnBoard = getColoredPiecesOnBoard(PieceColor.Black);
		piecesOnBoard.addAll(getColoredPiecesOnBoard(PieceColor.White));
		return piecesOnBoard;
	}

}