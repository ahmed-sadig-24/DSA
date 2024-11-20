import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueChar {
      public static boolean hasfirstUniqChar(String strs) {
            Set<Character> myHashSet = new HashSet<>();

            for (char ch: strs.toCharArray()) {
                  if (myHashSet.contains(ch)) {
                        return false;
                  }
                  myHashSet.add(ch);
            }
            return  true;
      }

      public static int firstUniqCharIndex(String s) {
            int index = -1;
            Map<Character, Integer> myHashMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                  char c = s.charAt(i);

                  myHashMap.put(c,myHashMap.getOrDefault(c,0) + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                  if (myHashMap.get(s.charAt(i)) == 1) {
                        index = i;
                        break;
                  }
            }

            return index;
      }

      public static void main(String[] args) {
            //String s = "ahmedd";

            //System.out.println(hasfirstUniqChar(s));

            //String s = "leetcode";
            //String s = "loveleetcode";
            String s = "aabb";

            System.out.println(firstUniqCharIndex(s));
      }
}
