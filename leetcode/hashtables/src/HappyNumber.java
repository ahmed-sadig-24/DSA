import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
      public static boolean isHappy(int n) {
            Set<Integer> usedIntegerSet = new HashSet<>();

            while (true) {
                  int sum = 0;
                  while (n != 0) {
                        //System.out.println("n: " + n);
                        //System.out.println(Math.pow(n, 2.0));
                        sum+= Math.pow(n % 10 ,2.0);
                        //System.out.println("sum: " + sum);
                        //System.out.println(n);
                        n = n / 10;
                        //System.out.println(n);
                        //System.out.println("n / 10: " + n);
                  }

                  if (sum == 1) return true;

                  n = sum;

                  if (usedIntegerSet.contains(n)) {
                        return false;
                  }
                  usedIntegerSet.add(n);
            }
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
