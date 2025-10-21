import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {
      public static int[] searchRange(int[] nums, int target) {
            int left = findLeftIndex(nums, target);
            int right = findRightIndex(nums, target);

            return new int[]{left, right};
      }

      private static int findLeftIndex(int[] nums, int target) {
            int index = -1, left = 0, right = nums.length - 1;

            while (left <= right) {
                  int mid = left + (right - left) / 2;

                  if (target == nums[mid]) {
                        index = mid;
                        right = mid - 1;
                  } else if (target > nums[mid]) {
                        left = mid + 1;
                  } else {
                        right = mid - 1;
                  }
            }

            return index;
      }

      private static int findRightIndex(int[] nums, int target) {
            int index = -1, left = 0, right = nums.length - 1;

            while (left <= right) {
                  int mid = left + (right - left) / 2;

                  if (target == nums[mid]) {
                        index = mid;
                        left = mid + 1;
                  } else if (target > nums[mid]) {
                        left = mid + 1;
                  } else {
                        right = mid - 1;
                  }
            }

            return index;
      }

      public static void main(String[] args) {
            int[] nums1 = {5,7,7,8,8,10}; // {3,4}
            int target1 = 8;

            int[] nums2 = {5,7,7,8,8,10}; // {-1,-1}
            int target2 = 6;

            int[] nums3 = {}; // {-1,-1}
            int target3 = 0;

            System.out.println(Arrays.toString(searchRange(nums1, target1)));
            System.out.println(Arrays.toString(searchRange(nums2,target2)));
            System.out.println(Arrays.toString(searchRange(nums3, target3)));
      }
}
