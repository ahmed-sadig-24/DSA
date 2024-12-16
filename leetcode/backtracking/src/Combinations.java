import java.util.ArrayList;
import java.util.List;

public class Combinations {
      public static List<List<Integer>> combine(int n, int k) {
            if (n < k || k <= 0) return new ArrayList<>();

            List<List<Integer>> result = new ArrayList<>();

            getCombinations(result, new ArrayList<>(), 1, n, k);

            return result;
      }

      private static void getCombinations(List<List<Integer>> result, ArrayList<Integer> curr, int index, int n, int k) {
            //base case
            if (k == 0) {
                  result.add(new ArrayList<>(curr));
                  return;
            }

            for (int i = index; i <= n; i++) {
                  curr.add(i);
                  getCombinations(result, curr, i + 1, n, k - 1);
                  curr.remove(curr.size() - 1);
            }
      }

      public static void main(String[] args) {
            int n1 = 4, k1 = 2;

            System.out.println(combine(n1, k1));
      }
}
