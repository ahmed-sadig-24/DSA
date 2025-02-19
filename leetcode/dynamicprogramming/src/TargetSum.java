import java.util.HashMap;
import java.util.Map;

public class TargetSum {
      public static int findTargetSumWays(int[] nums, int target) {
            Map<Integer, Integer> dp = new HashMap<>();
            dp.put(0, 1);

            for (int num: nums) {
                  Map<Integer, Integer> nextDP = new HashMap<>();

                  for (Map.Entry<Integer, Integer> entry: dp.entrySet()) {
                        int sum = entry.getKey();
                        int count = entry.getValue();

                        nextDP.put(sum + num, nextDP.getOrDefault(sum + num, 0) + count);

                        nextDP.put(sum - num, nextDP.getOrDefault(sum - num , 0) + count);
                  }

                  dp = nextDP;
            }

            return dp.getOrDefault(target, 0);
      }

      public static void main(String[] args) {
            int[] nums1 = {1, 1, 1, 1, 1};
            int target1 = 3;

            int[] nums2 = {1};
            int target2 = 1;

            System.out.println(findTargetSumWays(nums1, target1));
            System.out.println(findTargetSumWays(nums2, target2));
      }
}
