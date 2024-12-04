import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeSortedArrayIntoAnother {
      public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int p1 = m - 1;
            int p2 = n - 1;
            int i = m + n - 1;

            while (p2 >= 0) {
                  if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                        nums1[i--] = nums1[p1--];
                  } else {
                        nums1[i--] = nums2[p2--];
                  }
            }
      }

      public static void main(String[] args) {
            /*
            int[] nums1 = {1,2,3,0,0,0};
            int m = 3;
            int[] nums2 = {2,5,6};
            int n = 3;

            merge(nums1, m, nums2, n);
            System.out.println(Arrays.toString(nums1));

             */

            ArrayList<Integer> input1 = new ArrayList<>();
            ArrayList<Integer> input2 = new ArrayList<>();
            Collections.addAll(input1, 1,3,5);
            Collections.addAll(input2,2,4,6,0,0,0);

            merge_one_into_another(input1, input2);

            System.out.println(input2);

            //System.out.println(Arrays.toString(new ArrayList[]{dutch_flag_sort(input)}));
      }

      static ArrayList<Integer> merge_one_into_another(ArrayList<Integer> first, ArrayList<Integer> second) {
            //{
              //    "first": [1, 3, 5],
                //  "second": [2, 4, 6, 0, 0, 0]
            //}
            // [1, 2, 3, 4, 5, 6]

            // Write your code here.
            int p1 =  first.size() - 1;
            int p2 = p1;
            int i = second.size() - 1;

            while (p1 >= 0) {
                  if (p2 >= 0 && second.get(p2) > first.get(p1)) {
                        second.set(i--, second.get(p2--));
                  } else {
                        second.set(i--, first.get(p1--));
                  }
            }
            return new ArrayList(second);
      }
}
