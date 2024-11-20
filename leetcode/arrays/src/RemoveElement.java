import java.util.Arrays;

public class RemoveElement {
      public static int removeElement(int[] nums, int val) {
            int c= 0;
            //System.out.println("nn");
            for (int i = 0; i < nums.length; i++) {
                  if(nums[i] != val) {

                        nums[c] = nums[i];
                        c++;
                  }
            }
            //System.out.println(c);
            return c;
      }

      public static void main(String[] args) {
            int[] nums = {3, 2, 2, 3};
            //removeElement(nums,3);
            System.out.println(removeElement(nums,3));
            //System.out.println(Arrays.toString(removeElement(nums, 3)));
      }
}
