public class LonestString {

      public static String findLongestString(String[] stringList) {
            //int stringLength = 0;
            String result = "";
            for (String str: stringList) {
                  if (str.length() > result.length()) {
                        //stringLength = str.length();
                        result = str;
                  }
            }

            return result;
      }

      public static void main(String[] args) {
            String[] fruits = {"apple", "banana", "kiwi", "pear"};
            System.out.println(findLongestString(fruits));

      }
}
