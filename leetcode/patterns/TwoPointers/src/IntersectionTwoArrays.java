import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class IntersectionTwoArrays {
      public static int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);

            int m = nums1.length;
            int n = nums2.length;
            int p1 = 0;
            int p2 = 0;

            HashSet<Integer> intersectSet = new HashSet<>();

            while (p1 < m && p2 < n) {
                  if (nums1[p1] == nums2[p2]) {
                        intersectSet.add(nums1[p1]);
                        p1++;
                        p2++;

                  } else if (nums1[p1] > nums2[p2]) {
                        p2++;
                  } else {
                        p1++;
                  }
            }

            int[] result = new int[intersectSet.size()];
            int i = 0;
            for (int num: intersectSet) {
                  result[i++] = num;
            }

            return result;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,2,2,1};
            int[] nums2 = {2,2};

            int[] nums3 = {4,9,5};
            int[] nums4 = {9,4,9,8,4};

            System.out.println(Arrays.toString(intersection(nums1, nums2)));
            System.out.println(Arrays.toString(intersection(nums3, nums4)));
      }
}
