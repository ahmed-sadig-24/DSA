import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
      public static int totalFruit(int[] fruits) {
            int start = 0;
            int end = 0;
            int maxFruits = 0;
            Map<Integer, Integer> freqMap = new HashMap<>();

            while (end < fruits.length) {
                  int endFruit = fruits[end];
                  freqMap.put(endFruit, freqMap.getOrDefault(endFruit,0) + 1);
                  end++;

                  while (freqMap.size() > 2) {
                        int startFruit = fruits[start];
                        freqMap.put(startFruit, freqMap.get(startFruit) - 1);

                        if (freqMap.get(startFruit) == 0) {
                              freqMap.remove(startFruit);
                        }

                        start++;
                  }

                  maxFruits = Math.max(maxFruits, end - start);
            }

            return maxFruits;
      }

      public static void main(String[] args) {
            int[] fruits1 = {1,2,1}; //3
            int[] fruits2 = {0,1,2,2}; // 3
            int[] fruits3 = {1,2,3,2,2}; //4

            System.out.println(totalFruit(fruits1));
            System.out.println(totalFruit(fruits2));
            System.out.println(totalFruit(fruits3));
      }
}
