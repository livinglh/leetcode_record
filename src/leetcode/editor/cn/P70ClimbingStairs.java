//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

  
package leetcode.editor.cn;
//java:爬楼梯
public class P70ClimbingStairs{
    public static void main(String[] args) {
        int n = 2;
        Solution solution = new P70ClimbingStairs().new Solution();
        int ans = solution.climbStairs(n);
        System.out.println(ans);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int climbStairs(int n) {

//法1 回溯 超时
//        if(n==1 || n==2){
//            return n;
//        }
//        return climbStairs(n-1)+climbStairs(n-2);

//        climb_Stairs(0, n);
//        return 0;
//法2 动态规划：
//        1 确认原问题与子问题 原问题为求n阶台阶的走法，子问题为求1，2，。。。，n-1阶台阶走法
//        2 确认状态 本问题状态单一，第i个状态即为i阶台阶的所有走法数量
//        3 确认边界的值 边界状态为1阶和2阶台阶的走法 dp[1] = 1,dp[2] = 2
//        4 确认状态转移方程 将求第i个状态的值转为求第i-1个状态与第i-2个状态的值，为其之和
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];

//法3 暴力法 超时 树 时间复杂度2的n次方
//        return climb_Stairs(0, n);
//    }
//    public int climb_Stairs(int i, int n) {
//        if (i > n) {
//            return 0;
//        }
//        if (i == n) {
//            return 1;
//        }
//        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
//    }
//法4 对法3进行优化 减少多余的计算
//把每一步的结果存储在 memo 数组之中，每当函数再次被调用，我们就直接从 memo 数组返回结果
//            int[] memo = new int[n + 1];
//            return climb_Stairs(0, n, memo);
//        }
//
//        public int climb_Stairs(int i, int n, int[] memo) {
//            if (i > n) return 0;
//            if (i == n) return 1;
//            if (memo[i] > 0) return memo[i];
//            memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
//            return memo[i];
//        }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}