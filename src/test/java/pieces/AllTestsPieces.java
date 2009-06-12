package pieces;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTestsPieces {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for pieces");
		// $JUnit-BEGIN$
		suite.addTestSuite(PieceDefaultTest.class);
		suite.addTestSuite(PiecePawnTest.class);
		suite.addTestSuite(PieceQueenTest.class);
		suite.addTestSuite(PieceKingTest.class);
		suite.addTestSuite(PieceKnightTest.class);
		suite.addTestSuite(PieceRookTest.class);
		suite.addTestSuite(PieceBishopTest.class);
		// $JUnit-END$
		return suite;
	}

}
