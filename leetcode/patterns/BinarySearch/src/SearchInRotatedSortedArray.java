public class SearchInRotatedSortedArray {
      public static int search(int[] nums, int target) {
            if (nums.length == 0) return -1;

            return modifiedBinarySearch(nums, target, 0, nums.length - 1);
      }

      private static int modifiedBinarySearch(int[] nums, int target, int left, int right) {
            if (left > right) {
                  return -1;
            }

            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                  return mid;
            }

            // If left half is sorted
            if (nums[mid] >= nums[left]) {
                  if (nums[left] <= target && target <= nums[mid]) {
                        return modifiedBinarySearch(nums, target, left, mid - 1);
                  } else {
                        return modifiedBinarySearch(nums, target, mid + 1, right);
                  }
            } else
                  // If right half is sorted
                  if (target <= nums[left] && target >= nums[mid]) {
                        return modifiedBinarySearch(nums, target, mid + 1, right);
                  } else {
                        return modifiedBinarySearch(nums, target, left, mid - 1);
                  }
      }

      public static void main(String[] args) {
            int[] nums1 = {4,5,6,7,0,1,2}; // 4
            int target1 = 0;

            int[] nums2 = {4,5,6,7,0,1,2}; // -1
            int target2 = 3;

            int[] nums3 = {1}; // -1
            int target3 = 0;

            System.out.println(search(nums1, target1));
            System.out.println(search(nums2, target2));
            System.out.println(search(nums3, target3));
      }
}