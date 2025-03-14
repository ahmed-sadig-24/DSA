import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
      public static void main(String[] args) {
/*
            Heap myHeap = new Heap();
            myHeap.insert(95);
            myHeap.insert(75);
            myHeap.insert(80);
            myHeap.insert(55);
            myHeap.insert(60);
            myHeap.insert(50);
            myHeap.insert(65);

            System.out.println(myHeap.getHeap());

            myHeap.remove();

            System.out.println(myHeap.getHeap());

            myHeap.remove();

            System.out.println(myHeap.getHeap());

 */

            // Test case 1
            int[] nums1 = {7, 10, 4, 3, 20, 15};
            int k1 = 3;
            System.out.println("Test case 1:");
            System.out.println("Expected output: 7");
            System.out.println("Actual output: " + findKthSmallest3(nums1, k1));
            System.out.println();
/*
            // Test case 2
            int[] nums2 = {2, 1, 3, 5, 6, 4};
            int k2 = 2;
            System.out.println("Test case 2:");
            System.out.println("Expected output: 2");
            System.out.println("Actual output: " + findKthSmallest(nums2, k2));
            System.out.println();

            // Test case 3
            int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
            int k3 = 5;
            System.out.println("Test case 3:");
            System.out.println("Expected output: 7");
            System.out.println("Actual output: " + findKthSmallest(nums3, k3));
            System.out.println();
 /*

            /*
            // Test case 1
            int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
            System.out.println("Test case 1:");
            System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
            System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
            System.out.println("Actual output: " + streamMax(nums1));
            System.out.println();

            // Test case 2
            int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
            System.out.println("Test case 2:");
            System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
            System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
            System.out.println("Actual output: " + streamMax(nums2));
            System.out.println();

            // Test case 3
            int[] nums3 = {3, 3, 3, 3, 3};
            System.out.println("Test case 3:");
            System.out.println("Input: [3, 3, 3, 3, 3]");
            System.out.println("Expected output: [3, 3, 3, 3, 3]");
            System.out.println("Actual output: " + streamMax(nums3));
            System.out.println();


             */

      }

      public static int findKthSmallest(int[] nums, int k) {
            Heap maxHeap = new Heap();

            for(int num: nums) {
                  maxHeap.insert(num);
                  System.out.println("get: " + maxHeap.getHeap());
                  if (maxHeap.getHeap().size() > k) {
                        //System.out.println("size: " + maxHeap.getHeap().size());
                        //System.out.println(maxHeap.getHeap());
                        maxHeap.remove();
                  }
            }
            return maxHeap.remove();
            //return maxHeap.getHeap().get(0);
      }

      public static int findKthSmallest2(int[] nums, int k) {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < k; i++) {
                  maxHeap.add(nums[i]);
            }

            for (int i = k; i < nums.length; i++) {
                  if (nums[i] < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.add(nums[i]);
                  }
            }

            return maxHeap.peek();
      }

      public static int findKthSmallest3(int[] nums, int k) {
            PriorityQueue<Integer> miniHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int num: nums) {
                  miniHeap.add(num);
            }

            System.out.println(Arrays.toString(miniHeap.toArray()));
            for (int i = 0; i < k - 1; i++) {
                  //System.out.println(Arrays.toString(miniHeap.toArray()));
                  miniHeap.poll();
            }

            return miniHeap.peek();
      }

      public static List<Integer> streamMax(int[] nums) {
            Heap maxHeap = new Heap();
            List<Integer> maxStream = new ArrayList<>();

            for (int num: nums) {
                  maxHeap.insert(num);
                  maxStream.add(maxHeap.getHeap().get(0));
            }

            return maxStream;
      }
}