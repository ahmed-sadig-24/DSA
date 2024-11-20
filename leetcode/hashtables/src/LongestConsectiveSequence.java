import java.util.HashMap;
import java.util.Map;

public class LongestConsectiveSequence {
      public static int longestConsective(int[] nums) {
            int longestLength = 0;
            Map<Integer, Boolean> myHashMap = new HashMap<>();

            for (int num: nums) {
                  myHashMap.put(num, Boolean.FALSE);
            }

            for (int num: nums) {
                  int currLength = 1;
                  int nextNum = num + 1;

                  while (myHashMap.containsKey(nextNum) && myHashMap.get(nextNum) == Boolean.FALSE) {
                        currLength++;
                        myHashMap.put(nextNum,Boolean.TRUE);
                        nextNum++;
                  }

                  int prevNum = num - 1;
                  while (myHashMap.containsKey(prevNum) && myHashMap.get(prevNum) ==  Boolean.FALSE) {
                        currLength++;
                        myHashMap.put(prevNum, Boolean.TRUE);
                        prevNum--;
                  }

                  longestLength = Math.max(longestLength, currLength);
            }

            return longestLength;
      }

      public static void main(String[] args) {
            int[] nums = {0, 1, 6, -1};

            System.out.println(longestConsective(nums));
      }
}
