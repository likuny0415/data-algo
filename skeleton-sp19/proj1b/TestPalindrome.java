import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalidrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("c"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertTrue(palindrome.isPalindrome("aaaa"));
    }

    @Test
    public void secondPalidrome() {
       CharacterComparator ofo = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", ofo));
        assertTrue(palindrome.isPalindrome("a", ofo));
        assertTrue(palindrome.isPalindrome("", ofo));
        assertTrue(palindrome.isPalindrome("zyzy", ofo));
        assertTrue(palindrome.isPalindrome("yyxz", ofo));
        assertTrue(palindrome.isPalindrome("yyyxz", ofo));
        assertFalse(palindrome.isPalindrome("aa", ofo));
        assertFalse(palindrome.isPalindrome("xyz", ofo));
        assertFalse(palindrome.isPalindrome("aa", ofo));

    }
}