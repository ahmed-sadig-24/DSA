import java.util.*;

public class WordBreak {

      static Boolean word_break(String s, ArrayList<String> words_dictionary) {
            // Write your code here.
            int n = s.length();
            Set<String> wordSet = new HashSet<>(words_dictionary);
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;

            for (int i = 1; i <= n; i++) {
                  for (int j = i - 1; j >=0; j--) {
                        if (dp[j] && wordSet.contains(s.substring(j, i))) {
                              dp[i] = true;
                              break;
                        }
                  }
            }

            return dp[n];
      }

      public static void main(String[] args) {
            String s = "leetcode";
            ArrayList<String> wordDict = new ArrayList<>(Arrays.asList("leet","code"));

            System.out.println(word_break(s, wordDict));
      }

}
