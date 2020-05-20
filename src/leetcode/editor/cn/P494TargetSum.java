//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选
//择一个符号添加在前面。 
//
// 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。 
//
// 示例 1: 
//
// 输入: nums: [1, 1, 1, 1, 1], S: 3
//输出: 5
//解释: 
//
//-1+1+1+1+1 = 3
//+1-1+1+1+1 = 3
//+1+1-1+1+1 = 3
//+1+1+1-1+1 = 3
//+1+1+1+1-1 = 3
//
//一共有5种方法让最终目标和为3。
// 
//
// 注意: 
//
// 
// 数组非空，且长度不会超过20。 
// 初始的数组的和不会超过1000。 
// 保证返回的最终结果能被32位整数存下。 
// 
// Related Topics 深度优先搜索 动态规划


package leetcode.editor.cn;

//java:目标和
public class P494TargetSum {
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        // 1. 递归
//        int count = 0;
//        public int findTargetSumWays(int[] nums, int S) {
//            calculate(nums, 0, 0, S);
//            return count;
//        }
//        public void calculate(int[] nums, int i, int sum, int S) {
//            if (i == nums.length) {
//                if (sum == S)
//                    count++;
//            } else {
//                calculate(nums, i + 1, sum + nums[i], S);
//                calculate(nums, i + 1, sum - nums[i], S);
//            }
//        }
//        //2. 动态规划
//        //dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数
//        //dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
//        public int findTargetSumWays(int[] nums, int S) {
//            int[][] dp = new int[nums.length][2001];
//            dp[0][nums[0] + 1000] = 1;
//            dp[0][-nums[0] + 1000] += 1;
//            for (int i = 1; i < nums.length; i++) {
//                for (int sum = -1000; sum <= 1000; sum++) {
//                    if (dp[i - 1][sum + 1000] > 0) {
//                        dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
//                        dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
//                    }
//                }
//            }
//            return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
//        }
        //3. 动态规划
        //转换为子集求和问题： 01背包
        //sum(P) - sum(N) = target
        //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        //               2 * sum(P) = target + sum(nums)

        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int n : nums)
                sum += n;
            if (sum < S || (sum + S) % 2 == 1) {
                return 0;
            }

            int w = (S+sum) >>> 1;
            int[] dp = new int[w + 1];
            dp[0] = 1;
            for (int n : nums)
                for (int i = w; i >= n; i--)
                    dp[i] += dp[i - n];
            return dp[w];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}