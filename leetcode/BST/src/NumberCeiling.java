public class NumberCeiling {
      public static int numberCeiling(int[] nums, int target) {
            int start = 0, end = nums.length - 1;

            while (start <= end) {
                  int mid = start + (end - start) / 2;

                  if (target == nums[mid]) {
                        return mid;
                  } else if (target < nums[mid]) {
                        end = mid - 1;
                  } else {
                        start = mid + 1;
                  }
            }

            return start;
      }

      public static void main(String[] args) {
            int[] nums = {1, 3, 5, 7, 9};
            int target = 6;

            System.out.println(numberCeiling(nums, target));
      }
}
