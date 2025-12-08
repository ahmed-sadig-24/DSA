package heaps;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
      public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            for (int num: nums) {
                  minHeap.offer(num);

                  if (minHeap.size() > k) {
                        minHeap.poll();
                  }
            }

            return minHeap.peek();
      }

      public static int findKthLargestMaxHeap(int[] nums, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

            for (int num: nums) {
                  maxHeap.offer(num);
            }

            for (int i = 0; i < k - 1; i++) {
                  maxHeap.poll();
            }

            return maxHeap.peek();
      }

      public static void main(String[] args) {
            int[] nums = {3,2,1,5,6,4};
            int k = 2;

            System.out.println(findKthLargest(nums, k));
            System.out.println(findKthLargestMaxHeap(nums,k));
      }
}
