package heaps;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
      private  PriorityQueue<Integer> minHeap;
      private int k;

      public void KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();

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
