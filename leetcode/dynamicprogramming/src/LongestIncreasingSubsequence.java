public class LongestIncreasingSubsequence {
      public static int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];

            for (int i = 1; i < nums.length; i++) {
                  for (int j = 0; j < i; j++) {
                        if (nums[i] > nums[j]) {
                              if (dp[j] + 1 > dp[i]) {
                                    dp[i] = dp[j] + 1;
                              }
                        }
                  }
            }

            int maxIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                  if (dp[i] + 1 > dp[maxIndex]) {
                        maxIndex = i;
                  }
            }

            return dp[maxIndex] + 1;
      }

      public static void main(String[] args) {
            int[] nums = {10,9,2,5,3,7,101,18};
            //int[] nums = {0,1,0,3,2,3};
            //int[] nums = {7,7,7,7,7,7,7};

            System.out.println(lengthOfLIS(nums));
      }
}
