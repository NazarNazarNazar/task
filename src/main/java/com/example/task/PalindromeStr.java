package main.java.com.example.task;

/**
 * Palindrome
 */
public class PalindromeStr {

    public static void main(String[] args) {
        PalindromeStr.isPalindrome("qwq qwq");
        PalindromeStr.isPalindrome("qwq");
        PalindromeStr.isPalindrome("qWq QwQ");
        PalindromeStr.isPalindrome("qWq Qadfa");
        PalindromeStr.isPalindrome("qwq");
    }

    /**
     *
     * @param str of String
     */
    private static void isPalindrome(String str) {
        if (str != null) {
            str = str.toLowerCase();
            str = str.replaceAll(" ", "");

            int strLength = str.length();

            for (int i = 0; i < strLength / 2; i++) {
                if (str.charAt(i) != str.charAt(strLength - 1 - i)) {
                    System.out.println("not palindrome");
                    return;
                }
            }
            System.out.println("it is palindrome");
        }
    }
}
