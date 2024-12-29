public class PalindromicSubstring {
      public static int countSubstrings(String s) {
            int count = 0;

            for (int i = 0; i < s.length(); i++) {
                  // odd
                  count += countPalindromes(s, i, i);

                  //even
                  count += countPalindromes(s, i, i + 1);
            }

            return count;
      }

      private static int countPalindromes(String s, int left, int right) {
            int count = 0;

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                  count++;
                  left--;
                  right++;
            }

            return count;
      }

      public static void main(String[] args) {
            String s1 = "abc";
            String s2 = "aaa";
            String s3 = "abbac";

            System.out.println(countSubstrings(s3));
      }
}
