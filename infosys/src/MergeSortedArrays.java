import java.util.Arrays;

public class MergeSortedArrays {

      public static void main(String[] args) {
            int[] arr1 = {1, 3, 5, 7};
            int[] arr2 = {2, 4, 6, 8, 10};

            int[] merged = mergeArrays(arr1, arr2);

            System.out.println("Merged Sorted Array: " + Arrays.toString(merged));
      }

      public static int[] mergeArrays(int[] arr1, int[] arr2) {
            int i = 0, j = 0, k = 0;
            int[] result = new int[arr1.length + arr2.length];

            // Compare elements and merge
            while (i < arr1.length && j < arr2.length) {
                  if (arr1[i] < arr2[j]) {
                        result[k++] = arr1[i++];
                  } else {
                        result[k++] = arr2[j++];
                  }
            }

            // Copy remaining elements
            while (i < arr1.length) {
                  result[k++] = arr1[i++];
            }
            while (j < arr2.length) {
                  result[k++] = arr2[j++];
            }

            return result;
      }
}
