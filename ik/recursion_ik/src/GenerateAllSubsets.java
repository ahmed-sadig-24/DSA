import java.util.ArrayList;

public class GenerateAllSubsets {
      static ArrayList<String> generate_all_subsets(String s) {
            // Write your code here.
            ArrayList<String> result = new ArrayList<>();

            generateSubsets(result, new StringBuilder(), s.toCharArray(), 0);

            return result;
      }

      static void generateSubsets(ArrayList<String> result, StringBuilder current, char[] chars, int index) {
            result.add(current.toString());

            for (int i = index; i < chars.length; i++) {
                  current.append(chars[i]);

                  generateSubsets(result, current, chars, i + 1);

                  current.deleteCharAt(current.length() - 1);
            }
      }

      public static void main(String[] args) {
            System.out.println(generate_all_subsets("xy"));
      }

}
