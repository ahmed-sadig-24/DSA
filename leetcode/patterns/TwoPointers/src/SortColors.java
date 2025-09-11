import java.util.Arrays;

public class SortColors {
      public static void sortColors(int[] nums) {
            int left = 0;
            int mid = 0;
            int right = nums.length - 1;

            while (mid < right) {
                  switch (nums[mid]) {
                        case 0:
                              swap(nums, mid, left);
                              left++;
                              mid++;
                              break;
                        case 1:
                              mid++;
                              break;
                        case 2:
                              swap(nums, mid, right);
                              right--;
                              break;
                  }
            }
      }

      private static void swap(int[] nums, int firstIndex, int secondIndex) {
            int temp =  nums[firstIndex];
            nums[firstIndex] = nums[secondIndex];
            nums[secondIndex] = temp;
      }

      public static void main(String[] args) {
            int[] nums1 = {2,0,2,1,1,0};

            sortColors(nums1);

            System.out.println(Arrays.toString(nums1));

      }
}
