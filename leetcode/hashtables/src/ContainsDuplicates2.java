import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicates2 {
      public static boolean containsNearbyDuplicate(int[] nums, int k) {
            Map<Integer, Integer> myHashMap = new HashMap<>();

            for (int i = 0; i < nums.length;i++) {
                  //if (myHashMap.containsKey(nums[i])) {
                    //    if (Math.abs(i - myHashMap.get(nums[i])) <=k) return true;
                  //}
                  if (Math.abs(myHashMap.get(nums[i]) - i) <= k) return true;

                  myHashMap.put(nums[i], i);
            }

            return false;
      }

      public static void main(String[] args) {
            //int[] nums = {1, 2, 3, 1};
            int[] nums = {1, 2, 3, 1, 2, 3};

            System.out.println(containsNearbyDuplicate(nums, 2));
      }
}
