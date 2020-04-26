//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007) 
//
// 示例1: 
//
// 
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
// 
//
// 示例2: 
//
// 
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// 说明： 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= n (总金额) <= 1000000 
// 
// Related Topics 动态规划

  
package leetcode.editor.cn;
//java:硬币
public class P面试题08_11CoinLcci{
    public static void main(String[] args) {
        Solution solution = new P面试题08_11CoinLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int waysToChange(int n) {
        // 法一：动态规划 二维
//        int[] coins = new int[]{1,5,10,25};
//        int[][] dp = new int[4][n+1];
//        for (int i = 0; i < 4; i++) {
//            dp[i][0] = 1;
//        }
//        for (int j = 0; j < n + 1; j++) {
//            dp[0][j] = 1;
//        }
//        for (int i = 1; i < 4; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                if(j >= coins[i])
//                    dp[i][j] = (dp[i-1][j] + dp[i][j-coins[i]])%1000000007;
//                else
//                    dp[i][j] = dp[i-1][j];
//            }
//        }
//        return dp[3][n];

        // 法二 动态规划 一维
        int[] dp=new int[n+1];
        int[] coins={1,5,10,25};

        dp[0] = 1;
        for(int i = 0; i < 4; i++){
            for(int j = coins[i]; j <= n; j++){
                dp[j] = (dp[j] + dp[j-coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}