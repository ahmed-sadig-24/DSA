import java.util.*;

public class IntersectionOfTwoArrays {
      public static int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> dupSet = new HashSet<>();
            List<Integer> intersect = new ArrayList<>();

            for (int num: nums1) {
                  dupSet.add(num);
            }

            for (int num: nums2) {
                  if (dupSet.contains(num)) {
                        intersect.add(num);
                        dupSet.remove(num);
                  }
            }

            int[] result = new int[intersect.size()];
            for (int i = 0; i < intersect.size(); i++) {
                  result[i] = intersect.get(i);
            }

            return result;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,2,2,1}, nums2 = {2,2};
            int[] nums3 = {4,9,5}, nums4 = {9,4,9,8,4};

            System.out.println(Arrays.toString(intersection(nums1, nums2)));
            System.out.println(Arrays.toString(intersection(nums3, nums4)));
      }
}
