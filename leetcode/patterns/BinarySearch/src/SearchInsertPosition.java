public class SearchInsertPosition {
      public static int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                  int mid = left + (right - left) / 2;

                  if (target == nums[mid]) {
                        return mid;
                  } else if (target > nums[mid]) {
                        left = mid + 1;
                  } else  {
                        right = mid - 1;
                  }
            }

            return left;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,3,5,6}; //2
            int target1 = 5;

            int[] nums2 = {1,3,5,6}; // 1
            int target2 = 2;

            int[] nums3 = {1,3,5,6}; // 4
            int target3 = 7;

            System.out.println(searchInsert(nums1, target1)); // 2
            System.out.println(searchInsert(nums2, target2)); // 1
            System.out.println(searchInsert(nums3, target3)); // 4
      }
}
