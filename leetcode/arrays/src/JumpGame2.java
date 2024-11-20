public class JumpGame2 {
      public static int jump(int[] nums) {

            if (nums.length == 1) return 0;

            int totalJumps = 0;
            int dest = nums.length - 1;
            int coverage = 0, lastJumpIdx = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                  coverage = Math.max(coverage, i + nums[i]);

                  if (i == lastJumpIdx) {
                        lastJumpIdx = coverage;
                        totalJumps++;
                  }

                  //if (coverage >= dest) {
                    //        return totalJumps;
                  //}
            }

            return totalJumps;
      }

      public static void main(String[] args) {
            //int[] nums = {2,3,1,1,4};
            //int[] nums = {2,3,0,1,4};
            int[] nums = {2,4,1,2,3,1,1,2};

            System.out.println(jump(nums));
      }
}
