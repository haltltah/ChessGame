package board;

import junit.framework.TestCase;
import java.lang.Character;

;
public class CharacterTest extends TestCase {
	public void testWhitespace() {

		assertEquals(true, Character.isWhitespace(Character.SPACE_SEPARATOR));
		assertEquals(true, Character.isWhitespace('	'));
		assertEquals(true, Character.isWhitespace(Character.LINE_SEPARATOR));
		assertEquals(false, Character
				.isWhitespace(Character.PARAGRAPH_SEPARATOR));
		assertEquals(true, Character.isWhitespace('\r')); // carriage return
		assertEquals(true, Character.isWhitespace('\t')); // tab
		assertEquals(true, Character.isWhitespace('\f')); // form feed
		assertEquals(false, Character.isWhitespace('\b')); // backspace
	}

	public void testIdentifiersRules() {
		assertEquals(false, Character.isJavaIdentifierStart('^'));
		assertEquals(false, Character.isIdentifierIgnorable('^'));
		assertEquals(false, Character.isJavaIdentifierPart('^'));

		assertEquals(true, Character.isJavaIdentifierStart('$'));
		assertEquals(false, Character.isIdentifierIgnorable('$'));
		assertEquals(true, Character.isJavaIdentifierPart('$'));

		assertEquals(true, Character.isJavaIdentifierStart('_'));
		assertEquals(false, Character.isIdentifierIgnorable('_'));
		assertEquals(true, Character.isJavaIdentifierPart('_'));

		assertEquals(true, Character.isJavaIdentifierStart(65)); // capital A
		assertEquals(false, Character.isIdentifierIgnorable(65));
		assertEquals(true, Character.isJavaIdentifierPart(65));
	}
}