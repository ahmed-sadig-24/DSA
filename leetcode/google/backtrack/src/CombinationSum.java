import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
      public static List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();

            if (candidates == null || candidates.length == 0) return result;

            Arrays.sort(candidates);

            backtrack(candidates, target, 0, new ArrayList<>(), result);

            return result;
      }

      private static void backtrack(int[] candidates, int target, int start, List<Integer> curr, List<List<Integer>> result) {
            if (target == 0) {
                  result.add(new ArrayList<>(curr));
                  return;
            }

            for (int i = start; i < candidates.length; i++) {
                  if (candidates[i] > target) {
                        break;
                  }

                  curr.add(candidates[i]);
                  backtrack(candidates, target - candidates[i], i, curr, result);

                  curr.remove(curr.size() - 1);
            }
      }

      public static void main(String[] args) {
            int[] candidates = {2,3,6,7};
            int target = 7;

            System.out.println(combinationSum(candidates, target));
      }
}
