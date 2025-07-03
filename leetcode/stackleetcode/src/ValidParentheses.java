import java.util.Stack;

public class ValidParentheses {
      public static boolean isValid(String s) {
            String myStr = s;

            while (true) {
                  int originalLength = myStr.length();

                  myStr = myStr.replace("()", "");
                  myStr = myStr.replace("[]", "");
                  myStr = myStr.replace("{}", "");

                  int newLength = myStr.length();
                  if (originalLength == newLength) {
                        break;
                  }
            }

            return (myStr.length() == 0);
      }

      public static void main(String[] args) {
            String s1 = "()";
            String s2 = "()[]{}";
            String s3 = "(]";
            String s4 = "([])";

            System.out.println(isValid(s1));
            System.out.println(isValid(s2));
            System.out.println(isValid(s3));
            System.out.println(isValid(s4));

            System.out.println("----------");

            System.out.println(isValidStack(s1));
            System.out.println(isValidStack(s2));
            System.out.println(isValidStack(s3));
            System.out.println(isValidStack(s4));
      }

      public static boolean isValidStack(String s) {
            Stack<Character> myStack = new Stack<>();

            for (char ch: s.toCharArray()) {
                  if (ch == '(' || ch == '[' || ch == '{') {
                        myStack.push(ch);
                  } else {
                        char topChar = myStack.pop();
                        if (ch == ')' && topChar != '(' ||
                                ch == ']' && topChar != '[' ||
                                ch == '}' && topChar != '{') {
                              return false;
                        }

                  }
            }

            return myStack.isEmpty();
      }
}
