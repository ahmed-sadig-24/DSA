import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EqualSubsetPartition {
      static ArrayList<Boolean> equal_subset_sum_partition(ArrayList<Integer> s) {
            // Write your code here.
            int sum = 0;
            for (int num: s) {
                  if (num < 0) return new ArrayList<>();
                  sum += num;
            }

            if (sum % 2 != 0) {
                  return new ArrayList<>();
            }

            sum = sum / 2;

            ArrayList<Boolean> dp = new ArrayList<>();
            for (int i = 0; i <= sum; i++) {
                  dp.add(false);
            }

            dp.set(0,true);

            for (int num: s) {
                  for (int j = sum; j >= num; j--) {
                        dp.set(j,dp.get(j) || dp.get(j - num))  ;
                  }
            }

            return dp;
      }

      public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> input = new ArrayList<>();
            input.add(new ArrayList<>(Arrays.asList(10, -3, 7, 2, 1, 3)));
            System.out.println(equal_subset_sum_partition(input.get(0)));
      }

}
