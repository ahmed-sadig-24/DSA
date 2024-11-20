public class MaximumuSubarray {

      public static int maxSubarray(int[] nums) {
            int currSum = nums[0];
            int maxSum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                  currSum = Math.max(nums[i], nums[i] + currSum);
                  maxSum = Math.max(currSum, maxSum);
            }

            return maxSum;
      }

      public static void main(String[] args) {
            int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

            System.out.println(maxSubarray(nums));
      }
}
