import java.util.ArrayList;
import java.util.List;

public class Permutations {
      public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            backtrack(result, new ArrayList<Integer>(), nums);

            return result;
      }

      private static void backtrack(List<List<Integer>> result, ArrayList<Integer> tempList, int[] nums) {
            //base case
            if (tempList.size() == nums.length) {
                  result.add(new ArrayList<>(tempList));
                  return;
            }

            for (int num: nums) {
                  if (tempList.contains(num)) continue;

                  tempList.add(num);

                  backtrack(result, tempList, nums);

                  tempList.remove(tempList.size() - 1);
            }
      }

      public static void main(String[] args) {
            int[] nums1 = {1,2,3};
            int[] nums2 = {0,1};
            int[] nums3 = {1};
            int[] nums4 = {1,1,2}; // should fail

            System.out.println(permute(nums1));
            System.out.println(permute(nums2));
            System.out.println(permute(nums3));
            System.out.println(permute(nums4));
      }
}
