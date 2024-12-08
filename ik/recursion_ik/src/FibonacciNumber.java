public class FibonacciNumber {
      static Integer find_fibonacci(Integer n) {
            if (n == 0 || n == 1) return n;

            int[] mem = new int[n + 1];
            mem[0] = 0;
            mem[1] = 1;

            for (int i = 2; i <= n; i++) {
                  mem[i] = mem[i - 1] + mem[i - 2];
            }

            return (int) mem[n];
      }

      public static void main(String[] args) {
            int n = 6;

            System.out.println(find_fibonacci(n));
      }
}
