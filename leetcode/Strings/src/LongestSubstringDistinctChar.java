import java.util.HashMap;
import java.util.Map;

public class LongestSubstringDistinctChar {
      public static int lengthOfLongestSubstringKDistinct(String s, int k) {
            if (k == 0) return 0;

            char[] ch = s.toCharArray();

            int l = 0;
            int r = 0;
            Map<Character, Integer> hm = new HashMap<>();

            int maxLen = 0;
            while (r < ch.length) {
                  hm.put(ch[r],hm.getOrDefault(ch[r],0) + 1);

                  while (hm.size() > k) {
                        hm.put(ch[l],hm.get(ch[l]) - 1);
                        if (hm.get(ch[l]) == 0) {
                              hm.remove(ch[l]);
                        }
                        l++;
                  }
                  maxLen = Math.max(maxLen, r - l + 1);
                  r++;
            }

            return maxLen;
      }

      public static void main(String[] args) {
            String s = "eceba";
            int k = 2;

            //String s = "aa";
            //int k = 1;

            System.out.println(lengthOfLongestSubstringKDistinct(s, k));
      }
}
