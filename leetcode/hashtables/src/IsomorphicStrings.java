import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
      public static boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;

            Map<Character, Character> charMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                  char org = s.charAt(i);
                  char rep = t.charAt(i);

                  if (!charMap.containsKey(org)) {
                        if (!charMap.containsValue(rep)) {
                              charMap.put(org,rep);
                        } else {
                              return false;
                        }
                  } else {
                        char mappedChar = charMap.get(org);
                        if (mappedChar != rep) {
                              return false;
                        }
                  }
            }

            return true;
      }

      public static void main(String[] args) {
            //String s = "egg", t = "add";
            //String s = "foo", t = "bar";
            String s = "paper", t = "title";

            System.out.println(isIsomorphic(s, t));
      }
}
