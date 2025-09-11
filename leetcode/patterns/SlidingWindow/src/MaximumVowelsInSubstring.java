public class MaximumVowelsInSubstring {
      public static int maxVowels(String s, int k) {
            int start = 0;
            int end = k;
            int currVowels = 0;
            for (int i = 0; i < k; i++) {
                  if (isVowel(s.charAt(i))) {
                        currVowels++;
                  }
            }

            int maxVowels = currVowels;
            while (end < s.length()) {
                  if (isVowel(s.charAt(end++))) {
                        currVowels++;
                  }
                  if (isVowel(s.charAt(start++))) {
                        currVowels--;
                  }

                  maxVowels = Math.max(maxVowels, currVowels);
            }

            return maxVowels;
      }

      private static boolean isVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
      }

      public static void main(String[] args) {
            String s1 = "abciiidef";
            int k1 = 3;

            String s2 = "aeiou";
            int k2 = 2;

            String s3 = "leetcode";
            int k3 = 3;

            System.out.println(maxVowels(s1, k1));
            System.out.println(maxVowels(s2, k2));
            System.out.println(maxVowels(s3, k3));
      }
}
