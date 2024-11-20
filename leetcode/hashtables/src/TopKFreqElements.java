import java.util.*;

public class TopKFreqElements {

            public int[] topKFrequent(int[] nums, int k) {
                  // Step 1: Count frequency of each element
                  Map<Integer, Integer> frequencyMap = new HashMap<>();
                  for (int num : nums) {
                        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
                  }

                  // Step 2: Create a min-heap (priority queue) sorted by frequency
                  PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                          new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

                  // Step 3: Keep only the top k elements in the heap
                  for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
                        minHeap.add(entry);
                        if (minHeap.size() > k) {
                              minHeap.poll(); // remove the element with the lowest frequency
                        }
                  }

                  // Step 4: Extract the elements from the heap
                  int[] result = new int[k];
                  for (int i = 0; i < k; i++) {
                        result[i] = minHeap.poll().getKey();
                  }

                  return result;
            }

            public static void main(String[] args) {
                  TopKFrequentElements solution = new TopKFrequentElements();
                  int[] nums = {1, 1, 1, 2, 2, 3};
                  int k = 2;
                  int[] topK = solution.topKFrequent(nums, k);
                  System.out.println("Top " + k + " frequent elements: " + Arrays.toString(topK));
            }
      }