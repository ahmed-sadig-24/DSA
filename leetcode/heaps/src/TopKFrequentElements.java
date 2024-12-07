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

                  if (pq.size() > k) {
                        pq.poll();
                  }

            }

            int[] result = new int[k];
            for (int i = k - 1; i >= 0; i--) {
                  //System.out.println(pq.poll().getKey());
                  result[i] = pq.poll().getKey();
            }

            return result;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,1,1,2,2,3};
            int k1 = 2;

            int[] nums2 = {1, 2, 1, 2, 3, 1, 3, 3, 1};
            int k2 = 3;

            System.out.println(Arrays.toString(topKFrequent(nums1, k1)));
            System.out.println(Arrays.toString(topKFrequent(nums2, k2)));
      }
}
