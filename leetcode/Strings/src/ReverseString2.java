public class ReverseString2 {
      public static String reverseStr(String s, int k) {
            char[] ch = s.toCharArray();

            //int left = 0;
            //int right = s.length() -1;

            for (int i = 0; i < s.length(); i += 2 * k) {
                  System.out.println("i: " + i);
                  int left = i;
                  int right = Math.min(i + k -1, ch.length - 1);
                  //int right = i + k - 1;
                  System.out.println("right: " + right);

                  while (left < right) {
                        System.out.println("ch left: " + ch[left]);
                        System.out.println("ch right: " + ch[right]);
                        char temp = ch[left];
                        ch[left++] = ch[right];
                        ch[right--] = temp;
                        //left++;
                        //right--;
                  }
            }

            return new String(ch);
      }

      public static void main(String[] args) {
            //String s = "abcdefg";
            //String s = "abcd";
            //String s = "a";
            String s = "abcdefg";
            int k = 3;

            System.out.println(reverseStr(s, k));
      }
}
