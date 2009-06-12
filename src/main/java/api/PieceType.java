package api;

/**
 * <p>
 * Enum type containing piece type and their printable representation
 * </p>
 * 
 * @author hirian
 * 
 */
public enum PieceType {
	Pawn('p'), King('k'), Queen('q'), Bishop('b'), Knight('n'), Rook('r'), No_Piece(
			'.');

	private final char printable;

	private PieceType(char printable) {
		this.printable = printable;
	}

	/**
	 * <p>
	 * Get Printable representation for piece type in enum value
	 * </p>
	 * 
	 * @return printable
	 */
	public char getPrintable() {
		return printable;
	}
};
