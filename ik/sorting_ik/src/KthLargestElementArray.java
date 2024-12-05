import java.util.PriorityQueue;

public class KthLargestElementArray {
      public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(k + 1);

            for (int num: nums) {
                  pq.add(num);

                  if (pq.size() > k) {
                        pq.poll();
                  }
            }

            return pq.poll();
      }

      public static void main(String[] args) {
            int[] nums = {3,2,1,5,6,4};
            int k = 2;

            System.out.println(findKthLargest(nums, k));
      }
}
