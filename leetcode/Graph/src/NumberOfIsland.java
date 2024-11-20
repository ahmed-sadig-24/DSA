public class NumberOfIsland {
      public static int numIslands(char[][] grid) {
            int islandCount = 0;

            for (int r = 0; r < grid.length; r++) {
                  for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c] == '1') {
                              islandCount++;
                              bfs(grid, r, c);
                        }
                  }
            }

            return islandCount;
      }

      public static void bfs(char[][] grid, int r, int c) {
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == '0') return;

            grid[r][c] = '0';

            bfs(grid, r + 1, c); //up
            bfs(grid, r - 1, c); // down
            bfs(grid, r, c - 1); // left
            bfs(grid, r, c + 1); // right
      }

      public static void main(String[] args) {
            //char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
            char[][] grid = { {'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'} };

            //System.out.println(numIslands(grid));
            System.out.println(numIslands2(grid));
      }

      public static int numIslands2(char[][] grid) {
            int islandsCount = 0;

            for (int r = 0;  r < grid.length - 1; r++) {
                  for (int c = 0; c < grid[0].length - 1; c++) {
                        if (grid[r][c] == '1') {
                              islandsCount++;
                              dfs(grid, r, c);
                        }
                  }
            }

            return islandsCount;
      }

      private static void dfs(char[][] grid, int r, int c) {
            if (r < 0 || r > grid.length || c < 0 || c > grid[r].length || grid[r][c] == '0') {
                  return;
            }

            grid[r][c] = '0';

            dfs(grid, r - 1, c); // up
            dfs(grid, r + 1, c); // down
            dfs(grid, r, c - 1); // left
            dfs(grid, r, c + 1); // right
      }
}
