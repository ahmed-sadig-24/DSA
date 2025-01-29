import java.util.ArrayList;
import java.util.Arrays;

public class Robbery {

      static Integer maximum_stolen_value(ArrayList<Integer> values) {
            // Write your code here.
            if (values.size() < 2) {
                  return values.get(0);
            }

            int[] dp = new int[values.size()];
            dp[0] = values.get(0);
            dp[1] = Math.max(dp[0], values.get(1));

            for (int i = 2; i < values.size(); i++) {
                  dp[i] = Math.max(values.get(i) + dp[i - 2], dp[i - 1]);
            }

            return dp[values.size() - 1];
      }

      public static void main(String[] args) {
            ArrayList<ArrayList<Integer>> input = new ArrayList<>();
            input.add(new ArrayList<>(Arrays.asList(2, 7, 9, 3, 1)));
            //input.add(new ArrayList<>(Arrays.asList(1, 2, 3, 1)));
            System.out.println(maximum_stolen_value(input.get(0)));
      }

}
