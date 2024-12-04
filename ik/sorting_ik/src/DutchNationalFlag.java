import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DutchNationalFlag {
      static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
            int start = 0;
            int mid = 0;
            int end = balls.size() -1;

            while (mid <= end) {
                  switch (balls.get(mid)) {
                        case 'R':
                              Collections.swap(balls,start, mid);
                              start++;
                              mid++;
                              break;
                        case 'G':
                              mid++;
                              break;
                        case 'B':
                              Collections.swap(balls, mid, end);
                              end--;
                  }
            }

            // Write your code here.
            return new ArrayList(balls);
      }

      public static void main(String[] args) {
            //"balls": ["G", "B", "G", "G", "R", "B", "R", "G"]
            // output ["R", "R", "G", "G", "G", "G", "B", "B"]
            ArrayList<Character> input = new ArrayList<>();
            Collections.addAll(input, 'G', 'B', 'G', 'G', 'R', 'B', 'R', 'G');

            System.out.println(Arrays.toString(new ArrayList[]{dutch_flag_sort(input)}));
      }

}
