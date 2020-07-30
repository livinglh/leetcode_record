//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

  
package leetcode.editor.cn;
//java:零钱兑换
public class P322CoinChange{
    public static void main(String[] args) {
        int[] cons = {1,2,5};
        int amount = 11;
        Solution solution = new P322CoinChange().new Solution();
        int ans = solution.coinChange(cons,amount);
        System.out.println(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //1. 暴力解法 递归 超时
//        if(amount==0) return 0;
//        if(amount<0) return -1;
//        int mmin = Integer.MAX_VALUE;
//        for (int coin:coins) {
//            //if(amount-coin<0) continue;不能这样写
//            int sub = coinChange(coins,amount-coin);
//            if(sub == -1) continue;
//            mmin = Math.min(mmin,sub+1);
//        }
//        return (mmin == Integer.MAX_VALUE) ? -1 : mmin;

        //2. 添加备忘录，递归，消除多余计算
//        int memo[] = new int[amount+1];
//        return coin_Change(coins,memo,amount);
//    }
//    public int coin_Change(int[] coins, int[] memo, int amount){
//        if(amount==0) return 0;
//        if(amount<0) return -1;
//        if(memo[amount] != 0) return memo[amount];
//        int mmin = Integer.MAX_VALUE;
//        for (int coin:coins) {
//            int sub = coin_Change(coins,memo,amount-coin);
//            if(sub == -1) continue;
//            mmin = Math.min(mmin,sub+1);
//        }
//        memo[amount] = (mmin == Integer.MAX_VALUE) ? -1 : mmin;
//        return memo[amount];
//    }

        //3. 动态规划
//        int dp[] = new int[amount+1];
//        dp[0] = 0;
//        for (int i = 1; i < amount + 1 ; i++) {
//            dp[i] = amount + 1;
//            for(int coin:coins){
//                if(i - coin < 0) continue;
//                dp[i] = Math.min(dp[i-coin]+1,dp[i]);
//            }
//        }
//        return dp[amount] == amount+1 ? -1 : dp[amount];

        int dp[] = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i < amount+1; i++) {
            dp[i] = amount + 1;
        }
        for(int coin : coins){
            for (int i = coin; i < amount + 1; i++) {
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}