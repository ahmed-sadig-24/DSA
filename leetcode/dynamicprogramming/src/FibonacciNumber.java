public class FibonacciNumber {
      public static int fib(int n) {
            if (n == 0 || n == 1) return n;

            int[] mem = new int[n + 1];

            mem[0] = 0;
            mem[1] = 1;

            for (int i = 2; i <= n; i++) {
                  mem[i] = mem[i - 1] + mem[i - 2];
            }

            return mem[n];
      }

      public static void main(String[] args) {
            int n1 = 2;
            int n2 = 3;
            int n3 = 6;

            System.out.println(fib(n1));
            System.out.println(fib(n2));
            System.out.println(fib(n3));
      }
}
