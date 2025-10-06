public class BinarySearch {
      public static int search(int[] nums, int target) {
            if (nums.length == 0) return -1;

            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                  int mid = left + (right - left) / 2;

                  if (target == nums[mid]) {
                        return mid;
                  } else if (target > nums[mid]) {
                        left = mid + 1;
                  } else {
                        right = mid - 1;
                  }
            }

            return -1;
      }

      public static void main(String[] args) {
            int[] nums1 = {-1,0,3,5,9,12}; // 4
            int target1 = 9;

            int[] nums2 = {-1,0,3,5,9,12}; // -1
            int target2 = 2;

            System.out.println(search(nums1, target1));
            System.out.println(search(nums2, target2));
      }
}
