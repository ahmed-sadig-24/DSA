import java.util.PriorityQueue;

public class KthLargestElementStream {
      private final PriorityQueue<Integer> minHeap;
      private final int k;

      public KthLargestElementStream(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>(k);

            for (int num: nums) {
                  add(num);
            }
      }

      public int add(int val) {
            minHeap.offer(val);

            if (minHeap.size() > k) {
                  minHeap.poll();
            }

            return minHeap.peek();
      }
}
