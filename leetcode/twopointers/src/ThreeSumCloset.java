import java.util.Arrays;

public class ThreeSumCloset {
      public static int threeSumClosest(int[] nums, int target) {
            if (nums == null || nums.length < 3) return -1;

            Arrays.sort(nums);
            int closestSum = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length - 2; i++) {
                  int left = i + 1;
                  int right = nums.length - 1;

                  while (left < right) {
                        int sum = nums[i] + nums[left] + nums[right];

                        if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                              closestSum = sum;
                        }
                        //closestSum = Math.min(Math.abs(sum - target), Math.abs(closestSum - target));

                        if (sum == target) {
                              return sum;
                        } else if (sum < target) {
                              left++;
                        } else {
                              right--;
                        }
                  }
            }

            return closestSum;
      }

      public static void main(String[] args) {
            int[] nums1 = {-1,2,1,-4};
            int target1 = 1;

            int[] nums2 = {0,0,0};
            int target2 = 1;

            System.out.println(threeSumClosest(nums1, target1));
            System.out.println(threeSumClosest(nums2, target2));
      }
}
