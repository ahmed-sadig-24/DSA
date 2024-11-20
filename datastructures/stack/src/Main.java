import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
      public static void main(String[] args) {
            //Stack myStack = new Stack(1);

            //myStack.push(2);
            //myStack.push(3);
            //myStack.getHeight();
            //myStack.getTop();
            //myStack.pop();
            //myStack.printStack();
           // String myString = "hello";
            //String reversedString = reverseString(myString);
            //System.out.println(reverseString2("hello"));
            //System.out.println(reversedString);
            //stackExample();
            //System.out.println(isBalancedParentheses());
            //System.out.println(isBalancedParentheses2("[(){[]}])"));
            //System.out.println(isValidParenthesesLeet("("));
            System.out.println(isValidParenthesesLeet2("()"));

            //Stack<Integer> stack = new Stack<>();
            //stack.push(3);
            //stack.push(1);
            //stack.push(4);
            //stack.push(2);
            //System.out.println("Before sorting:");
            //.printStack();

             //sortStack(stack);

            //System.out.println("\nAfter sorting:");
            //stack.printStack();

      }

      public static String reverseString(String string) {
            Stack<Character> stack = new Stack<>();
            String reversedString = "";
            for (char c : string.toCharArray()) {
                  stack.push(c);
            }

            while (!stack.isEmpty()) {
                  reversedString += stack.pop();
            }

            return reversedString;
      }

      public static void stackExample() {
            Stack<Character> myStack2 = new Stack<>();

            //myStack2.push(1);
            //myStack2.push(2);
            //myStack2.push(3);
            //myStack2.push(4);

            String myStr = "hello2";
            String reversedString = "";

            //while (!myStack2.isEmpty()) {
              //    myStr += myStack2.pop();
            //}
            for (char c: myStr.toCharArray()) {
                  myStack2.push(c);
            }

            while (!myStack2.isEmpty()) {
              reversedString += myStack2.pop();
            }
            System.out.println(reversedString);
      }

      public static boolean isBalancedParentheses() {
            String myStr = "["; // "[(){[]}]";
            Stack<Character> myStack = new Stack<>();

            for (char c: myStr.toCharArray()){
                  System.out.println("c: " + c);
                  if (c == '[' || c == '(' || c == '{') {
                        myStack.push(c);
                        continue;
                  }

                  //if (myStack.isEmpty()) return false;
                  if (myStack.isEmpty()) return  false;
                  char poppedElement = myStack.pop();
                  //System.out.println("c: " + c);
                  System.out.println("popped: " + poppedElement);
                  if (c == ']' && poppedElement != '[') return false;
                  if (c == ')' && poppedElement != '(') return false;
                  if (c == '}' && poppedElement != '{') return false;
            }
            return myStack.isEmpty();
      }

      public static boolean isBalancedParentheses2(String s) {
            s = "()";
            String myStr = s;// "[(){[]}])-";

            while (true) {
                  int orginalLength = myStr.length();

                  myStr =  myStr.replace("[]", "");
                  myStr = myStr.replace("{}", "");
                  myStr = myStr.replace("()", "");

                  int newLength = myStr.length();
                  System.out.println("ol: " + orginalLength);
                  System.out.println("nl: " + newLength);

                  if (newLength == orginalLength) {
                        break;
                  }
            }

            return (myStr.length() == 0);
      }

      //public static void sortStack(Stack<Integer> stack) {
        //    Stack<Integer>

      public static void sortStack(Stack<Integer> myStack) {
            Stack<Integer> additionalStack = new Stack<>();

            while (!myStack.isEmpty()) {
                  int temp = myStack.pop();

                  while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                        myStack.push(additionalStack.pop());
                        //System.out.println(temp);
                  }
                  additionalStack.push(temp);
                  //System.out.println("i am here: " + temp);
            }

            for (int i = additionalStack.size()-1; i >= 0; i--) {
                  System.out.println(additionalStack.get(i));
            }
            System.out.println("-------");
            while (!additionalStack.isEmpty()) {
                  myStack.push(additionalStack.pop());
            }

            for (int i = myStack.size()-1; i >= 0; i--) {
                  System.out.println(myStack.get(i));
            }
      }

      public static String reverseString2(String s) {
            Stack<Character> myStack = new Stack<>();
            String result = "";

            for (char ch: s.toCharArray()) {
                  //System.out.println(ch);
                  myStack.push(ch);
            }

            while (!myStack.isEmpty()) {
                  //System.out.println(myStack.pop());
                  //result += myStack.pop();
                  result += myStack.pop();
                  //System.out.println(result);
            }

            return result;
      }

      public static boolean isValidParenthesesLeet(String s) {
            Stack<Character> myStack = new Stack<>();

            for (char ch: s.toCharArray()) {
                  if (ch == '(' || ch == '[' || ch == '{') {
                        myStack.push(ch);
                        continue;
                  }

                  if (myStack.isEmpty()) return false;

                  char popedChar = myStack.pop();
                  System.out.println("popped: " + popedChar);
                  System.out.println("ch: " + ch);

                  if (ch == ')' && popedChar != '(') return false;
                  if (ch == ']' && popedChar != '[') return false;
                  if (ch == '}' && popedChar != '{') return false;
            }

            return myStack.isEmpty();
      }

      public static boolean isValidParenthesesLeet2(String s) {

            s = "()";
            String myStr = s;
            System.out.println("before: " + s.length());

            while (true){
                  int orgLength = myStr.length();

                  myStr =  myStr.replace("()", "");
                  myStr = myStr.replace("[]", "");
                  myStr = myStr.replace("{}", "");

                  System.out.println("str after replace: " + myStr);

                  int newLength = myStr.length();

                  System.out.println(myStr.length());
                  if (orgLength == newLength) {
                        System.out.println("i am here");
                        break;
                  }
            }
            //System.out.println("after: " + myStr.length());
            //System.out.println(myStr);


            return (myStr.length() == 0);
      }
}