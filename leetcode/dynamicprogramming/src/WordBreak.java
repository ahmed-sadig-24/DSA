import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
      public static boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                  for (String w: wordDict) {
                        int start = i - w.length();
                        if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                              dp[i] = true;
                              break;
                        }
                  }
            }

            return dp[s.length()];
      }

      public static void main(String[] args) {
            String s = "leetcode";
            String[] wordDict = {"leet","code"};

            //String s = "applepenapple";
            //String[] wordDict = {"apple","pen"};

            //String s = "catsandog";
            //String[] wordDict = {"cats","dog","sand","and","cat"};

            //System.out.println(wordBreak(s, Arrays.asList(wordDict)));
            System.out.println(wordBreak2(s, Arrays.asList(wordDict)));
            System.out.println(wordBreak3(s, Arrays.asList(wordDict)));
      }

      public static boolean wordBreak2(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);

            int maxLen = 0;
            for (String word: wordDict) {
                  maxLen = Math.max(maxLen, word.length());
            }

            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                  for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                        if (dp[j] && wordSet.contains(s.substring(j, i))) {
                              dp[i] = true;
                              break;
                        }
                  }
            }

            return dp[n];
      }

      public static boolean wordBreak3(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            int n = s.length();

            int maxLen = 0;
            for (String word: wordDict) {
                  maxLen = Math.max(maxLen, word.length());
            }

            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                  for (int j = Math.max(0, i - maxLen) ; j < i; j++) {
                        if (dp[j] && wordSet.contains(s.substring(j, i))) {
                              dp[i] = true;
                              break;
                        }
                  }
            }

            return dp[n];
      }
}
