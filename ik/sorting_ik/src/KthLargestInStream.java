import java.util.*;

public class KthLargestInStream {
      static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {
            // Write your code here.
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

            for (int num: initial_stream) {
                  minHeap.offer(num);

                  if (minHeap.size() >k ) {
                        minHeap.poll();
                  }
            }

            ArrayList<Integer> result = new ArrayList<>();

            for (int num: append_stream) {
                  minHeap.offer(num);

                  if (minHeap.size() > k) {
                        minHeap.poll();
                  }

                  result.add(minHeap.peek());
            }

            return result;
      }

      public static void main(String[] args) {
            // Example input
            ArrayList<Integer> numbers = new ArrayList<>();
            Collections.addAll(numbers, 3,1,4);


            int k = 2;
            ArrayList<Integer> initialStream = new ArrayList<>();
            Collections.addAll(initialStream, 4, 6);
            ArrayList<Integer> appendStream = new ArrayList<>();
            Collections.addAll(appendStream, 5, 2, 20);

            // Get the result
            List<Integer> result = kth_largest (k, initialStream, appendStream);

            // Print the output
            System.out.println(result); // Output: [5, 5, 6]
      }
}
