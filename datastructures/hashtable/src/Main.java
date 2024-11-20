import java.lang.reflect.Array;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
      public static void main(String[] args) {
            //HashTable myHashTable = new HashTable();

            //myHashTable.set("ahmed", 100);
            //myHashTable.set("mohamed", 200);
            //myHashTable.set("hassan", 300);
            //myHashTable.set("sadig", 400);

            //System.out.println(myHashTable.get("hassan"));

            //myHashTable.printTAble();

            //System.out.println(myHashTable.keys());

            int[] array1 = {1, 3, 5};
            int[] array2 = {2, 4, 6};

            System.out.println(itemInCommonSet(array1, array2));



            //int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
            //List<Integer> duplicates = findDuplicates(nums);
            //System.out.println(duplicates);
            //findDuplicates(nums);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */
            //int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
            //int[] nums = {1, 2, 3, 4, 1};
            //System.out.println(containsDuplicate(nums));
            //int[] nums = {2, 6, 4, 1, 3, 1, 5};
            //System.out.println(findDuplicates3(nums));

            //System.out.println(firstNonRepeatingChar("leetcode"));
            //System.out.println(firstNonRepeatingChar("hello"));
            //System.out.println(firstNonRepeatingChar("aabbcc"));

            /*System.out.println("1st set:");
            System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

            System.out.println("\n2nd set:");
            System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

            System.out.println("\n3rd set:");
            System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

             */
            //int[] nums = {16, 4, 23, 8, 15, 42, 1, 2};
            //System.out.println(twoSum(nums,19));
            //System.out.println(Arrays.toString(twosum2(nums,19)));
            //System.out.println(Arrays.toString(twosum2(new int[]{2, 7, 11, 15}, 9)));
            //System.out.println(Arrays.toString(twosum2(new int[]{}, 0)));
            //twoSum(nums,19);
            //int[] nums = {23, 2, 4, 6, 7};
            //int[] nums = {1, 2, 3, 4, 5};
            //int[] nums = {2, 3, 4, 5, 6};
            //System.out.println(Arrays.toString(subarraySum(nums,6)));

            //int[] nums1 = {1, 2, 3, 4, 5};
            //int target1 = 9;
            //int[] result1 = subarraySum(nums1, target1);
            //System.out.println("[" + result1[0] + ", " + result1[1] + "]");
            //System.out.println(Arrays.toString(subarraySum(nums1,target1)));

            //int[] nums2 = {-1, 2, 3, -4, 5};
            //int target2 = 5;
            //int[] result2 = subarraySum(nums2, target2);
            //System.out.println("[" + result2[0] + ", " + result2[1] + "]");
            //System.out.println(Arrays.toString(subarraySum(nums2,target2)));

            //int[] nums3 = {2, 3, 4, 5, 6};
            //int target3 = 9;
            //int[] result3 = subarraySum(nums3, target3);
            //System.out.println("[" + result3[0] + ", " + result3[1] + "]");
            //System.out.println(Arrays.toString(subarraySum(nums3,target3)));

            //int[] nums4 = {};
            //int target4 = 0;
            //int[] result4 = subarraySum(nums4, target4);
            //System.out.println("[]");
            //List<Integer> myList = List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5);
            //List<Integer> newList = removeDuplicates(myList);
            //System.out.println(newList);
/*
            System.out.println(hasUniqueChars("abcdefg")); // should return true
            System.out.println(hasUniqueChars("hello")); // should return false
            System.out.println(hasUniqueChars("")); // should return true
            System.out.println(hasUniqueChars("0123456789")); // should return true
            System.out.println(hasUniqueChars("abacadaeaf")); // should return false

 */

/*
            int[] arr1 = {1, 2, 3, 4, 5};
            int[] arr2 = {2, 4, 6, 8, 10};
            int target = 7;

            List<int[]> pairs = findPairs(arr1, arr2, target);
            for (int[] pair : pairs) {
                  System.out.println(Arrays.toString(pair));
            }
 */
            //int[] nums = {100, 4, 200, 1, 3, 2, 0};
            //int[] nums = {0, 1, 9, 6, 5, -1};
            //System.out.println(longestConsecutiveSequence(nums));
            //System.out.println(groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
      }


      public static int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;

            do {
                  //System.out.println("slow: " + slow + " fast: " + fast);
                  slow = nums[slow];
                  fast = nums[nums[fast]];
                  //System.out.println("slow: " + slow + " fast: " + fast);
                  //System.out.println(nums[0]);
                  //System.out.println("fast: " + fast);
            } while (slow != fast);
            //System.out.println("slow: " + slow + " fast: " + fast);

            slow = 0;
            while (slow != fast) {
                  slow = nums[slow];
                  fast = nums[fast];
            }

            return slow;
      }

      public static List<Integer> findDuplicates2(int[] nums) {
            Map<Integer, Integer> numCounts = new HashMap<>();
            for (int num : nums) {
                  numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
            }
            List<Integer> duplicates = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : numCounts.entrySet()) {
                  if (entry.getValue() > 1) {
                        duplicates.add(entry.getKey());
                  }
            }
            return duplicates;
      }

      public static Character firstNonRepeatingChar(String str) {
            Map<Character, Integer> charCounts = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                  char c = str.charAt(i);
                  charCounts.put(c,charCounts.getOrDefault(c,0) + 1);
            }

            for (int i = 0; i < str.length(); i++) {
                  char c = str.charAt(i);
                  //System.out.println(charCounts.get(c));
                  if (charCounts.get(c) == 1) {
                        return c;
                  }
            }
            return null;
      }

      public static List<Integer> findDuplicates3(int[] nums) {
            Map<Integer,Integer> numCounts = new HashMap<>();

            for (int num: nums) {
                  numCounts.put(num, numCounts.getOrDefault(num,0) + 1);
            }

            List<Integer> duplicate = new ArrayList<>();
            for (Map.Entry<Integer,Integer> entry: numCounts.entrySet()) {
                  if (entry.getValue() >  1) {
                        duplicate.add(entry.getKey());
                  }
            }
            return duplicate;
      }

      public static boolean itemInCommon(int[] array1, int[] array2) {
            for (int i: array1) {
                  for (int j: array2) {
                        if (i == j) return true;
                  }
            }
            return false;
      }

      public static boolean itemInCommon2(int[] array1, int[] array2) {
            HashMap<Integer,Boolean> myHashMap = new HashMap<>();

            for (int i: array1){
                  myHashMap.put(i, true);
            }

            for (int j: array2) {
                  if (myHashMap.get(j) != null) return true;
            }

            return false;
      }

      public static boolean itemInCommonSet(int[] array1, int[] array2) {
            Set<Integer> myHashSet = new HashSet<>();

            for (int i: array1) {
                  myHashSet.add(i);
            }

            for (int j: array2) {
                  if (myHashSet.contains(j)) return true;
            }

            return false;
      }

      public static boolean containsDuplicate(int[] myList) {
            HashSet<Integer> myHashSet = new HashSet<>();

            for (int n: myList) {
                  if (myHashSet.contains(n)) return true;

                  myHashSet.add(n);
            }

            return false;
      }

      public static List<List<String>> groupAnagrams(String[] inputStr) {
            Map<String,List<String>> groupAnagrams = new HashMap();

            for (String str: inputStr) {
                  char[] chars = str.toCharArray();
                  Arrays.sort(chars);
                  String canonical = new String(chars);
                  if (groupAnagrams.containsKey(canonical)) {
                        groupAnagrams.get(canonical).add(str);
                  } else {
                        List<String> group = new ArrayList<>();
                        group.add(str);
                        groupAnagrams.put(canonical,group);
                  }
            }
            return new ArrayList<>(groupAnagrams.values());
      }

      public static int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> myMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                  int complement = target - nums[i];

                  if (myMap.containsKey(complement)) {
                        return new int[]{myMap.get(complement), i};
                        //return Arrays.asList(myMap.get(complement),i);
                        //return new ArrayList<>(myMap.get(complement));
                        //int[] numbers = {myMap.get(complement), i};
                        //return Arrays.stream(numbers.length.);
                        //return List.of(1,40);
                        //return new ArrayList({1,2}) ;
                        //return new int[]{0,0};
                        //System.out.println(i);
                        //int[] n = {1,2};
                        //System.out.println(n.toString());
                        //return n;
                  }

                  myMap.put(nums[i], i);
                  //System.out.println("i: " + i + " nums[i]: " + nums[i]);
            }

            throw new IllegalArgumentException("Not found");
      }

      public static int[] twosum2(int[] nums, int target) {
            Map<Integer,Integer> myMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                  int complement = target - nums[i];
                  //return new int[]{myMap.get(complement), i};
                  if (myMap.containsKey(complement)) {
                        return new int[]{myMap.get(complement),i};
                  }

                  myMap.put(nums[i],i);
            }


            throw new IllegalArgumentException("Not found");
      }

      public static int[] subarraySum2(int[] nums, int target) {
            Map<Integer,Integer> myMap = new HashMap<>();
            myMap.put(0, -1);
            int num = 0;

            for (int i = 0; i < nums.length; i++) {
                  num += nums[i];
                  //num = num + nums[i];
                  //System.out.println(num);
                  int remainder = num % target;
                  //System.out.println(myMap.containsKey(remainder));

                  if (myMap.containsKey(remainder)) {
                        return new int[]{i -1, i};
                  }

                  myMap.put(remainder,i);
                  //System.out.println("remainder: " + remainder + " i: " + i);
            }
            return new int[] {};
      }

      public static int[] subarraySum(int[] nums, int target) {
            Map<Integer, Integer> sumIndexMap = new HashMap<>();

            sumIndexMap.put(0, -1);
            int currentSum = 0;

            for (int i = 0; i < nums.length; i++) {
                  currentSum += nums[i];
                  //System.out.println("i: " + i + " currentSum - Target: " + (currentSum - target));
                  if (sumIndexMap.containsKey(currentSum - target)) {
                        System.out.println("i: " + i + " currentSum - Target: " + (currentSum - target));
                        return new int[] {sumIndexMap.get(currentSum - target) + 1, i};
                  }

                  //System.out.println("currentSum: " + currentSum + " i: " + i);
                  sumIndexMap.put(currentSum, i);
            }

            return  new int[] {};
      }

      public static List<Integer> removeDuplicates(List<Integer> myList) {
            Set<Integer> uniqueSet = new HashSet<>(myList);
            return new ArrayList<>(uniqueSet);
      }

      public static boolean hasUniqueChars(String str) {
            Map<Character, Integer> myHashMap = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                  //System.out.println(str.charAt(i));
                  char c = str.charAt(i);

                  if (myHashMap.containsKey(c)) {
                        //System.out.println("c: " + c);
                        return false;
                  }

                  myHashMap.put(c,1);
            }

            return true;
      }

      public static List<int[]> findPairs(int[] list1, int[] list2, int target) {
            Map<Integer, Integer> myHashMap = new HashMap<>();
            List<int[]> pairs = new ArrayList<>();

            for (int i: list1) {
                  //System.out.println("i: " + i + " target - i: " +  (target -i));
                  myHashMap.put(target - i, i);
            }

            for (int j: list2) {
                  //if (j == 6) System.out.println(j);
                  //System.out.println(myHashMap.get(target -j ));
                  if (myHashMap.containsKey(j)) {
                        //System.out.println(myHashMap.get(target -j ));
                        //System.out.println(myHashMap.get(j) + "," + j);
                        //return new int[]{myHashMap.get(j), j};
                        pairs.add(new int[] {myHashMap.get(j),j});
                  }
            }
            return pairs;
      }

      public static int longestConsecutiveSequence(int[] nums) {
            Map<Integer, Boolean> myHashMap = new HashMap<>();
            int longestLength = 0;

            for (int num: nums) {
                  myHashMap.put(num, false);
            }

            for (int num: nums) {
                  int currentLength = 1;
                  int nextNum = num + 1;

                  while (myHashMap.containsKey(nextNum) && myHashMap.get(nextNum) == false) {
                        myHashMap.put(nextNum, true);
                        currentLength++;
                        nextNum++;
                  }

                  int prevNum = num - 1;
                  while (myHashMap.containsKey(prevNum) && myHashMap.get(prevNum) == false) {
                        myHashMap.put(prevNum, true);
                        currentLength++;
                        prevNum--;
                  }
                  longestLength = Math.max(currentLength, longestLength);

            }

            return longestLength;
      }

      public static List<List<String>> groupAnagrams2(String[] inputString) {
            Map<String,List<String>> myHashMap = new HashMap<>();

            for (String str: inputString) {
                  char[] chars = str.toCharArray();
                  //System.out.println(chars);
                  Arrays.sort(chars);
                  String sortedString = new String(chars);

                  if (myHashMap.containsKey(sortedString)) {
                        myHashMap.get(sortedString).add(str);
                  } else {
                        List<String> group = new ArrayList<>();
                        group.add(str);
                        myHashMap.put(sortedString,group);
                        Set<Integer> s = new HashSet<>();
                  }
            }
            return new ArrayList<>(myHashMap.values());
      }



}