public class FirstOccuranceIndex {
      public static int strStr(String haystack, String needle) {
            return (haystack.indexOf(needle));

            //return -1;
      }

      public static int strStr2(String heystack, String needle) {
            //System.out.println(needle.length());
            //int l = needle.length();
            for (int i = 0; i < heystack.length() - needle.length() + 1; i++) {
                  if (heystack.charAt(i) == needle.charAt(0)) {
                        System.out.println("i: " + i);
                        if (heystack.substring(i, needle.length() + i).equals(needle)) {
                              return i;
                        }
                  }
            }

            return -1;
      }
      public static void main(String[] args) {
            String haystack = "sadbutsad";
            String needle = "but";

            //String haystack = "leetcode";
            //String needle = "leeto";

            //System.out.println(strStr(haystack, needle));
            System.out.println(strStr2(haystack, needle));
      }
}
