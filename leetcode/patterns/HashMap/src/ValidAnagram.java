import java.util.HashMap;

public class ValidAnagram {
      public static boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false;

            HashMap<Character, Integer> freqMap = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                  freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
                  freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) - 1);
            }

            for (int count: freqMap.values()) {
                  if (count != 0) {
                        return false;
                  }
            }

            return true;
      }

      public static void main(String[] args) {
            String s1 = "anagram", t1 = "nagaram"; //true
            String s2 = "rat", t2 = "car";

            System.out.println(isAnagram(s1, t1));
            System.out.println(isAnagram(s2,t2));
      }
}
