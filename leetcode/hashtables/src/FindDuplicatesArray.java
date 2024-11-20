import java.util.*;

public class FindDuplicatesArray {

      public static List<Integer> findDuplicates(int[] nums) {
            Map<Integer, Integer> numCounts = new HashMap<>();

            for (int num : nums) {
                  numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
            }
            List<Integer> duplicates = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
                  if (entry.getValue() > 1) {
                        duplicates.add(entry.getKey());
                  }
            }

            return duplicates;
      }

      public static List<Integer> findDuplicates2(int[] nums) {
            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                  int index = Math.abs(nums[i] -1);

                  if (nums[index] < 0) {
                        result.add(index + 1);
                  }
                  nums[index] = nums[index] * -1;
            }

            return result;
      }

      public static List<Integer> findDuplicates3(int[] nums) {
            List<Integer> result = new ArrayList<>();

            for(int i = 0; i < nums.length; i++) {
                  int index = Math.abs(nums[i]) - 1;
                  System.out.println("index: " + index);

                  if(nums[index] < 0) {
                        result.add(index + 1);
                  }
                  nums[index] = nums[index] * - 1;
            }

            return result;
      }

      public static void main(String[] args) {
            int[] nums = {4,3,2,7,8,2,3,1};

            //System.out.println(findDuplicates(nums));
            //System.out.println(findDuplicates2(nums));
            System.out.println(findDuplicates3(nums));

      }
}
