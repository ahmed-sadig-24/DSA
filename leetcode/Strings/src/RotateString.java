public class RotateString {
      public static boolean rotateString(String s, String goal) {
            return (s.length() == goal.length() && (s.concat(s)).contains(goal));
      }

      public static void main(String[] args) {
            String s = "abcde", goal = "cdeab";
            //String s = "abcde", goal = "abced";

            System.out.println(rotateString(s, goal));
      }
}
