import java.util.Arrays;

public class PlusOne {
      public static int[] plusOne(int[] digits) {
            int n = digits.length;

            for (int i = n -1; i >= 0; i--) {
                  if (digits[i] < 9) {
                        digits[i]++;
                        return digits;
                  }
                  //9
                  digits[i] = 0;
            }
            int[] new_number = new int[n + 1];
            new_number[0] = 1;
            return new_number;
      }

      public static void main(String[] args) {
            int[] digits = {9, 9, 9};

            System.out.println(Arrays.toString(plusOne(digits)));

            //String[] list = Arrays.asList("hello");
            //List<String> list = new ArrayList<String>(Arrays.asList("hello"));

      }
}
