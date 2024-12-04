import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SegregateEvenOddNum {
      static int[] segregate_evens_and_odds(int[] numbers) {
            int left = 0;
            int right = numbers.length - 1;

            while (left < right) {
                  if (numbers[left] % 2 > numbers[right] % 2) {
                        int temp = numbers[left];
                        numbers[left] = numbers[right];
                        numbers[right] = temp;
                  }

                  if (numbers[left] % 2 == 0) {
                        left++;
                  }

                  if (numbers[right] % 2 == 1) {
                        right--;
                  }
            }

            return numbers;
      }

      public static void main(String[] args) {

            ArrayList<Integer> num = new ArrayList<>();
            num.add(1);
            num.add(2);
            num.add(3);
            num.add(4);



            //int[] nums = {1,2,3,4};
            //int[] nums = {3,1,2,4};
            //System.out.println(Arrays.toString(segregate_evens_and_odds(nums)));
            System.out.println(segregate_evens_and_odds2(num));
      }

      static ArrayList<Integer> segregate_evens_and_odds2(ArrayList<Integer> numbers) {
            int left = 0;
            int right = numbers.size() - 1;

            while (left < right) {
                  if (numbers.get(left) % 2 > numbers.get(right) % 2) {
                        Collections.swap(numbers, left,right);
                  }

                  if (numbers.get(left) % 2 == 0) {
                        left++;
                  }

                  if (numbers.get(right) % 2 == 1) {
                        right--;
                  }
            }

            return numbers;
      }

}
