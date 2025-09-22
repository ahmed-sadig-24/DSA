public class MinimumSizeSubarraySum {
      public static int minSubArrayLen(int target, int[] nums) {
            int left = 0;
            int right = 0;
            int currSum = 0;
            int minSize = Integer.MAX_VALUE;

            while (right < nums.length) {
                  currSum += nums[right++];

                  while (currSum >= target) {
                        minSize = Math.min(minSize, right - left);
                        currSum -= nums[left++];
                  }
            }

            return minSize == Integer.MAX_VALUE ? 0: minSize;
      }

      public static void main(String[] args) {
            int[] nums1 = {2,3,1,2,4,3};
            int target1 = 7;

            System.out.println(minSubArrayLen(target1, nums1));
      }
}
