import java.util.ArrayList;
import java.util.Arrays;

public class MinCostClimbingStairs {

      static Integer min_cost_climbing_stairs(ArrayList<Integer> cost) {
            // Write your code here.
            int n = cost.size();
            int[] minCost = new int[n + 1];

            for (int i = 2; i <= n; i++) {
                  minCost[i] = Math.min(cost.get(i - 1) + minCost[i - 1], cost.get(i - 2) + minCost[i - 2]);
            }

            return minCost[n];
      }

      public static void main(String[] args) {
            //"cost": [1, 1, 2]
            ArrayList<ArrayList<Integer>> cost = new ArrayList<>();
            cost.add(new ArrayList<>(Arrays.asList(1, 1, 2)));
            System.out.println(min_cost_climbing_stairs(cost.get(0)));
      }

}
