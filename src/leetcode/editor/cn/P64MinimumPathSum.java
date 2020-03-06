//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

  
package leetcode.editor.cn;
//java:最小路径和
public class P64MinimumPathSum{
    public static void main(String[] args) {
        Solution solution = new P64MinimumPathSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
// 暴力解法
//    public int calculate(int[][] grid, int i, int j) {
//        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
//        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
//        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
//    }
//    public int minPathSum(int[][] grid) {
//        return calculate(grid, 0, 0);
//    }

//动态规划
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if(i == 0) dp[i][j] = dp[i][j-1] + grid[i][j];
                else if(j == 0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}