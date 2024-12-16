import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermuteArrayUniqueIntegers {
      static ArrayList<ArrayList<Integer>> get_permutations(ArrayList<Integer> arr) {
            // Write your code here.
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();

            generatepermutations(result, new ArrayList<>(), arr);

            return result;
      }

      static void generatepermutations(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> tempList, ArrayList<Integer> arr) {
            //base case
            if (tempList.size() == arr.size()) {
                  result.add(new ArrayList<>(tempList));
                  return;
            }

            for (int num: arr) {
                  if (tempList.contains(num)) continue;

                  tempList.add(num);

                  generatepermutations(result, tempList, arr);

                  tempList.remove(tempList.size() - 1);
            }
      }

      public static void main(String[] args) {
            //ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            //list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
            //System.out.println(get_permutations(list));

            ArrayList<ArrayList<Integer>> input = new ArrayList<>();
            input.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
            System.out.println(get_permutations(input.get(0)));
      }

}
