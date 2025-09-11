public class MaximumAverageSubarray1 {
      public static double findMaxAverage(int[] nums, int k) {
            int left = 0;
            int right = k;

            int currSum = 0;
            for (int i = 0; i < k; i++) {
                  currSum += nums[i];
            }

            int maxSum = currSum;
            while (right < nums.length) {
                  currSum -= nums[left++];
                  currSum += nums[right++];

                  maxSum = Math.max(maxSum, currSum);
            }

            return (double) maxSum / k;
      }

      public static void main(String[] args) {
            int [] nums = {1,12,-5,-6,50,3};
            int k = 4;
            //int[] nums = {5};
            //int k = 1;

            System.out.println(findMaxAverage(nums, k));
      }
}
