import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CommonElementsArrays {
      public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
            int num1Count = 0;
            int num2Count = 0;

            for (int i = 0; i < nums1.length;i++) {
                  for (int j = 0; j < nums2.length; j++) {
                        if (nums1[i] == nums2[j]) {
                              num1Count++;
                              break;
                        }
                  }
            }

            for (int i = 0; i < nums2.length; i++) {
                  for (int j = 0; j < nums1.length; j++) {
                        if (nums2[i] == nums1[j]) {
                              num2Count++;
                              break;
                        }
                  }
            }

            return new int[]{num1Count, num2Count};
      }

      public static int[] findIntersectionValuesSets(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int n1: nums1) {
                  set1.add(n1);
            }

            for (int n2: nums2) {
                  set2.add(n2);
            }

            int count1 = 0;
            int count2 = 0;

            for (int i = nums1.length -1; i >= 0; i--) {
                  if (set2.contains(nums1[i])) {
                        count1++;
                  }
            }

            for (int i = nums2.length -1; i >= 0; i--) {
                  if (set1.contains(nums2[i])) {
                        count2++;
                  }
            }

            return new int[]{count1,count2};
      }

      public static void main(String[] args) {
            int[] nums1 = {2, 3, 2};
            int[] nums2 = {1, 2};

            System.out.println(Arrays.toString(findIntersectionValues(nums1, nums2)));
            //System.out.println(Arrays.toString(findIntersectionValuesSets(nums1, nums2)));
      }
}
