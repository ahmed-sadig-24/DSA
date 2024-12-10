import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
      public static List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            //Arrays.sort(nums);
            backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

            return result;
      }

      private static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums, boolean[] used) {
            //base case
            if (tempList.size() == nums.length && !result.contains(tempList)) {
                  result.add(new ArrayList<>(tempList));
                  return;
            }

            for (int i = 0; i < nums.length; i++) {
                  // skip duplicates
                  if (used[i]) continue;

                  used[i] = true;
                  tempList.add(nums[i]);

                  backtrack(result, tempList, nums, used);

                  used[i] = false;
                  tempList.remove(tempList.size() - 1);
            }

      }

      public static void main(String[] args) {
            int[] nums1 = {1,1,2};
            int[] nums2 = {1,2,3};

            System.out.println(permuteUnique(nums1));
            System.out.println(permuteUnique(nums2));
      }
}
