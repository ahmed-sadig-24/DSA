public class PartitionKSumSubsets {
      public static boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = 0;
            for (int num: nums) {
                  sum += num;
            }

            if (sum % k != 0) {
                  return false;
            }
            sum = sum / k;

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
            for (int num: nums) {
                  for (int j = sum; j >= num; j--) {
                        dp[j] = dp[j] || dp[j - num];
                  }
            }

            return dp[sum];
      }

      public static void main(String[] args) {
            //int[] nums1 = {4,3,2,3,5,2,1};
            //int k1 = 4;

            //int[] nums2 = {1,2,3,4};
            //int k2 = 3;

            int[] nums3 = {2,2,2,2,3,4,5};
            int k3 = 4;

            //System.out.println(canPartitionKSubsets(nums1, k1));
            //System.out.println(canPartitionKSubsets(nums2, k2));
            System.out.println(canPartitionKSubsets(nums3, k3));
      }
}
