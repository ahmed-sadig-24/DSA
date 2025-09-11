public class RemoveDuplicatesSortedArray2 {
      public static int removeDuplicates(int[] nums) {
            int i = 0;

            for (int num: nums) {
                  if (i < 2 || num != nums[i - 2]) {
                        nums[i++] = num;
                  }
            }

            return i;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,1,1,2,2,3};
            int[] nums2 = {0,0,1,1,1,1,2,3,3};

            System.out.println(removeDuplicates(nums1));
            System.out.println(removeDuplicates(nums2));
      }
}
