public class RomanToInteger {
      public static int romanToInt(String s) {
           int sum = 0;
           int cur = translate(s.charAt(0));

           for (int i = 1; i < s.length(); i++) {
                 //System.out.println("current: " + cur);
                 int next = translate(s.charAt(i));
                 //System.out.println("i: " + i);
                 if (cur < next) {
                       sum -= cur;
                       //System.out.println("-");
                 } else {
                       sum += cur;
                       //System.out.println("+");
                 }
                 //System.out.println("sum: " + sum);

                 cur = next;
           }
            sum += cur;

           return sum;
      }

      public static int romanToInt2(String s) {
            int sum = 0;
            int cur = translate(s.charAt(0));

            for(int i = 1; i < s.length(); i++) {
                  int next = translate(s.charAt(i));

                  if(cur < sum) {
                        sum -= cur;
                  } else {
                        sum += cur;
                  }

                  cur = next;
            }
            sum += cur;

            return sum;
      }

      private static int translate(char symbol) {
            switch (symbol) {
                  case 'I':
                        return 1;
                  case 'V':
                        return 5;
                  case 'X':
                        return 10;
                  case 'L':
                        return 50;
                  case 'C':
                        return 100;
                  case 'D':
                        return 500;
                  case 'M':
                        return 1000;
                  default:
                        return 0;
            }
      }

      public static void main(String[] args) {
            System.out.println(romanToInt("III"));
            System.out.println(romanToInt("LVIII"));
            System.out.println(romanToInt("MCMXCIV"));
            //System.out.println(romanToInt("IX"));
            //System.out.println(romanToInt("XII"));
      }
}
