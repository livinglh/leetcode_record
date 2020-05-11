//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 示例 1: 
//
// 输入: [2,4,1], k = 2
//输出: 2
//解释: 在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
// 
//
// 示例 2: 
//
// 输入: [3,2,6,5,0,3], k = 2
//输出: 7
//解释: 在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。
// 
// Related Topics 动态规划

  
package leetcode.editor.cn;
//java:买卖股票的最佳时机 IV
public class P188BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
        Solution solution = new P188BestTimeToBuyAndSellStockIv().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int greedy(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }


    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // 当k大于数组长度的一半时，等同于不限次数交易即122题，用贪心算法解决，否则LeetCode会超时
        if(k > prices.length/2){
            return greedy(prices);
        }

        // 动态规划 dp[i][k][s] 表示状态为第i天，交易次数为k，当前是否持有股票（0无，1有）时，最大利润为多少
        // 买入，交易次数+1
        int[][][] dp = new int[prices.length][k+1][2];

        // 处理base case
        for (int ki = 0; ki < k + 1; ki++) {
            dp[0][ki][1] = -prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int ki = 1; ki < k+1; ki++) {
                // 转移方程
                dp[i][ki][0] = Math.max(dp[i-1][ki][0], dp[i-1][ki][1] + prices[i]);
                dp[i][ki][1] = Math.max(dp[i-1][ki][1], dp[i-1][ki-1][0] - prices[i]);
            }
        }
        return dp[prices.length-1][k][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}