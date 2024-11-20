import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoRepeatingChar {
      public static int lengthOfLongestSubstring(String s) {
            int lp = 0;
            int rp = 0;
            int max = 0;

            Set<Character> uniqCharSet = new HashSet<>();

            while (rp < s.length()) {
                  if (!uniqCharSet.contains(s.charAt(rp))) {
                        uniqCharSet.add(s.charAt(rp));
                        max = Math.max(max, uniqCharSet.size());
                        //System.out.println(max);
                        rp++;
                        //System.out.println(rp);
                  } else {
                        uniqCharSet.remove(s.charAt(lp));
                        lp++;
                  }
            }
            return max;
      }

      public static void main(String[] args) {
            //String s = "abcabcbb";
            //String s = "bbbbb";
            String s = "pwwkew";

            System.out.println(lengthOfLongestSubstring(s));
      }
}
