import java.io.FilterOutputStream;

public class FindSmallestLetter {
      public static char nextGreatestLetter(char[] letters, char target) {
            int start = 0;
            int end = letters.length - 1;

            while (start <= end) {
                  int mid = start + (end - start) / 2;

                  if (target < letters[mid]) {
                        end = mid - 1;
                  } else {
                        start = mid + 1;
                  }
            }

            System.out.println("start: " + start);
            System.out.println("end: " + end);

            return letters[start % letters.length];
            //return start > end ? letters[0] : letters[start];
      }

      public static void main(String[] args) {
            //char[] letters = {'c','f','j'};
            //char target = 'a';

            char[] letters = {'c','f','j'};
            char target = 'c';

            //char[] letters = {'x','x','y','y'};
            //char target = 'z';

            System.out.println(nextGreatestLetter(letters, target));
      }
}
