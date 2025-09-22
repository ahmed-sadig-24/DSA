import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
      public static int[] twoSum(int[] numbers, int target) {
            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int i = 0;i < numbers.length; i++) {
                  int complement = target - numbers[i];

                  if (hm.containsKey(complement)) {
                        return new int[]{hm.get(complement), i};
                  }

                  hm.put(numbers[i], i);
            }

            return new int[]{};
      }

      public static void main(String[] args) {
            int[] nums1 = {2,7,11,15}; // [0,1]
            int target1 = 9;

            System.out.println(Arrays.toString(twoSum(nums1, target1)));
      }
}
