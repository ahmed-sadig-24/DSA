import java.util.PriorityQueue;

public class ArrayLargestElement {
      public static int findKthLargest(int[] nums, int k) {
            PriorityQueue<Integer> q = new PriorityQueue<>(nums.length);

            for (int num: nums) {
                  q.add(num);
                  //System.out.println("q size: " + q.size());

                  if (q.size() > k) {
                        System.out.println("q size: " + q.size());
                        System.out.println("remove: " + q.remove());
                        q.remove();
                  }
            }
            System.out.println("queue size: " + q.size());
            return q.remove();
      }

      public static void main(String[] args) {
            //int[] nums = {3,2,1,5,6,4};
            //int k = 2;

            int[] nums = {3,2,3,1,2,4,5,5,6};
            int k = 4;

            System.out.println(findKthLargest(nums, k));
      }
}
