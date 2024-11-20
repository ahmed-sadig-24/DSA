public class SingleNumber2 {
      public static int singleNumber(int[] nums) {
            int ones = 0;
            int twos = 0;

            for (int num: nums) {
                  ones = (ones ^ num) & ~ twos;
                  twos = (twos ^ num) & ~ ones;
            }

            return ones;
      }

      public static void main(String[] args) {
            //int[] nums = {2,2,3,2};
            int[] nums = {0,1,0,1,0,1,99};

            System.out.println(singleNumber(nums));
      }
}
