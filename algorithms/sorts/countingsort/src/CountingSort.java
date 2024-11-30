import java.util.Arrays;

public class CountingSort {

      public static void countingSort(int[] nums) {
            int min = Arrays.stream(nums).min().getAsInt();
            int max = Arrays.stream(nums).max().getAsInt();
            int range = max - min + 1;

            int[] count = new int[range];
            int[] result = new int[nums.length];

            for (int num: nums) {
                  count[num - min]++;
            }

            for (int i = 1; i < count.length; i++) {
                  count[i] += count[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                  result[count[nums[i] - min] - 1] = nums[i];
                  count[nums[i] - min]--;
            }

            System.arraycopy(result,0,nums,0, nums.length);
      }
      public static void main(String[] args) {
            //int[] nums = {2,3,1,2,5,1,2,5,2,5};
            //int[] nums = {4,4, 2,2,2, 1, 3, 1};
            int[] nums = {5, 8, 3, 9, 4, 1, 7};

            countingSort(nums);
            System.out.println(Arrays.toString(nums));
      }
}
