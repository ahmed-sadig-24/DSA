import java.util.Arrays;

public class MergeSort {

      public static int[] merge(int[] array1, int[] array2) {
            int[] combinedList = new int[array1.length + array2.length];
            int index = 0;
            int i = 0;
            int j = 0;

            while (i < array1.length && j < array2.length) {
                  if (array1[i] < array2[j]) {
                        combinedList[index] = array1[i];
                        index++;
                        i++;
                  } else {
                        if (array2[j] < array1[i]) {
                              combinedList[index] = array2[j];
                              index++;
                              j++;
                        }
                  }
            }

            while (i < array1.length) {
                  combinedList[index] = array1[i];
                  index++;
                  i++;
            }

            while (j < array2.length) {
                  combinedList[index] = array2[j];
                  index++;
                  j++;
            }

            return combinedList;
      }

      public static int[] mergeSort(int [] array) {
            if (array.length == 1) return array;

            int midIndex = array.length/2;

            int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
            int[] right = mergeSort(Arrays.copyOfRange(array,midIndex,array.length)) ;

            return merge(left, right);
      }

      public static void main(String[] args) {

            //int[] array1 = {1, 3, 7, 8};
            //int[] array2 = {2, 4, 5, 6};

            //System.out.println(Arrays.toString(merge(array1, array2)));

            int[] orginalArray = {3, 1, 4, 2};
            int[] sortedArray = mergeSort(orginalArray);

            System.out.println("\nOrginal Array: " + Arrays.toString(orginalArray));

            System.out.println("\nSorted Array: " + Arrays.toString(sortedArray));
      }
}
