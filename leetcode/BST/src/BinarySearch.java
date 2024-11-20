public class BinarySearch {
      public static int search(int[] nums, int target) {
            if (nums.length == 0) return -1;

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                  int mid = left +  (right - left) / 2;
                  System.out.println("mid: " + mid);

                  if (nums[mid] == target) {
                        return mid;
                  } else if (target < nums[mid]) {
                        right = mid - 1;
                  } else {
                        //System.out.println("mid: " + mid);
                        left = mid + 1;
                        System.out.println("left: " + left);
                  }
            }

            return -1;
      }

      public static void main(String[] args) {
            int [] nums = {-1,0,3,5,9,12};
            int target = 9;

            //int [] nums = {-1,0,3,5,9,12};
            //int target = 2;

            System.out.println(search(nums, target));
      }
}
