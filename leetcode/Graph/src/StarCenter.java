import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StarCenter {
      public static int findCenter(int[][] edges) {
            Set<Integer> mySet = new HashSet<>();

            for (int[] edge: edges) {
                  //System.out.println(Arrays.toString(edge));
                  //System.out.println(Arrays.toString(edge[0]));
                  //return edge[0];
                  if (mySet.contains(edge[0])) {
                        return edge[0];
                  }
                  mySet.add(edge[0]);

                  if (mySet.contains(edge[1])) {
                        return edge[1];
                  }
                  mySet.add(edge[1]);
            }

            return -1;
      }

      public static int findCenter2(int[][] edges) {
            return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
            //System.out.println(edges[0][0]);
            //return -1;
      }

      public static int max(int a, int b) {
            return (a > b) ? a : b;
      }

      public static void main(String[] args) {
            int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
            //int[][] edges = {{1,2}, {5,1}, {1,3}, {1,4}};

            findCenter2((edges));
            //System.out.println(findCenter2(edges));
            //System.out.println(Arrays.toString(edges[0]));

            //int x = 10;
            //int y = 20;
            //int max = (x > y) ? x : y;
            //int max = (x < y) ? x : y;
            //System.out.println("The maximum value is: " + max);

            //System.out.println(max(10, 2));

      }
}
