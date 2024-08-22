package practice.website.array;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 97;
            freq[index] = freq[index] + 1;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 97;
            freq[index] = freq[index] - 1;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testValidAnagram() {
        String s1 = "listen";
        String s2 = "silent";
        assertTrue(isAnagram(s1, s2), "The strings 'listen' and 'silent' should be anagrams");
    }

    @Test
    public void testInvalidAnagram() {
        String s1 = "hello";
        String s2 = "world";
        assertFalse(isAnagram(s1, s2), "The strings 'hello' and 'world' should not be anagrams");
    }

    @Test
    public void testAnagramWithDifferentLengths() {
        String s1 = "abc";
        String s2 = "abcd";
        assertFalse(isAnagram(s1, s2), "Strings of different lengths should not be anagrams");
    }

    @Test
    public void testEmptyStrings() {
        String s1 = "";
        String s2 = "";
        assertTrue(isAnagram(s1, s2), "Two empty strings should be considered anagrams");
    }

    @Test
    public void testAnagramWithSpecialCharacters() {
        String s1 = "a!n!a@g@r#am";
        String s2 = "nag a ram!";
        assertFalse(isAnagram(s1, s2), "Special characters and spaces should be considered, making these not anagrams");
    }

    @Test
    public void testValidAnagramWithMixedCase() {
        String s1 = "Dormitory";
        String s2 = "DirtyRoom";
        assertTrue(isAnagram(s1.toLowerCase(), s2.toLowerCase()),
                "When ignoring case, 'Dormitory' and 'DirtyRoom' should be anagrams");
    }

}
