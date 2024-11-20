public class FindPivotIndex {
      public static int pivotIndex(int[] nums) {
            int totalSum = 0;
            for (int num: nums) {
                  totalSum += num;
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
            //int[] nums = {1,7,3,6,5,6};
            //int[] nums = {1,2,3};
            int[] nums = {2,1,-1};

            System.out.println(pivotIndex(nums));
      }
}
