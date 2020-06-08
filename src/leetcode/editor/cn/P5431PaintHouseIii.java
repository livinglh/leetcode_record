//在一个小城市里，有 m 个房子排成一排，你需要给每个房子涂上 n 种颜色之一（颜色编号为 1 到 n ）。有的房子去年夏天已经涂过颜色了，所以这些房子不需要
//被重新涂色。 
//
// 我们将连续相同颜色尽可能多的房子称为一个街区。（比方说 houses = [1,2,2,3,3,2,1,1] ，它包含 5 个街区 [{1}, {2,2}
//, {3,3}, {2}, {1,1}] 。） 
//
// 给你一个数组 houses ，一个 m * n 的矩阵 cost 和一个整数 target ，其中： 
//
// 
// houses[i]：是第 i 个房子的颜色，0 表示这个房子还没有被涂色。 
// cost[i][j]：是将第 i 个房子涂成颜色 j+1 的花费。 
// 
//
// 请你返回房子涂色方案的最小总花费，使得每个房子都被涂色后，恰好组成 target 个街区。如果没有可用的涂色方案，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n
// = 2, target = 3
//输出：9
//解释：房子涂色方案为 [1,2,2,1,1]
//此方案包含 target = 3 个街区，分别是 [{1}, {2,2}, {1,1}]。
//涂色的总花费为 (1 + 1 + 1 + 1 + 5) = 9。
// 
//
// 示例 2： 
//
// 输入：houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n
// = 2, target = 3
//输出：11
//解释：有的房子已经被涂色了，在此基础上涂色方案为 [2,2,1,2,2]
//此方案包含 target = 3 个街区，分别是 [{2,2}, {1}, {2,2}]。
//给第一个和最后一个房子涂色的花费为 (10 + 1) = 11。
// 
//
// 示例 3： 
//
// 输入：houses = [0,0,0,0,0], cost = [[1,10],[10,1],[1,10],[10,1],[1,10]], m = 5, 
//n = 2, target = 5
//输出：5
// 
//
// 示例 4： 
//
// 输入：houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3
//, target = 3
//输出：-1
//解释：房子已经被涂色并组成了 4 个街区，分别是 [{3},{1},{2},{3}] ，无法形成 target = 3 个街区。
// 
//
// 
//
// 提示： 
//
// 
// m == houses.length == cost.length 
// n == cost[i].length 
// 1 <= m <= 100 
// 1 <= n <= 20 
// 1 <= target <= m 
// 0 <= houses[i] <= n 
// 1 <= cost[i][j] <= 10^4 
// 
// Related Topics 动态规划

  
package leetcode.editor.cn;
//java:给房子涂色 III
public class P5431PaintHouseIii{
    public static void main(String[] args) {
        Solution solution = new P5431PaintHouseIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        final int INF = (int)Math.pow(10, 8);
        // dp[i][j][k] 涂完前i个房子，目前有j个街区，且第i个房子的颜色为k时，所有方案中cost最小的
        int dp[][][] = new int[m+1][target+1][n+1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    dp[i][j][k] = INF;
                }
            }
        }
        // 初始化
        // 第0个房子已经涂色
        if(houses[0] > 0){
            dp[0][1][houses[0]] = 0;
        }else{
            // 第0个房子没有涂色，初始化cost
            for(int i = 1; i <= n; i++){
                dp[0][1][i] = cost[0][i - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= target; j++) {
                if(houses[i] > 0){
                    int curcolor = houses[i];
                    for (int k = 1; k <= n; k++) {
                        // 比较当前房子和上一个房子
                        // 如果两个房子颜色相同，那么街区数就相同
                        // 如果两个房子颜色不同，那么第i个房子就独自成一个街区
                        if(curcolor == k){
                            dp[i][j][curcolor] = Math.min(dp[i][j][curcolor], dp[i-1][j][k]);
                        }else{
                            dp[i][j][curcolor] = Math.min(dp[i][j][curcolor], dp[i-1][j-1][k]);
                        }
                    }
                }else{
                    for (int k = 1; k <= n; k++) {
                        for (int l = 1; l <= n; l++) {
                            if(l == k){
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j][l] + cost[i][k-1]);
                            }else{
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j-1][l] + cost[i][k-1]);
                            }
                        }
                    }
                }
            }
        }

        int res = INF;
        for (int k = 1; k <= n; k++) {
            res = Math.min(res, dp[m-1][target][k]);
        }
        if(res == INF){
            return -1;
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}