public class RotatedArray2 {
            public static boolean search(int[] nums, int target) {
                  return helper(nums, target, 0, nums.length - 1);
            }

            public static boolean helper(int[] nums, int target, int low, int high) {
                  if (low > high) return false;

                  int mid = low + (high - low) / 2;

                  // Check if mid is the target
                  if (nums[mid] == target) return true;
                  // Handle duplicates
                  if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                        // Skip duplicates
                        return helper(nums, target, low + 1, high - 1);
                  }

                  // Determine which side is sorted
                  if (nums[low] <= nums[mid]) {  // Left side is sorted
                        if (nums[low] <= target && target < nums[mid]) {
                              return helper(nums, target, low, mid - 1);  // Search left
                        } else {
                              return helper(nums, target, mid + 1, high);  // Search right
                        }
                  } else {  // Right side is sorted
                        if (nums[mid] < target && target <= nums[high]) {
                              return helper(nums, target, mid + 1, high);  // Search right
                        } else {
                              return helper(nums, target, low, mid - 1);  // Search left
                        }
                  }
            }

      public static void main(String[] args) {
            int[] nums = {2,5,6,0,0,1,2};
            int target = 5;

            System.out.println(search(nums, target));
      }
      }
