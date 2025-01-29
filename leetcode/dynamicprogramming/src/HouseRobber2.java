public class HouseRobber2 {
      public static int rob(int[] nums) {
            int n = nums.length;

            if (n == 0) return 0;
            if (n == 1) {
                  return nums[0];
            }
            if (n == 2) {
                  return Math.max(nums[0], nums[1]);
            }

            int[] skipLastHouse = new int[n - 1];
            int[] skipFirstHouse = new int[n - 1];

            for (int i = 0; i < n - 1; i++) {
                  skipLastHouse[i] = nums[i];
                  skipFirstHouse[i] = nums[i + 1];
            }

            int lootSkippingLast = robHelper(skipLastHouse);
            int lootSkippingFirst = robHelper(skipFirstHouse);

            return Math.max(lootSkippingLast, lootSkippingFirst);
      }

      private static int robHelper(int[] nums) {
            int n = nums.length;

            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i <n; i++) {
                  dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }

            return dp[n - 1];
      }

      public static void main(String[] args) {
            int[] nums1 = {1,2,3,1};
            int[] nums2 = {0, 0};

            System.out.println(rob(nums1));
            System.out.println(rob(nums2));
      }
}
