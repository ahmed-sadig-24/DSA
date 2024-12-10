import java.util.ArrayList;
import java.util.List;

public class Subsets {
      public static List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            generateSubsets(result, new ArrayList<>(), nums, 0);

            return result;
      }

      private static void generateSubsets(List<List<Integer>> result, ArrayList<Integer> current, int[] nums, int index) {
            result.add(new ArrayList<>(current));

            for (int i = index; i < nums.length; i++) {
                  current.add(nums[i]);

                  generateSubsets(result, current, nums, i + 1);

                  current.remove(current.size() - 1);

            }
      }

      public static void main(String[] args) {
            int[] nums1 = {1,2,3};
            //int[] nums2 = {0};

            System.out.println(subsets(nums1));
            //System.out.println(subsets(nums2));
      }
}
