public class MaxAverageSubarray {
      public static double findMaxAverage(int[] nums, int k) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                  sum += nums[i];
            }
            int totalSum = sum;

            int startIndex = 0;
            int endIndex = k;

            while (endIndex < nums.length) {
                  sum -= nums[startIndex];
                  startIndex++;

                  sum += nums[endIndex];
                  endIndex++;

                  totalSum = Math.max(totalSum, sum);
            }

            return (double) totalSum / k;
      }

      public static void main(String[] args) {
            //int [] nums = {1,12,-5,-6,50,3};
            //int k = 4;
            int[] nums = {5};
            int k = 1;

            System.out.println(findMaxAverage(nums, k));
      }
}
