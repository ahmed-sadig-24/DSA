import java.util.Arrays;

public class FindFirstAndLastSortedArray {
      public static int[] searchRange(int[] nums, int target) {
            int left = findLeftIndex(nums, target);
            int right = findRightIndex(nums, target);

            return new int[]{left, right};
      }

      private static int findLeftIndex(int[] nums, int target) {
            int left = 0, right = nums.length - 1, index = -1;

            while (left <= right) {
                  int mid = left + (right - left) / 2;

                  if (target == nums[mid]) {
                        index = mid;
                        right = mid - 1;
                  } else if (target < nums[mid]) {
                        right = mid - 1;
                  } else {
                        left = mid + 1;
                  }
            }
            return index;
      }

      private static int findRightIndex(int [] nums, int target) {
            int left = 0, right = nums.length - 1, index = -1;

            while (left <= right) {
                  int mid = left + (right - left) / 2;

                  if (target == nums[mid]) {
                        index = mid;
                        left = mid + 1;
                  } else if (target < nums[mid]) {
                        right = mid - 1;
                  } else {
                        left = mid + 1;
                  }
            }

            return index;
      }

      public static void main(String[] args) {
            int[] nums = {5,7,7,8,8,10};
            int target = 8;

            //int[] nums = {5,7,7,8,8,10};
            //int target = 6;

            //int[] nums = {};
            //int target = 0;

            System.out.println(Arrays.toString(searchRange(nums, target)));
      }
}
