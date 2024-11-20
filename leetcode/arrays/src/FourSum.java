import java.util.*;

public class FourSum {
      public static List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length < 4) return new ArrayList<>();

            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();

            for (int i = 0; i < nums.length - 3; i++) {
                  for (int j = i + 1; j < nums.length -2; j++) {
                        int left = j + 1;
                        int right = nums.length - 1;

                        while (left < right) {
                              int sum = nums[i] + nums[j] + nums[left] + nums[right];

                              if (sum == target) {
                                    result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                    left++;
                                    right--;
                              } else if (sum < target) {
                                    left++;
                              } else {
                                    right--;
                              }
                        }
                  }

            }

            return new ArrayList<>(result);
      }

      public static void main(String[] args) {
            //int[] nums = {1,0,-1,0,-2,2};
            //int target = 0;

            int[] nums = {2,2,2,2,2};
            int target = 8;

            System.out.println(fourSum(nums, target));
      }
}
