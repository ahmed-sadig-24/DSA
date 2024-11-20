public class LongestPalindromeSubstring {
      public static String longestPalindrome(String s) {
            int n = s.length();
            if (n <= 1) return s;

            String LPS = "";

            for (int i = 1; i < n; i++) {
                  int start = i;
                  int end = i;

                  while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                        start--;
                        end++;
                  }
                  String palindrome = s.substring(start + 1, end);

                  if (palindrome.length() > LPS.length()) {
                        LPS = palindrome;
                  }

                  start = i - 1;
                  end = i;

                  while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
                        start--;
                        end++;
                  }
                  palindrome = s.substring(start + 1, end);
                  if (palindrome.length() > LPS.length()) {
                        LPS = palindrome;
                  }
            }

            return LPS;
      }

      public static void main(String[] args) {
            String s1 = "babad";
            String s2 = "EBBABAD";
            String s3 = "cbbd";
            String s4 = "ac";

            System.out.println(longestPalindrome(s1));
            System.out.println(longestPalindrome(s2));
            System.out.println(longestPalindrome(s3)); //bb
            System.out.println(longestPalindrome(s4));

      }
}
