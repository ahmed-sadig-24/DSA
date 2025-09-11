import java.util.Arrays;

public class RemoveDuplicatesSortedArray {
      public static int removeDuplicates(int[] nums) {
            int p1 = 1;
            for (int i = 1; i < nums.length; i++) {
                  if (nums[i - 1] != nums[i]) {
                        nums[p1] = nums[i];
                        p1++;
                  }
            }

            return p1;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,1,2};
            int[] nums2 = {0,0,1,1,1,2,2,3,3,4};

            System.out.println(removeDuplicates(nums1));
            System.out.println(removeDuplicates(nums2));
      }
}
