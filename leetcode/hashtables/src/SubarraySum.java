import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

      public static int[] subarraySum(int[] nums, int target) {
            Map<Integer, Integer> myHashMap = new HashMap<>();
            myHashMap.put(0, -1);
            int currentSum = 0;

            for (int i = 0; i < nums.length; i++) {
                  currentSum += nums[i];

                  if (myHashMap.containsKey(currentSum - target)) {
                        //System.out.println("currentSum: " + currentSum);
                        //System.out.println("target: " +  target);
                        //System.out.println("i:" + i);
                        //System.out.println(myHashMap.get(currentSum - target) + 1);
                        //System.out.println(myHashMap.get(0));
                        return new int[] {myHashMap.get(currentSum - target) + 1, i};
                  }

                  myHashMap.put(currentSum, i);
            }

            return new int[]{};
      }

      public static int subArraySumCount(int[] nums, int k) {
            Map<Integer, Integer> myHashMap = new HashMap<>();
            myHashMap.put(0, 1);
            int sum = 0;
            int resultCount = 0;

            for (int i = 0; i < nums.length; i++) {
                  sum += nums[i];

                  if (myHashMap.containsKey(sum - k)) {
                        resultCount += myHashMap.get(sum - k);
                  }

                  myHashMap.put(sum, myHashMap.getOrDefault(sum,0) + 1);
            }

            return resultCount;
      }

      public static void main(String[] args) {
            //int[] nums = {1, 2, 3, 4, 5};
            //int target = 10;

            //System.out.println(Arrays.toString(subarraySum(nums, target)));

            int[] nums = {1, 2, 3};
            int target = 3;

            System.out.println(subArraySumCount(nums, target));
      }
}
