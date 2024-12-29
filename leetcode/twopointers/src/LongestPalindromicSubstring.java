public class LongestPalindromicSubstring {
      public static String longestPalindrome(String s) {
            if (s == null || s.length() == 0) return "";

            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                  //odd
                  int oddLen = getPalindromeLength(s, i, i);
                  //even
                  int evenLen = getPalindromeLength(s, i, i + 1);

                  int len = Math.max(oddLen, evenLen);

                  if (len > end - start) {
                        start = i - (len - 1) / 2;
                        end = i + len / 2;
                  }
            }

            return s.substring(start, end + 1);
      }

      private static int getPalindromeLength(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                  left--;
                  right++;
            }

            return right - left - 1;
      }

      public static void main(String[] args) {
            String s = "babad";
            System.out.println(longestPalindrome(s)); // Output: "bab" or "aba"

            s = "cbbd";
            System.out.println(longestPalindrome(s)); // Output: "bb"
      }
}