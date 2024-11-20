import java.util.HashMap;
import java.util.Map;

public class WordPattern {
      public static boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");

            if (pattern.length() != words.length) return false;

            Map<Character, String> charMap = new HashMap<>();

            for (int i = 0; i < pattern.length(); i++) {
                  char c = pattern.charAt(i);
                  if (!charMap.containsKey(c)) {
                        //System.out.println(c);
                        if (!charMap.containsValue(words[i])) {
                              //System.out.println(words[i]);
                              charMap.put(c, words[i]);
                        } else {
                              return false;
                        }
                  } else {
                        String mappedWord = charMap.get(c);
                        //System.out.println("mapped word: " + mappedWord);
                        //System.out.println(words[i]);
                        if (!mappedWord.equals(words[i])) {
                              //System.out.println("here");
                              return false;
                        }
                  }
            }

            return true;
      }

      public static void main(String[] args) {
            String pattern = "abba", s = "dog cat cat dog";
            //String pattern = "abba", s = "dog cat cat fish";
            //String pattern = "aaaa", s = "dog cat cat dog";

            System.out.println(wordPattern(pattern, s));
      }
}
