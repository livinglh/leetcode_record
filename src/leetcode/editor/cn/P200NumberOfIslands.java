//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设
//网格的四个边均被水包围。 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//
//输出: 3
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集

  
package leetcode.editor.cn;
//java:岛屿数量
public class P200NumberOfIslands{
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solution solution = new P200NumberOfIslands().new Solution();
        int n = solution.numIslands(grid);
        System.out.println(n);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        boolean[][] marked;
        int rows,cols;
        public void Dfs(int x,int y,char[][] grid){
            marked[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int new_x = x + dir[i][0];
                int new_y = y + dir[i][1];
                if( new_x >= 0 && new_x < rows && new_y >= 0 && new_y < cols && !marked[new_x][new_y]
                        && grid[new_x][new_y] == '1'){
                    Dfs(new_x,new_y,grid);
                }
            }
        }
        public int numIslands(char[][] grid) {
            rows = grid.length;
            if(rows == 0) return 0;
            cols = grid[0].length;
            marked = new boolean[rows][cols];
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if(grid[i][j] == '1' && !marked[i][j]) {
                        Dfs(i, j,grid);
                        count++;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}