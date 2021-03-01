package 每日一题.图;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 */
public class P_463岛屿的周长 {

    /**
     * dfs
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    //找到一个岛屿
                    return dfs(grid,i,j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(! (0<=i && i < grid.length && 0 <= j && j<grid[0].length)){
            //从岛屿走到边界 +1
            return 1;
        }
        if(grid[i][j] == 0){
            //岛屿到水区，边数+1
            return 1;
        }
        if(grid[i][j] != 1){
            //这个地方以及遍历过了
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid,i-1,j)
                +dfs(grid,i+1,j)
                +dfs(grid,i,j-1)
                +dfs(grid,i,j+1);
    }

    /**
     * 官方DFS做法
     */
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int islandPerimeter2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }

    /**
     * 迭代
     */
    public int islandPerimeter3(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    int cnt = 0;
                    //当前块的四周边数
                    for (int k = 0; k < 4; k++) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        if(tx < 0 || tx >= n || ty >= m || ty < 0 || grid[tx][ty] == 0){
                            cnt += 1;
                        }
                    }
                    res += cnt;
                }
            }
        }
        return res;
    }


}
