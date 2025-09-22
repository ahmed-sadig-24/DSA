import java.util.HashSet;

public class ContainsDuplicate {
      public static boolean containsDuplicate(int[] nums) {
            HashSet<Integer> dupSet = new HashSet<>();

            for (int num: nums) {
                  if (dupSet.contains(num)) return true;
                  dupSet.add(num);
            }

            return false;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,2,3,1}; // true
            int[] nums2 = {1,2,3,4}; // false
            int[] nums3 = {1,1,1,3,3,4,3,2,4,2}; // true

            System.out.println(containsDuplicate(nums1));
            System.out.println(containsDuplicate(nums2));
            System.out.println(containsDuplicate(nums3));
      }
}
