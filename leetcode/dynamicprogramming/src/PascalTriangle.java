import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
      public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result  = new ArrayList<>();

            if (numRows == 0) {
                  return result;
            }

            for (int i = 0; i < numRows; i++) {
                  List<Integer> row = new ArrayList<>();

                  row.add(1);

                  if (i > 0) {
                        List<Integer> prevRow = result.get(i -1);
                        for (int j = 1; j < i; j++) {
                              row.add(prevRow.get(j - 1) + prevRow.get(j));
                        }
                  }

                  if (i > 0) {
                        row.add(1);
                  }

                  result.add(row);
            }

            return result;
      }

      public static void main(String[] args) {
            int numRows = 5;
            List<List<Integer>> result = generate2(numRows);

            for (List<Integer> row : result) {
                  System.out.println(row);
            }
      }

      public static List<List<Integer>> generate2(int numRows) {
            List<List<Integer>> result = new ArrayList<>();

            if (numRows == 0) {
                  return result;
            }

            for (int i = 0; i < numRows; i++) {
                  List<Integer> row = new ArrayList<>();
                  row.add(1);

                  if (i > 0) {
                        List<Integer> prevRow = result.get(i - 1);
                        for (int j = 1; j < i; j++) {
                              row.add(prevRow.get(j - 1) + prevRow.get(j));
                        }
                  }

                  if (i > 0) {
                        row.add(1);
                  }

                  result.add(row);
            }

            return result;
      }

      public static ArrayList<ArrayList<Integer>> generate3(int numRows) {
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            if (numRows == 0) {
                  return result;
            }

            for (int i = 0; i < numRows; i++) {
                  ArrayList<Integer> row = new ArrayList<>();

                  row.add(1);

                  if (i > 0) {
                        ArrayList<Integer> prevRow = result.get(i - 1);
                        for (int j = 1; j < i; j++) {
                              row.add(prevRow.get(j - 1) + prevRow.get(j));
                        }
                  }

                  if (i > 0) {
                        row.add(1);
                  }

                  result.add(row);
            }

            return result;
      }
      }
