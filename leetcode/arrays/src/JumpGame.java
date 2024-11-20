public class JumpGame {
      public static boolean canJump(int[] nums) {
            int dest = nums.length - 1;

            for (int idx = dest - 1; idx >= 0; idx--) {
                  if (idx + nums[idx] == dest) {
                        dest = idx;
                  }
            }

            return dest == 0;
      }

      public static void main(String[] args) {
            //int[] nums = {2,3,1,1,4};
            int[] nums = {3,2,1,0,4};

            System.out.println(canJump(nums));
      }
}
