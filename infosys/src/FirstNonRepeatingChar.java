import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
      public static void main(String[] args) {
            String str = "swiss";
            Character result = firstNonRepeatingChar(str);

            if (result != null) {
                  System.out.println("First non-repeating character: " + result);
            } else {
                  System.out.println("No non-repeating character found.");
            }
      }

      public static Character firstNonRepeatingChar(String str) {
            Map<Character, Integer> countMap = new LinkedHashMap<>();

            // Count frequency of each character
            for (char c : str.toCharArray()) {
                  countMap.put(c, countMap.getOrDefault(c, 0) + 1);
            }

            // Find the first character with count = 1
            for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
                  if (entry.getValue() == 1) {
                        return entry.getKey();
                  }
            }
            return null;
      }
}