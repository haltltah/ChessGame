package util;

public class StringUtil {

	public final static String NEWLINE = System.getProperty("line.separator");

	private StringUtil() {
	}

	public static String addNewLineToString(String string) {
		StringBuilder buffer = new StringBuilder();
		buffer.append(string);
		buffer.append(NEWLINE);
		return buffer.toString();
	}
}