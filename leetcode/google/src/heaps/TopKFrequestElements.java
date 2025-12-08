package heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequestElements {
      public static int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num: nums) {
                  freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());
            for (Map.Entry<Integer, Integer> entry: freqMap.entrySet()) {
                  minHeap.offer(entry);

                  if (minHeap.size() > k) {
                        minHeap.poll();
                  }
            }

            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                  result[i] = minHeap.poll().getKey();
            }

            return result;
      }

      public static void main(String[] args) {
            int[] nums1 = {1,2,1,2,1,2,3,1,3,2};
            int k1 = 2;

            int[] nums2 = {1,1,2,2,3,3,4};
            int k2 = 2;

            System.out.println(Arrays.toString(topKFrequent(nums1, k1)));
            System.out.println(Arrays.toString(topKFrequent(nums2, k2)));
      }
}
