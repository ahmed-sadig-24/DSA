public class ValidPerfectSquare {
      public static boolean isPerfectSquare(int num) {
            if (num < 0) {
                  return false;
            }
            if (num == 0 || num == 1) {
                  return true;
            }

            int left = 1, right = num;
            while (left <= right) {
                  int mid = left + (right - left) / 2;
                  int square = mid * mid;

                  if (square == num) {
                        return true;
                  } else if (square < num) {
                        left = mid + 1;
                  } else {
                        right = mid - 1;
                  }
            }

            return false;
      }

      public static void main(String[] args) {
            int num1 = 16;
            int num2 = 14;
            int num3 = 36;

            System.out.println(isPerfectSquare(num1));
            System.out.println(isPerfectSquare(num2));
            System.out.println(isPerfectSquare(num3));
      }
}
