import java.util.Arrays;

public class ReverseString {
      public static void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;

            while (left < right) {
                  char temp = s[left];
                  s[left] = s[right];
                  s[right] = temp;

                  left++;
                  right--;
            }

            System.out.println(s);
      }
      public static void main(String[] args) {
            char[] s1 = {'h', 'e', 'l', 'l', 'o'};
            char[] s2 = {'H','a','n','n','a','h'};

            reverseString(s1);
            reverseString(s2);

      }
}
