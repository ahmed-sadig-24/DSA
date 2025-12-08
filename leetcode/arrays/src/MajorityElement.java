import java.util.Arrays;

public class MajorityElement {
      public static int majorityElement(int[] nums) {
            int majority = nums[0], votes = 1;

            for (int i = 1; i < nums.length; i++) {
                  if (votes == 0) {
                        majority = nums[i];
                        votes++;
                  } else if (majority == nums[i]) {
                        votes++;
                  } else {
                        votes--;
                  }
            }

            return majority;
      }

      public static void main(String[] args) {
            //int[] nums = {3,2,3};
            int[] nums = {2,2,1,1,1,2,2};

            System.out.println(majorityElement(nums));
            System.out.println(majorityElementSorting(nums));
            System.out.println(majorityElementBF(nums));
      }

      public static int majorityElementSorting(int[] nums) {
            Arrays.sort(nums);

            int mid = nums.length / 2;

            return nums[mid];
      }

      public static int majorityElementBF(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                  int count = 0;

                  for (int j = 0; j < n; j++) {
                        if (nums[i] == nums[j]) count++;
                  }

                  if (count > n / 2) return nums[i];
            }

            return -1;
      }

}
