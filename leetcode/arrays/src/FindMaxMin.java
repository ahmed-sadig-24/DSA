import java.util.Arrays;

public class FindMaxMin {
      public static int[] findMaxMin(int[] myList) {
            int maxNum = myList[0];
            int minNum = myList[0];

            for (int i = 0; i < myList.length; i++) {
                  //System.out.println(myList[i]);
                  if (myList[i] > maxNum) {
                        maxNum = myList[i];
                  }

                  if (myList[i] < minNum) {
                        minNum = myList[i];
                  }
            }

            return new int[]{maxNum, minNum};
      }
      public static void main(String[] args) {
            int[] nums = {5, 3, 8, 1, 6, 9};

            System.out.println(Arrays.toString(findMaxMin(nums)));
      }
}
