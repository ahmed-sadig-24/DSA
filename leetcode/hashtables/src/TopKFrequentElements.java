import java.util.*;

public class TopKFrequentElements {
      public static int[] topKFrequent(int[] nums, int k) {
            List<Integer>[] bucket = new List[nums.length + 1];
            Map<Integer, Integer> freqMap = new HashMap<>();

            for (int n: nums) {
                  freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
            }

            for (int key: freqMap.keySet()) {
                  int freq = freqMap.get(key);
                  //System.out.println(freq);
                  if (bucket[freq] == null) {
                        bucket[freq] = new ArrayList<>();
                  }
                  bucket[freq].add(key);
            }

            int[] res = new int[k];
            int counter = 0;

            for (int pos = bucket.length -1; pos >= 0 && counter < k; pos--) {
                  if (bucket[pos] != null) {
                        for (Integer i: bucket[pos]) {
                              res[counter++] = i;
                        }
                  }
            }

            return res;
      }

      public static int[] topKFrequentMinHeap(int[] nums, int k) {
            Map<Integer, Integer> freqMap = new HashMap<>();

            for (int num: nums) {
                  freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq =
                    new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

            for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
                  pq.add(entry);

                  if (pq.size() > k) {
                        pq.poll();
                  }
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                  result[i] = pq.poll().getKey();
            }

            return result;
      }

      public static void main(String[] args) {
            //int[] nums = {1,1,1,2,2,3};
            //int k = 2;

            //System.out.println(Arrays.toString(topKFrequent(nums, k)));
            //System.out.println(Arrays.toString(topKFrequentMinHeap(nums, k)));

/*
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            pq.add(5);
            pq.add(2);
            pq.add(8);
            pq.add(1);

            while (!pq.isEmpty()) {
                  System.out.println(pq.poll()); // Output: 1, 2, 5, 8
            }


 */
      }
}
