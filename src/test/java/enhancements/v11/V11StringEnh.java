package enhancements.v11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class V11StringEnh {

    @Test
    public void whenUseStringLinesMethod_thenGetStrLineByLine() {
        String multilineString = "New method of String.class \n is the Line.\n java doc says : \n Returns a stream of lines extracted from this string, separated by line terminators.";
        long count = multilineString.lines().count();
        assertEquals(count, 4);
    }


    @Test
    public void whenUseStringLIsBlankMethod_thenReturnTrueIfBlank() {
        String emptyAndBlank = "";
        String blankButNotEmpty = "   ";
        System.out.println("difference between empty and blank:");
        assertTrue(emptyAndBlank.isEmpty());
        assertFalse(blankButNotEmpty.isEmpty());
        assertTrue(emptyAndBlank.isBlank());
        assertTrue(blankButNotEmpty.isBlank());
    }

    @Test
    public void useStripMethods() {
        String test = "   test  ";
        String testStrip = "test";
        String testStripLeading = "test  ";
        String testStripTrailing = "   test";
        assertEquals(test.strip(),testStrip);
        assertEquals(test.stripLeading(),testStripLeading);
        assertEquals(test.stripTrailing(),testStripTrailing);

    }

    @Test
    public void whenUseStringRepeatMethods_thenReturnRepatedString(){
            assertEquals("testtesttesttesttest","test".repeat(5));
    }


    /*
     * check https://stackoverflow.com/q/51266582/3572215
     */
    @Test
    public void showDifferenceBetweenStripAndTrim() {
        System.out.println("strip() is faster than trim!");
        String explanation = "In short: strip() is \"Unicode-aware\" evolution of trim(). Meaning trim() removes only characters <= U+0020 (space); strip() removes all Unicode whitespace characters (but not all control characters, such as \\0)";
        System.out.println(explanation);


        Character c = '\u2000';
        String s = c + "abc" + c;

        assertTrue(Character.isWhitespace(c));
        assertEquals(s, s.trim());
        assertEquals("abc", s.strip());
    }

}
