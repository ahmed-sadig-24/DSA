public class MissingNumber {
      public static int missingNumber(int[] nums) {
            int allXOR = 0;

            for(int i = 0; i <= nums.length; i++) {
                  allXOR = allXOR ^ i;
            }

            for (int num: nums) {
                  allXOR = allXOR ^ num;
            }

            return allXOR;
      }

      public static void main(String[] args) {
            //int[] nums = {3, 0, 1};
            int[] nums = {9,6,4,2,3,5,7,0,1};

            System.out.println(missingNumber(nums));
      }
}
