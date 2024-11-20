public class MaximumSubarraySumCircular {
      public static int maxSubarraySumCircular(int[] nums) {
            if (nums.length == 0) return 0;

            int minSum = nums[0];
            int currMinSum = nums[0];
            int maxSum = nums[0];
            int currMaxSum = nums[0];
            int totalSum = nums[0];

            for (int i = 1; i < nums.length; i++) {
                  totalSum+= nums[i];

                  currMaxSum = Math.max(nums[i], currMaxSum + nums[i]);
                  maxSum = Math.max(maxSum, currMaxSum);

                  currMinSum = Math.min(nums[i], currMinSum + nums[i]);
                  minSum = Math.min(minSum, currMinSum);
            }

            System.out.println("total sum: " + totalSum);
            System.out.println("Min sum: " + minSum);
            System.out.println("Max sum: " + maxSum);

            if (totalSum == minSum) return maxSum;

            return Math.max((totalSum - minSum), maxSum);
      }

      public static void main(String[] args) {
            //int[] nums = {1,-2,3,-2};
            //int[] nums = {5,-3,5};
            //int[] nums = {-3,-2,-3};
            int[] nums = {-1,-2,-3,-1};

            System.out.println(maxSubarraySumCircular(nums));
      }
}
