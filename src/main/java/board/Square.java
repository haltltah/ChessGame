/**
 * 
 */
package board;

/**
 * @author hirian
 * 
 */
public class Square {
	private String squareName;
	private int squareRow;
	private int squareColumn;
	// static Square Null;

	public final static Square Null = new Square() {

	};

	Square() {

	}

	Square(String squareName, int squareRow, int squareColumn) {
		this.squareName = squareName;
		this.squareRow = squareRow;
		this.squareColumn = squareColumn;
	}

	/**
	 * <p>
	 * Get Square name
	 * </p>
	 * 
	 * @return squareName - String
	 */
	public final String getSquareName() {
		return squareName;
	}

	/**
	 * <p>
	 * Get Sqaure row
	 * </p>
	 * 
	 * @return squareRow - int
	 */
	public final int getSquareRow() {
		return squareRow;
	}

	/**
	 * <p>
	 * Get Sqaure column
	 * </p>
	 * 
	 * @return squareColumn - int
	 */
	public final int getSquareColumn() {
		return squareColumn;
	}
}
