import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class EvaluateReversePolishNotation {
      public static int evalRPN(String[] tokens) {
            //Stack<Integer> numStack = new Stack<>();
            Deque<Integer> numStack = new ArrayDeque<>();

            for (String token: tokens) {
                  if (isOperator(token)) {
                        int b = numStack.pop();
                        int a = numStack.pop();
                        numStack.push(applyOperator(a, b, token));
                  } else {
                        numStack.push(Integer.parseInt(token));
                  }
            }

            return numStack.pop();
      }

      private static boolean isOperator(String token) {
            return "+-*/".contains(token);
      }

      private static int applyOperator(int a, int b, String operator) {
            switch (operator) {
                  case "+": return a + b;
                  case "-": return a - b;
                  case "*": return a * b;
                  case "/": return a / b;
                  default: throw new IllegalArgumentException("Invalid operator: " + operator);
            }
      }

      public static void main(String[] args) {
            String[] tokens1 = {"2","1","+","3","*"};
            String[] tokens2 = {"4","13","5","/","+"};
            String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

            System.out.println(evalRPN(tokens1));
            System.out.println(evalRPN(tokens2));
            System.out.println(evalRPN(tokens3));
      }
}
