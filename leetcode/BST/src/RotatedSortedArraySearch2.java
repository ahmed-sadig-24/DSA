public class RotatedSortedArraySearch2 {
      public static boolean search(int[] nums, int target) {
            return modifiedBinarySearch(nums, target, 0, nums.length - 1);
      }

      private static boolean modifiedBinarySearch(int[] nums, int target, int start, int end) {
            if (start > end) return false;

            int mid = start + (end - start) / 2;

            if (target == nums[mid]) return true;

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                  // Skip duplicates
                  return modifiedBinarySearch(nums, target, start + 1, end - 1);
            }

            //check if left half is sorted
            if (nums[mid] >= nums[start]) {
                  if (target >= nums[start] && target < nums[mid]) {
                        return modifiedBinarySearch(nums, target, start, mid - 1);
                  } else {
                        return modifiedBinarySearch(nums, target, mid + 1, end);
                  }
            } else { // right is sorted
                  if (target > nums[mid] && target <= nums[end] ) {
                        return modifiedBinarySearch(nums, target, mid + 1, end);
                  } else {
                        return modifiedBinarySearch(nums, target, start, mid - 1);
                  }
            }
      }


      public static void main(String[] args) {
            int[] nums = {2,5,6,0,0,1,2};
            int target = 20;

            int[] nums2 = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
            int target2 = 13;

            System.out.println(search(nums,target));
            System.out.println(search(nums2, target2));
      }
}
