public class MinMaxArray {

      public static void main(String[] args) {
            int[] numbers = {5, 2, 9, 1, 7};

            int min = numbers[0];
            int max = numbers[0];

            for (int num: numbers) {
                  if (num > max) {
                        max = num;
                  }
                  if (num < min) {
                        min = num;
                  }
            }

            System.out.println("Maximum number: " + max);
            System.out.println("Minimum number: " + min);
      }
}
