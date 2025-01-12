import java.util.Arrays;

public class MinimumCoins {

      static Integer minimum_coins(int[] coins, Integer value) {
            if (value < 1) {
                  return 0;
            }

            int[] minCoins = new int[value + 1];
            Arrays.fill(minCoins, Integer.MAX_VALUE);
            minCoins[0] = 0; // Base case: 0 coins needed for value 0

            for (int i = 1; i <= value; i++) {
                  for (int coin : coins) {
                        if (coin <= i && minCoins[i - coin] != Integer.MAX_VALUE) {
                              minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coin]);
                        }
                  }
            }

            return minCoins[value] == Integer.MAX_VALUE ? -1 : minCoins[value];

      }

      public static void main(String[] args) {
            int[] coins = {1, 2, 5};
            int value = 11;

            System.out.println(minimum_coins(coins, value));
            System.out.println(minimum_coins2(coins, value));
      }


      static Integer minimum_coins2(int[] coins, Integer value) {
            // Write your code here.
            if (value < 1) {
                  return 0;
            }

            int[] minCoins = new int[value + 1];
            Arrays.fill(minCoins, Integer.MAX_VALUE);
            minCoins[0] = 0;

            for (int i = 1; i <= value; i++) {
                  for (int coin: coins) {
                        if (coin <= i) {
                              // minCoins[i - coin] != Integer.MAX_VALUE) {
                              minCoins[i] = Math.min(minCoins[i], 1+  minCoins[i - coin]);
                              //} else {
                              //  break;
                        }
                  }
            }

            //return minCoins[value] == Integer.MAX_VALUE ? -1 : minCoins[value];
            return minCoins[value];
      }


}
