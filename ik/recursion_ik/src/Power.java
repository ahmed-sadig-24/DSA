public class Power {
      static final int MOD = (int)1e9 + 7;
      static long result = 1;

      static Long calculate_power(Long a, Long b) {
            // Write your code here.
            return binaryExp(a, b);
            //return Math.toIntExact(binaryExp(a, b));
            //return (int) binaryExp(a, b);
      }

      static Long binaryExp(Long a, Long b) {
            System.out.println(b);
            //b = Math.toIntExact (b);
            if (b == 0) {
                  return 1L;
            }

            if (b == 1) {
                  return a % 1000000007;
            }

            a = a % 1000000007;


            //if (b < 0) {
                  //return (1 / binaryExp(a, -b)) % 1000000007;
              //    return modInverse(binaryExp(a, -b), 1000000007L);
                  //result = 1 / binaryExp(a, -b);
                  //throw new IllegalArgumentException("Exponent must be non-negative");
            //}

            if (b % 2 == 1) {
                  //return  (a * binaryExp(a * a, (b - 1) / 2)) % 1000000007;
                  result = a * binaryExp(a * a, (b - 1) / 2);
                  //result = result % 1000000007;
            } else {
                  //return (binaryExp(a * a, b / 2)) % 1000000007;
                  result = binaryExp(a * a, b / 2);
                  //result = result % 1000000007;
            }

            //return (int) result;
            return result;
      }

      static Long modInverse(Long a, Long m) {
            return binaryExp(a, m - 2);  // Fermat's Little Theorem
      }

      public static void main(String[] args) {
            Long a = 10000L;
            Long b = 10000000L;

            Long result = Long.valueOf(calculate_power(a, b));
            System.out.println("Result: " + result);
      }

}
