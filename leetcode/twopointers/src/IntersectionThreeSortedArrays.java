import java.util.ArrayList;
import java.util.List;

public class IntersectionThreeSortedArrays {

      public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            List<Integer> result = new ArrayList<>();
            int p1 = 0, p2 = 0, p3 = 0;

            while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {
                  if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                        if (result.isEmpty() || result.get(result.size() - 1) != arr1[p1]) {
                              result.add(arr1[p1]);
                        }
                        p1++;
                        p2++;
                        p3++;
                  } else if (arr1[p1] < arr2[p2]) {
                        p1++;
                  } else if (arr2[p2] < arr3[p3]) {
                        p2++;
                  } else {
                        p3++;
                  }
            }

            if (result.isEmpty()) return new ArrayList<>();

            return result;
      }

      public static void main(String[] args) {
            int[] arr1 = {1,2,3,4,5}, arr2 = {1,2,5,7,9}, arr3 = {1,3,4,5,8};
            //int[] arr1 = {197,418,523,876,1356}, arr2 = {501,880,1593,1710,1870}, arr3 = {521,682,1337,1395,1764};

            System.out.println(arraysIntersection(arr1, arr2, arr3));
      }
}
