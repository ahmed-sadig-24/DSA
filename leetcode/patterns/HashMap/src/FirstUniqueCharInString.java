import java.util.HashMap;

public class FirstUniqueCharInString {
      public static int firstUniqChar(String s) {
            int index = -1;
            HashMap<Character, Integer> freqMap = new HashMap<>();

            for (char c: s.toCharArray()) {
                  freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            for (int i = 0; i < s.length(); i++) {
                  if (freqMap.get(s.charAt(i)) == 1) {
                        index = i;
                        break;
                  }
            }

            return index;
      }

      public static void main(String[] args) {
            String s1 = "leetcode";
            String s2 = "loveleetcode";
            String s3 = "aabb";

            System.out.println(firstUniqChar(s1)); // 0
            System.out.println(firstUniqChar(s2)); // 2
            System.out.println(firstUniqChar(s3)); // -1
      }
}
