import java.util.Arrays;

public class TwoSum2 {
      public static int[] twoSum(int[] numbers, int target) {
            if (numbers == null) return new int[]{};

            int[] result = new int[numbers.length];
            int left = 0;
            int right = numbers.length - 1;
            //System.out.println(right);

            while (left < right) {
                  int sum = numbers[left] + numbers[right];

                  if (sum == target) {
                        return new int[]{left + 1, right + 1};
                        //left++;
                        //right--;
                  } else if (sum < target) {
                        left++;
                  } else {
                        right--;
                  }
            }

            return new int[]{};
      }

      public static void main(String[] args) {
            //int[] numbers = {2,7,11,15};
            //int target = 9;

            //int[] numbers = {2,3,4};
            //int target = 6;

            int[] numbers = {-1, 0};
            int target = -1;

            System.out.println(Arrays.toString(twoSum(numbers, target)));
      }
}
