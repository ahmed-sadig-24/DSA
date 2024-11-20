//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
      public static void main(String[] args) {
            int fact = factorial(4);
            System.out.println(fact);
      }

      public static int factorial(int n) {
            if (n == 1) return 1;

            return n * factorial(n -1);
      }
}