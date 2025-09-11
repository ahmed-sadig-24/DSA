import java.util.Stack;

public class BasicCalculator2 {
      public static int calculate(String s) {
            Stack<Integer> st = new Stack<>();
            int num = 0;
            char op = '+';
            for (int i = 0; i < s.length(); i++) {
                  char ch = s.charAt(i);

                  if (Character.isDigit(ch)) {
                        num = num * 10 + (ch - '0');
                  }

                  if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                        switch (op) {
                              case '+': st.push(num); break;
                              case '-': st.push(-num); break;
                              case '*': st.push(st.pop() * num); break;
                              case '/': st.push(st.pop() / num); break;
                        }
                        op = ch;
                        num = 0;
                  };
            }

            int result = 0;
            for (int n: st) {
                  result += n;
            }

            return result;
      }

      public static void main(String[] args) {
            String s1 = "3+2*2";
            String s2 = "3/2";
            String s3 = " 3+5 / 2 ";

            System.out.println(calculate(s1));
            System.out.println(calculate(s2));
            System.out.println(calculate(s3));
      }
}
