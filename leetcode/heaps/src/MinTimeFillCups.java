import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class MinTimeFillCups {
      public static int fillCups(int[] amount) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int am: amount) {
                  pq.offer(am);
            }

            int ans = 0;

            while (!pq.isEmpty()) {
                  int first = pq.poll();
                  int second = pq.poll();

                  if (first <= 0 && second <= 0) {
                        break;
                  }
                  first--;
                  second--;
                  pq.add(first);
                  pq.add(second);
                  ans++;
            }

            return ans;
      }

      public static int fillCups2(int[] amount) {
            int total = 0;
            int max = 0;

            for (int cup: amount) {
                  total += cup;
                  System.out.println("total: " + total);
                  max = Math.max(max, cup);
                  System.out.println("max: " + max);
            }

            return Math.max(max, (total + 1) / 2);
      }

      public static void main(String[] args) {
            int[] amount = {1, 4, 2};
            //int[] amount = {5, 4, 4};
            //int[] amount = {5, 0, 0};

            System.out.println(fillCups(amount));
            //System.out.println(fillCups2(amount));
            //fillCups(amount);

      }
}
