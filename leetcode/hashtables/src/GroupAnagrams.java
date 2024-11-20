import java.util.*;

public class GroupAnagrams {

      public static List<List<String>> groupAnagrams (String[] strs) {
            if (strs == null || strs.length == 0) {
                  return new ArrayList<>();
            }

            Map<String, List<String>> myHashMap = new HashMap<>();

            for (String str: strs) {
                  char[] ch = str.toCharArray();
                  Arrays.sort(ch);
                  String sortedKey = new String(ch);
                  //System.out.println(sortedKey);

                  if (myHashMap.containsKey(sortedKey)) {
                        myHashMap.get(sortedKey).add(str);
                  } else {
                        List<String> groupAnagramList = new ArrayList<>();
                        groupAnagramList.add(str);
                        myHashMap.put(sortedKey,groupAnagramList);
                  }
            }

            return new ArrayList<>(myHashMap.values());
      }

      public static void main(String[] args) {
            String[] strs = {"eat","tea","tan","ate","nat","bat"};

            System.out.println(groupAnagrams(strs));
      }
}
