import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctChar {
      public static int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (s == null || s.length() == 0 || k == 0) return 0;

            int start = 0;
            int end = 0;
            int maxLen = 0;
            Map<Character, Integer> freqMap = new HashMap<>();

            while (end < s.length()) {
                  char endChar = s.charAt(end);
                  freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);
                  end++;

                  while (freqMap.size() > k) {
                        char startChar = s.charAt(start);
                        freqMap.put(startChar, freqMap.get(startChar) - 1);

                        if (freqMap.get(startChar) == 0) {
                              freqMap.remove(startChar);
                        }
                        start++;
                  }

                  maxLen = Math.max(maxLen, end - start );
            }

            return maxLen;
      }

      public static void main(String[] args) {
            String s1 = "eceba";
            int k1 = 2;

            String s2 = "aa";
            int k2 = 1;

            System.out.println(lengthOfLongestSubstringKDistinct(s1, k1)); //3
            System.out.println(lengthOfLongestSubstringKDistinct(s2, k2)); // 2
      }
}
