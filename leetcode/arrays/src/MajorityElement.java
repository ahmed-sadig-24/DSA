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
      }
}
