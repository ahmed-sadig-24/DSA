import java.util.Arrays;
import java.util.HashMap;

public class twoSumArray {

      public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> sumMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                  int complement = target - nums[i];

                  if (sumMap.containsKey(complement)) {
                        return new int[]{sumMap.get(complement), i};
                  }

                  sumMap.put(nums[i], i);
            }

            return new int[]{};
      }
      public static void main(String[] args) {
            int[] nums = {5, 3, 10, 45, 1};
            int target =  6;

            System.out.println(Arrays.toString(twoSum(nums, target)));
      }
}
