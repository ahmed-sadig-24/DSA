import java.util.Arrays;

public class SelectionSort {
      public static void selectionSort(int[] array) {
            // move on boundry of unsorted array
            for (int i = 0; i < array.length - 1; i++) {
                  // find the min element of unsorted array
                  int minIndex = i;
                  for (int j = i + 1; j < array.length; j++) {
                        if (array[j] < array[minIndex]) {
                              minIndex = j;
                        }
                  }
                  // swap min element with 1st element
                  if (i != minIndex) {
                        int temp = array[i];
                        array[i] = array[minIndex];
                        array[minIndex] = temp;
                  }
            }
      }

      public static void main(String[] args) {
            int[] array = {4, 2, 6, 5, 1, 3};

            selectionSort(array);

            System.out.println(Arrays.toString(array));
      }
}
