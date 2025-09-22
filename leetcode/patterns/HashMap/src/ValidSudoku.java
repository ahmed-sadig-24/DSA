import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
      public static boolean isValidSudoku(char[][] board) {
            HashSet seen = new HashSet<>();

            for (int i = 0; i < 9; i++) {
                  for (int j = 0; j < 9; j++) {
                        char currChar = board[i][j];
                        if (currChar != '.' &&
                                (!seen.add(currChar + " found in row: " + i) ||
                                        !seen.add(currChar + " found in col: " + j) ||
                                        !seen.add(currChar + " found in block: " + i /3 + "-" + j /3)
                                )
                        ) return false;
                  }
            }

            return true;
      }
}
