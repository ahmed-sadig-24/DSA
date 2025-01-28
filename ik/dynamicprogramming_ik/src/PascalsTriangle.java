import java.util.ArrayList;

public class PascalsTriangle {

      static ArrayList<ArrayList<Integer>> find_pascal_triangle(Integer n) {
            // Write your code here.
            int mod = 1000000007;
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            if (n <= 0) {
                  return result;
            }

            for (int i = 0; i < n; i++) {
                  ArrayList<Integer> row = new ArrayList<>();

                  row.add(1);

                  if (i > 0) {
                        ArrayList<Integer> prevRow = result.get(i - 1);
                        for (int j = 1; j < i; j++) {
                              row.add(prevRow.get(j - 1) + prevRow.get(j) % mod);
                        }
                        row.add(1);
                  }

                  //if (i > 0) {
                        //row.add(1);
                  //}

                  result.add(row);
            }

            return result;
      }

      public static void main(String[] args) {
            int n = 5;

            System.out.println(find_pascal_triangle(n));
      }

}
