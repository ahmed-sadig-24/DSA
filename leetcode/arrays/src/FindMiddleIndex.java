public class FindMiddleIndex {
      public static int findMiddleIndex(int[] nums) {
            int totalSum = 0;
            for (int i = 0; i < nums.length; i++) {
                  totalSum += nums[i];
            }

            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                  int rightSum = totalSum - leftSum - nums[i];

                  if (leftSum == rightSum) return i;

                  leftSum += nums[i];
            }

            return -1;
      }

      public static void main(String[] args) {
            //int[] nums = {2, 3, -1, 8, 4};
            //int[] nums = {1,-1,4};
            int[] nums = {2, 5};

            System.out.println(findMiddleIndex(nums));
      }
}
