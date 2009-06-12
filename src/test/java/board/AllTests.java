package board;

import junit.framework.Test;
import junit.framework.TestSuite;
import util.StringUtilTest;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for chess");
		// $JUnit-BEGIN$
		suite.addTestSuite(BoardTest.class);
		suite.addTestSuite(CharacterTest.class);
		suite.addTestSuite(StringUtilTest.class);
		// $JUnit-END$
		return suite;
	}

}