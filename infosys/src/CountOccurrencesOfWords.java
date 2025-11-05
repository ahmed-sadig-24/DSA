import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfWords {

      public static void main(String[] args) {
            String sentence = "Java Spring Spring Boot Boot Boot";

            Map<String, Integer> map = new HashMap<>();
            for (String word: sentence.split(" ")) {
                  map.put(word, map.getOrDefault(word, 0) + 1);
            }

            System.out.println(map);
      }
}
