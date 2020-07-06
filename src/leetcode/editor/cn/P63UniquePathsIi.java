//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 说明：m 和 n 的值均不超过 100。 
//
// 示例 1: 
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
// Related Topics 数组 动态规划 
// 👍 333 👎 0

  
package leetcode.editor.cn;
//java:不同路径 II
public class P63UniquePathsIi{
    public static void main(String[] args) {
        Solution solution = new P63UniquePathsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] ob) {
        int m = ob.length;
        int n = ob[0].length;
        if(m == 0 || n == 0) return 0;
        // `ob[i][j] == 1`表示无障碍物，`dp[i][j] = dp[i - 1][j] + d[i][j - 1]`
        int[][] dp = new int[m][n];
        // 初始化
        // 第0行和第0列分别遍历，赋值为1；
        // 如果碰到障碍物，从这个点之后全为0，因为碰到障碍物，之后都不可达了。
        for(int i = 0; i < m; i++) {
            if(ob[i][0] == 1) break;
            else dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            if(ob[0][i] == 1) break;
            else dp[0][i] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // `ob[i][j] == 1`表示有障碍物，直接令`dp[i][j] = 0`;
                if(ob[i][j] == 1) dp[i][j] = 0;
                    // `ob[i][j] == 1`表示无障碍物，`dp[i][j] = dp[i - 1][j] + d[i][j - 1]`
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}