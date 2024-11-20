import java.util.HashMap;
import java.util.Map;

public class RansomNote {
      public static boolean canConstruct(String ransomNote, String magazine) {
            if (magazine.length() < ransomNote.length()) return false;

            Map<Character, Integer> charCountMap = new HashMap<>();

            for (char c: magazine.toCharArray()) {
                  charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }

            for (char c: ransomNote.toCharArray()) {
                  if (!charCountMap.containsKey(c) ||  charCountMap.get(c) <= 0) {
                        return false;
                  }

                  charCountMap.put(c, charCountMap.get(c) - 1);
            }

            return true;
      }


      public static boolean canConstruct2(String ransomNote, String magazine) {
            if (magazine.length() < ransomNote.length())
                  return false;

            Map<Character, Integer> charCountMap = new HashMap<>();

            for (char c : magazine.toCharArray()) {
                  charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }

            for (char c : ransomNote.toCharArray()) {
                  if (charCountMap.get(c) <= 0) {
                        return false;
                  }

                  charCountMap.put(c, charCountMap.get(c) - 1);
            }
            return true;
      }

      public static void main(String[] args) {
            //String ransomNote = "a", magazine = "b";
            //String ransomNote = "aa", magazine = "ab";
            String ransomNote = "aa", magazine = "aab";

            System.out.println(canConstruct(ransomNote, magazine));
      }
}
