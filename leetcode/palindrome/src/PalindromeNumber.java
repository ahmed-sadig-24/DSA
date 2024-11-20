public class PalindromeNumber {

      public static boolean isPalindrome(int x) {
            int left = 0;
            int right = String.valueOf(x).length() -1;

            while (left <= right) {
                  char currLeft = String.valueOf(x).charAt(left);
                  char currRight = String.valueOf(x).charAt(right);
                  System.out.println("left: " +  currLeft);
                  System.out.println("right: " + currRight);
                  if (currLeft != currRight) {
                        return false;
                  }
                  left++;
                  right--;
            }

            return true;
      }

      public static void main(String[] args) {
            int num = 121;
            //int num = -121 ;
            System.out.println(isPalindrome(num));
      }
}
