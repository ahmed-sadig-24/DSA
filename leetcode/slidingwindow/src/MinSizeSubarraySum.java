public class MinSizeSubarraySum {
      public static int minSubArrayLen(int target, int[] nums) {
            int minSize = Integer.MAX_VALUE;
            int sum = 0;
            int startIndex = 0;
            int endIndex = 0;

            while (endIndex < nums.length) {
                  sum += nums[endIndex];
                  endIndex++;

                  while (sum >= target) {
                        int currSize = endIndex - startIndex;
                        minSize = Math.min(minSize, currSize);

                        sum -= nums[startIndex];
                        startIndex++;
                  }
            }

            return minSize == Integer.MAX_VALUE ? 0 : minSize;
      }

      public static void main(String[] args) {
            //int target = 7;
            //int [] nums = {2,3,1,2,4,3};

            //int target = 4;
            //int [] nums = {1,4,4};

            int target = 11;
            int [] nums = {1,1,1,1,1,1,1,1};

            System.out.println(minSubArrayLen(target, nums));
      }
}
