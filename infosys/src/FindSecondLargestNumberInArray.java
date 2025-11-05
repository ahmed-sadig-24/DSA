public class FindSecondLargestNumberInArray {

      public static void main(String[] args) {
            int[] arr = {10, 20, 4, 45, 99};

            Integer first = Integer.MIN_VALUE;
            Integer second = Integer.MIN_VALUE;

            for (int num: arr) {
                  if (num > first) {
                        second = first;
                        first = num;
                  } else if (num > second && num != first) {
                        second = num;
                  }
            }

            System.out.println(second);
      }
}
