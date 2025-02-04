public class PartitionEqualSubsetSum {
      public static boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num: nums) {
                  sum += num;
            }

            if (sum % 2 != 0) {
                  return false;
            }

            sum = sum / 2;
            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int num: nums) {
                  for (int j = sum; j >= num; j--) {
                        dp[j] = dp[j] | dp[j - num];
                  }
            }

            return dp[sum];
      }

      public static void main(String[] args) {
            int[] nums1 = {1,5,11,5};
            int[] nums2 = {1, 2, 3, 5};

            System.out.println(canPartition(nums1));
            System.out.println(canPartition(nums2));
      }
}
