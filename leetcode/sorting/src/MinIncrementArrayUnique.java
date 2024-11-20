import java.util.Arrays;

public class MinIncrementArrayUnique {
      public static int minIncrementForUnique(int[] nums) {
            int moves = 0;

            Arrays.sort(nums);

            for (int i = 1; i < nums.length; i++) {
                  if (nums[i] <= nums[i - 1]) {
                        moves += nums[i - 1] - nums[i] + 1;
                        nums[i] = nums[i - 1] + 1;
                        //System.out.println("moves: " + moves);
                  }
            }

            return moves;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,2,2};
            int[] nums2 = {3,2,1,2,1,7};

            //System.out.println(minIncrementForUnique(nums1));
            System.out.println(minIncrementForUnique(nums2));
      }
}
