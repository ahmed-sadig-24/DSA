import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Triangle {
      public static int minimumTotal(List<List<Integer>> triangle) {
            int height = triangle.size();
            //System.out.println(height);
            int[][] dp = new int[height + 1][height + 1];

            for (int level = height -1; level >=0; level--) {
                  for (int i = 0; i <= level; i++) {
                        System.out.println("level: " + level);
                        System.out.println("i: " + i);
                        //System.out.println(dp[level + 1][i]);
                        System.out.println(triangle.get(level).get(i));
                        dp[level][i] = triangle.get(level).get(i)
                                + Math.min(dp[level + 1][i], dp[level + 1][i + 1]);
                  }
            }

            return dp[0][0];
      }

      public static void main(String[] args) {
            //List<List<Integer>> triangle = {{2}, {3,4}, {6,5,7}, {4,1,8,3}};
            List<List<Integer>> triangle = new ArrayList<>();
            triangle.add(new ArrayList<>(Arrays.asList(2)));
            triangle.add(new ArrayList<>(Arrays.asList(1, 3)));
            triangle.add(new ArrayList<>(Arrays.asList(8, 9, 1)));
            triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));

            System.out.println(minimumTotal(triangle));
      }
}
