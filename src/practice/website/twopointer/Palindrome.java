package practice.website.twopointer;

public class Palindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        s = s.toLowerCase();
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (!((s.charAt(start) >= 97 && s.charAt(start) <= 122)
                    || (s.charAt(start) >= 48 && s.charAt(start) <= 56))) {
                start++;
            } else if (!((s.charAt(end) >= 97 && s.charAt(end) <= 122)
                    || (s.charAt(end) >= 48 && s.charAt(end) <= 56))) {
                end--;
            } else {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        String s = "0P";
        System.out.println(palindrome.isPalindrome(s));

    }
}
