public class ValidPalindrome {
      public static boolean isPalindrome(String s) {
            if (s.isEmpty()) return false;

            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                  char currLeft = s.charAt(left);
                  char currRight = s.charAt(right);

                  if (!Character.isLetterOrDigit(currLeft)) {
                        left++;
                  } else if (!Character.isLetterOrDigit(currRight)) {
                        right--;
                  } else {
                        if (Character.toLowerCase(currLeft) != Character.toLowerCase(currRight)) return false;
                        left++;
                        right--;
                  }
            }

            return true;
      }

      public static void main(String[] args) {
            String s1 = "A man, a plan, a canal: Panama"; //True
            String s2 = "race a car"; // False
            String s3 = " ";

            System.out.println(isPalindrome(s1));
            System.out.println(isPalindrome(s2));
            System.out.println(isPalindrome(s3));
      }
}
