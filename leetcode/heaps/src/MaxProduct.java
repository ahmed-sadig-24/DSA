import java.util.PriorityQueue;

public class MaxProduct {
      public static int maxProduct(int[] nums) {
            int first = 0;
            int second = 0;

            for (int num: nums) {
                  if (num > first) {
                        second = first;
                        first = num;
                        System.out.println("first: " + first);
                        System.out.println("second: " + second);
                  } else if (num > second) {
                        second = num;
                        System.out.println("second: " + second);
                  }
                  //;

            }

            return (first - 1) * (second -1);
      }

      public static int maxProductPQ(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length);
            int first = 0;
            int second = 0;

            for (int num: nums) {
                  pq.add(num);


                  if (pq.size() > 2) pq.remove();
                  //System.out.println("size: " + pq.size());
                  //System.out.println("peek: " + pq.peek());
                  //System.out.println("second: " + second);
                  //if (pq.size() == 2) second = pq.remove();
                  //if (pq.size() == 1) first = pq.peek();

            }

            //System.out.println(pq.size());
            //for (int i = pq.size(); i > 2 ; i--) {
            //for (int i = 0; i < pq.size() -1; i++) {
              //    System.out.println(pq.remove());
                  //System.out.println(i);
            //}
            second = pq.remove();
            first = pq.remove();

            //while (!pq.isEmpty()) {
                  //System.out.println(pq.peek());
                //  pq.remove();
              //    System.out.println(pq.remove());
            //}
            //while (pq.size() > 2) {
              //    pq.remove();
            //}
            System.out.println("first: " + first);
            System.out.println("second: " + second);
            return  (first - 1) * (second -1);

      }
      public static void main(String[] args) {
            int[] nums = {3,4,5,2};
            //int[] nums = {1,5,4,5};

            //System.out.println(maxProduct(nums)); //12
            System.out.println(maxProductPQ(nums)); //4
      }
}
