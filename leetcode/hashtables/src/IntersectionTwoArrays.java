import java.util.*;

public class IntersectionTwoArrays {
      public static int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> numSet = new HashSet<>();
            Set<Integer> result = new HashSet<>();
            //Set<List<Integer>> result = new HashSet<>();


            for (int num: nums1) {
                  numSet.add(num);
            }

            for (int num: nums2) {
                  if (numSet.contains(num)) {
                        //return new int[]{num};
                        result.add(num);
                  }
            }

            int[] intersection = new int[result.size()];
            int index = 0;

            for (int num: result) {
                  intersection[index++] = num;
            }

            return intersection;
      }

      public static void main(String[] args) {
            //int[] nums1 = {1,2,2,1},  nums2 = {2,2};
            int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};

            System.out.println(Arrays.toString(intersection(nums1, nums2)));
      }
}
