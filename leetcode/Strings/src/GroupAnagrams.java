import java.util.*;

public class GroupAnagrams {
      public static List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) return new ArrayList<>();

            Map<String, List<String>> map = new HashMap<>();

            for (String s: strs) {
                  int[] freq = new int[26];

                  for (char c: s.toCharArray()) {
                        freq[c - 'a']++;
                  }

                  String key = Arrays.toString(freq);

                  map.computeIfAbsent(key, k-> new ArrayList<>()).add(s);
            }

            return new ArrayList<>(map.values());
      }

      public static void main(String[] args) {
            String[] strs = {"eat","tea","tan","ate","nat","bat"};

            System.out.println(groupAnagrams(strs));
      }
}
