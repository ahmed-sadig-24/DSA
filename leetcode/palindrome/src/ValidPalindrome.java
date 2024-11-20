public class ValidPalindrome {

      public static boolean isPalindrome(String s) {
            if (s.isEmpty()) return true;

            int left = 0;
            int right = s.length() -1;

            while (left <= right) {
                  char currLeft = s.charAt(left);
                  char currRight = s.charAt(right);
                  if (!Character.isLetterOrDigit(currLeft)) {
                        left++;
                  } else if (!Character.isLetterOrDigit(currRight)) {
                        right--;
                  } else {
                        if (Character.toLowerCase(currLeft) != Character.toLowerCase(currRight)) {
                              return false;
                        }
                        left++;
                        right--;
                  }
            }

            return true;
      }

      public static boolean validPalindrome2(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                  if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        right--;
                  } else {
                        return isPalindromeHelper(s, left + 1, right) || isPalindromeHelper(s, left, right -1);
                  }
            }
            return true;
      }

      private static boolean isPalindromeHelper(String s, int left, int right) {
            while (left < right) {
                  if (s.charAt(left) == s.charAt(right)) {
                        left++;
                        right--;
                  } else {
                        return false;
                  }
            }

            return true;
      }

      public static void main(String[] args) {
            //String myString = "aracecar"; //
            //String myString = "A man, a plan, a canal: Panama";
            //String myString = "Civic";
            //System.out.println(isPalindrome(myString));
            //String myString = "abca";
            String myString = "cbbcc";
            System.out.println(validPalindrome2(myString));
      }
}
