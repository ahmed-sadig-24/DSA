import java.util.ArrayList;
import java.util.Arrays;

public class twoSumSortedArray {

      public static int[] twoSum(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                  int sum = nums[left] + nums[right];
                  if (sum == target) {
                        return new int[]{left, right};
                  } else if (sum < target) {
                        left++;
                  } else {
                        right--;
                  }
            }

            return new int[]{};
      }
      public static void main(String[] args) {
            int[] nums = {1, 2, 3, 5, 10};
            int target = 7;

            System.out.println(Arrays.toString(twoSum(nums, target)));
            //System.out.println(pair_sum_sorted_array(nums, target));
      }

}
