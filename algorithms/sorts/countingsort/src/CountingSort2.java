import java.util.ArrayList;
import java.util.Arrays;

public class CountingSort2 {

      static ArrayList<Integer> counting_sort(ArrayList<Integer> arr2) {
            // Convert ArrayList<Integer> to int[]
            int[] arr = new int[arr2.size()];
            for (int i = 0; i < arr2.size(); i++) {
                  arr[i] = arr2.get(i);
            }

            // Calculate the range of values in the input array
            int min = Arrays.stream(arr).min().getAsInt();
            int max = Arrays.stream(arr).max().getAsInt();
            int range = max - min + 1;

            // Initialize the count and output arrays
            int[] count = new int[range];
            int[] output = new int[arr.length];

            // Count the occurrences of each number
            for (int num : arr) {
                  count[num - min]++;
            }

            // Calculate the cumulative count
            for (int i = 1; i < range; i++) {
                  count[i] += count[i - 1];
            }

            // Build the sorted array
            for (int i = arr.length - 1; i >= 0; i--) {
                  output[count[arr[i] - min] - 1] = arr[i];
                  count[arr[i] - min]--;
            }

            // Convert the sorted array to an ArrayList
            ArrayList<Integer> resultList = new ArrayList<>();
            for (int num : output) {
                  resultList.add(num);
            }

            //int[] result = resultList.stream().mapToInt(Integer::intValue).toArray();

            return resultList;

      }

      public static void main(String[] args) {
            //int[] arr = {4, 2, 2, 8, 3, 3, 1};
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(5);
            arr.add(8);
            arr.add(3);
            arr.add(9);
            arr.add(4);
            arr.add(1);
            arr.add(7);

            // Correctly handle the ArrayList return type
            //ArrayList<Integer> result = counting_sort(arr);
            ArrayList<Integer> result = CountingSort2.counting_sort(arr);

            // Print the result
            System.out.println(result); // Output: [1, 2, 2, 3, 3, 4, 8]
      }

}
