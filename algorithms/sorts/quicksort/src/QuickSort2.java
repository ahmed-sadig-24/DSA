import java.util.Arrays;

public class QuickSort2 {
      private static void swap(int[] array, int firstIndex, int secondIndex) {
            int temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;
      }

      private static int pivot(int[] array, int pivotIndex, int endIndex) {
            int swapIndex = pivotIndex;

            for (int i = pivotIndex + 1; i <= endIndex; i++) {
                  if (array[i] < array[pivotIndex]) {
                        swapIndex++;
                        swap(array, i, swapIndex);
                  }
            }

            swap(array, swapIndex, pivotIndex);

            return swapIndex;

      }

      private static void quickSortHelper(int[] array, int left, int right) {
            int pivotIndex = pivot(array, left, right);

            if (left < right) {
                  quickSortHelper(array, left, pivotIndex - 1);
                  quickSortHelper(array, pivotIndex + 1, right);
            }
      }

      public static void quickSort(int[] array) {
            quickSortHelper(array, 0, array.length - 1);
      }

      public static void main(String[] args) {
            //int[] array = {4, 6, 1, 7, 3, 2, 5};
            int[] array = {5, 8, 3, 9, 4, 1, 7};

            //int returnedIndex = pivot(array, 0, 6);

            //System.out.println("Returned Index: " + returnedIndex);

            System.out.println(Arrays.toString(array));

            quickSort(array);

            System.out.println(Arrays.toString(array));
      }
}
