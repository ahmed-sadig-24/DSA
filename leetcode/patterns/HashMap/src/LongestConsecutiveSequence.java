import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
      public static int longestConsecutive(int[] nums) {
            int longestLen = 0;
            HashMap<Integer, Boolean> seenMap = new HashMap<>();

            for (int num: nums) {
                  seenMap.put(num, Boolean.FALSE);
            }

            for (int num: nums) {
                  int currLen = 1;
                  int nexNum = num + 1;

                  while (seenMap.containsKey(nexNum) && seenMap.get(nexNum) == Boolean.FALSE) {
                        currLen++;
                        seenMap.put(nexNum,Boolean.TRUE);
                        nexNum++;

                  }

                  int prevNum = num - 1;
                  while (seenMap.containsKey(prevNum) && seenMap.get(prevNum) == Boolean.FALSE) {
                        currLen++;
                        seenMap.put(prevNum, Boolean.TRUE);
                        prevNum--;
                  }

                  longestLen = Math.max(longestLen, currLen);
            }

            return longestLen;
      }

      public static void main(String[] args) {
            int[] nums1 = {100,4,200,1,3,2}; // 4
            int[] nums2 = {0,3,7,2,5,8,4,6,0,1}; // 9
            int[] num3 = {1,0,1,2}; //3

            System.out.println(longestConsecutive(nums1));
            System.out.println(longestConsecutive(nums2));
            System.out.println(longestConsecutive(num3));
      }
}
