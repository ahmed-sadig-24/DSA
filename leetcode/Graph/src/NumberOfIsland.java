public class NumberOfIsland {
      public static int numIslands(char[][] grid) {
            int islandCount = 0;

            for (int r = 0; r < grid.length; r++) {
                  for (int c = 0; c < grid[0].length; c++) {
                        if (grid[r][c] == '1') {
                              islandCount++;
                              dfs(grid, r, c);
                        }
                  }
            }

            return islandCount;
      }

      public static void dfs(char[][] grid, int r, int c) {
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

            System.out.println(numIslands(grid));
            //System.out.println(numIslands2(grid));
      }

}
