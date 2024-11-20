public class HappyNumber {
      private static int getNext(int n) {
            int sum = 0;

            while (n > 0) {
                  int digit = n % 10;
                  sum += Math.pow(digit, 2);
                  n /= 10;
            }

            return sum;
      }

      public static boolean isHappy(int n) {
            int slow = n;
            int fast = getNext(n);

            while (fast != 1 && slow != fast) {
                  slow = getNext(slow);
                  fast = getNext(getNext(fast));
            }

            return fast == 1;
      }

      public static void main(String[] args) {
            int n = 19;
            //int n = 2;

            //n = n % 10;
            //System.out.println(n);
            //System.out.println(n / 10);
            //System.out.println(Math.pow(n ,2));
            System.out.println(isHappy(n));
      }
}
