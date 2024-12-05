import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumSmaller {
      static Integer count_triplets(Integer target, ArrayList<Integer> numbers) {
            if (numbers == null || numbers.size() < 3) return  -1;

            Collections.sort(numbers);
            int count = 0;

            for (int i = 0; i < numbers.size() - 2; i++) {
                  int left = i + 1;
                  int right = numbers.size() - 1;

                  while (left < right) {
                        int sum = numbers.get(i) + numbers.get(left) + numbers.get(right);

                        if (sum < target) {
                              // count
                              count += (right - left);
                              left++;
                        } else {
                              right--;
                        }
                  }
            }

            return count;
      }

      public static void main(String[] args) {
            ArrayList<Integer> numbers = new ArrayList<>();
            //Collections.addAll(numbers, 5, 0, -1, 3, 2);
            //int target = 4;
            Collections.addAll(numbers, 3,1,4);
            int target = 7;

            System.out.println(count_triplets(target, numbers));

      }
}
