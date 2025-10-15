public class NumberOfIsland {

      public static int numIslands(char[][] grid) {
            int count = 0;

            for (int r = 0; r < grid.length; r++) {
                  for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c] == '1') {
                              count++;
                              dfs(grid, r, c);
                        }
                  }
            }

            return count;
      }

      private static void dfs(char[][] grid, int r, int c) {
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;

            grid[r][c] = '0';


            dfs(grid,r + 1, c); // up
            dfs(grid,r - 1, c); // down
            dfs(grid,r , c - 1); // left
            dfs(grid,r , c + 1); // right
      }
      
      public static void main(String[] args) {
            char[][] grid = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            };

            System.out.println(numIslands(grid)); //3
      }
}
