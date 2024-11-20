public class RotatedSortedArraySearch {
      public static int search(int[] nums, int target) {
            return modifiedBinarySearch(nums, target, 0, nums.length - 1);
      }

      private static int modifiedBinarySearch(int[] nums, int target, int start, int end) {
            if (start > end) return -1;

            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid;

            //check if left half is sorted
            if (nums[mid] >= nums[start]) {
                  if (target >= nums[start] && target <= nums[mid]) {
                        return modifiedBinarySearch(nums, target, start, mid - 1);
                  } else {
                        return modifiedBinarySearch(nums, target, mid + 1, end);
                  }
            } else {
                  if (target >= nums[end] && target >= nums[mid]) {
                        return modifiedBinarySearch(nums, target, mid + 1, end);
                  } else {
                        return modifiedBinarySearch(nums, target, start, mid - 1);
                  }
            }
      }

      public static void main(String[] args) {
            int [] nums = {4,5,6,7,0,1,2};
            int target = 0;

            //int [] nums = {4,5,6,7,0,1,2};
            //int target = 3;

            //int[] nums = {1};
            //int target = 0;

            int[] nums4 = {0,1,1,2,3,4,5};
            int target4 =  4;

            int[] nums5 = {2,5,6,0,0,1,2};
            int target5 = 0;

            System.out.println(search(nums, target));
            System.out.println(search(nums4, target4));
            System.out.println(search(nums5, target5));
      }
}
