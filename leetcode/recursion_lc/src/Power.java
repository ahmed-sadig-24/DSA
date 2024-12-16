public class Power {
      public static double myPow(double x, int n) {
            //return binaryExp(x, n);
            return binaryExp2(x, n);
      }

      private static double binaryExp(double x, int n) {
            if (n == 0) {
                  return 1;
            }

            if (n < 0) {
                  return 1.0 / binaryExp(x, -n);
            }

            if (n % 2 == 1) {
                  return x * binaryExp(x * x, (n - 1) / 2);
            } else {
                  return binaryExp(x * x, n /2);
            }
      }

      public static void main(String[] args) {
            double x1 = 2.0000;
            int n1 = 10;

            double x2 = 2.10000;
            int n2 = 3;

            double x3 = 2.00000;
            int n3 = -2;

            double x4 = 2;
            int n4 = 32;

            //System.out.println(myPow(x1, n1));
            //System.out.println(myPow(x2, n2));
            //System.out.println(myPow(x3, n3));
            System.out.println(myPow(x4, n4));
      }

      private static double binaryExp2(double x, int n) {
            if (n == 0) {
                  return 1;
            }

            if (n < 0) {
                  return 1.0 / binaryExp2(x, -n);
            }

            if (n % 2 == 1) {
                  return x * binaryExp2(x * x, (n - 1) / 2);
            } else {
                  return binaryExp2(x * x, n / 2);
            }
      }
}
