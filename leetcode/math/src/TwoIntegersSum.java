public class TwoIntegersSum {

      public static int getSum(int a, int b) {
            int sum = a ^ b;
            int carry = (a & b) << 1;

            while (carry != 0) {
                  int temp = sum;
                  sum = sum ^ carry;
                  carry = (carry & temp) << 1;
            }

            return sum;
      }
      public static void main(String[] args) {
            //System.out.println(1 ^ 1);
            int a = 2;
            int b = 3;
            System.out.println(getSum(a, b));
      }
}
