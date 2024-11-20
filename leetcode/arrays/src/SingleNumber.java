import java.util.Arrays;

public class SingleNumber {
      public static int singleNumber(int[] nums) {
            int res = nums[0];

            for (int i = 1; i < nums.length; i++) {
                  res = res ^ nums[i];
            }

            return res;
      }

      public static void main(String[] args) {
            //int[] nums = {2, 2, 1, 3};
            int[] nums = {4, 1, 2, 1, 2};
            System.out.println(singleNumber(nums));

      }
}
