import java.util.*;

public class TopKFrequentElements {
      public static int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> freqMap = new HashMap<>();

            for (int num: nums) {
                  freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

            for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
                  pq.add(entry);
            }

            if (pq.size() > k) {
                  pq.poll();
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                  result[i] = pq.poll().getKey();
            }

            return result;
      }

      public static void main(String[] args) {
            int[] nums = {1,1,1,2,2,3};
            int k = 2;

            System.out.println(Arrays.toString(topKFrequent(nums, k)));
      }
}
