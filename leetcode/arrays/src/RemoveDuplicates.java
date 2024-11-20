public class RemoveDuplicates {
      public static int removeDuplicates(int[] nums) {
            if (nums.length == 0) return 0;

            int myPointer = 1;

            for (int i = 1; i < nums.length; i++) {
                  if (nums[i] != nums[i - 1]) {
                        nums[myPointer] = nums[i];
                        myPointer++;
                  }
            }

            return myPointer;
      }

      public static void main(String[] args) {
            //int[] nums = {1, 1, 2};
            int[] nums = {0,0,1,1,1,2,2,3,3,4};
            System.out.println(removeDuplicates(nums));
      }
}
