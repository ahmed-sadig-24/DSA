import java.util.*;

public class TopKFrequentElements {
      static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
            HashMap<Integer, Integer> freqMap = new HashMap<>();

            for (int num: arr) {
                  freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

            for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
                  pq.add(entry);
            }

            if (pq.size() > k) {
                  pq.poll();
            }

            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                  result.add(pq.poll().getKey());
            }

            return result;
      }
}
