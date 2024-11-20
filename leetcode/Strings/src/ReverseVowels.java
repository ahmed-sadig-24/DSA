public class ReverseVowels {
      public static String reverseVowels(String s) {
            char ch[] = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                  if (!isVowel(ch[left])) {
                        left++;
                  } else if (!isVowel(ch[right])) {
                        right--;
                  } else {
                        char temp = ch[left];
                        ch[left++] = ch[right];
                        ch[right--] = temp;
                  }
            }

            return String.valueOf(ch);
      }

      private static boolean isVowel(char ch) {
            if (ch == 'a' ||  ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                  return true;
            } else {
                  return false;
            }
      }

      public static void main(String[] args) {
            //String s = "hello";
            String s = "leetcode";

            System.out.println(reverseVowels(s));
      }
}
