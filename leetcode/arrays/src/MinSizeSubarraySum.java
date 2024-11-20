public class MinSizeSubarraySum {
      public static int minSubArrayLen(int target, int[] nums) {
            int minSize = Integer.MAX_VALUE;
            int currentSum = 0;
            int startIndex = 0;

            for (int endIndex = 0; endIndex < nums.length; endIndex++) {
                  currentSum += nums[endIndex];

                  while (currentSum >= target) {
                        minSize = Math.min(minSize, endIndex - startIndex + 1);
                        currentSum -= nums[startIndex];
                        startIndex++;
                  }
            }

            return minSize == Integer.MAX_VALUE ? 0 : minSize;
      }

      public static void main(String[] args) {
            int[] nums = {2,3,1,2,4,3};
            int target = 7;
            //int[] nums = {1,4,4};
            //int target = 4;

            //int[] nums = {1,1,1,1,1,1,1,1};
            //int target = 11;

            System.out.println(minSubArrayLen(target, nums));
      }
}
