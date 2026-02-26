package Strings._02_palindrome_twopointers;

public class LongestPalindrome
{
    public static String longestPalindromeBrute(String s) {
        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (IsPalindrome.isPalindrome(sub) && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }
        return ans;
    }

    public static String longestPalindromeDp(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int start = 0, maxLen = 1;

        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxLen) {
                            start = i;
                            maxLen = len;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public static String longestPalindromeExpand(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {

            int len1 = expand(s, i, i);     // odd length
            int len2 = expand(s, i, i + 1); // even length

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    static void main() {
        System.out.println(longestPalindromeBrute("babad"));
        System.out.println(longestPalindromeDp("babad"));
        System.out.println(longestPalindromeExpand("babad"));
    }
}
