package util;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {
	final String stringToAdd = "addedString";

	public void testCreate() {
		// String string = StringUtil.createString();

		assertEquals(stringToAdd + StringUtil.NEWLINE, StringUtil
				.addNewLineToString(stringToAdd));
	}
}
