import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {
      public static int lengthOfLongestSubstring(String s) {
            int start = 0;
            int end = 0;
            HashSet<Character> uniqueCharSet = new HashSet<>();
            int substrCount = 0;

            while (end < s.length()) {
                  if (!uniqueCharSet.contains(s.charAt(end))) {
                        uniqueCharSet.add(s.charAt(end++));
                  } else {
                        uniqueCharSet.remove(s.charAt(start++));
                  }

                  substrCount = Math.max(substrCount, uniqueCharSet.size());
            }

            return substrCount;
      }

      public static void main(String[] args) {
            String s1 = "abcabcbb";
            String s2 = "bbbbb";
            String s3 = "pwwkew";

            System.out.println(lengthOfLongestSubstring(s1));
            System.out.println(lengthOfLongestSubstring(s2));
            System.out.println(lengthOfLongestSubstring(s3));
      }
}
