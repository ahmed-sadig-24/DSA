import java.util.ArrayList;
import java.util.List;

public class Permutations {
      public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            if (nums == null || nums.length == 0) return result;

            backtrack(nums, new ArrayList<>(), result);

            return result;
      }

      private static void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
            if (tempList.size() == nums.length) {
                  result.add(new ArrayList<>(tempList));
                  return;
            }

            for (int num: nums) {
                  if (tempList.contains(num)) continue;

                  tempList.add(num);

                  backtrack(nums, tempList, result);
                  //backtrack
                  tempList.remove(tempList.size() - 1);
            }
      }

      public static void main(String[] args) {
            int[] nums = {1,2,3};

            System.out.println(permute(nums));
      }
}
