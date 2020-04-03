//给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问
// k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。 
//
// 示例 1： 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36 
//
// 提示： 
//
// 
// 2 <= n <= 58 
// 
//
// 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/ 
// Related Topics 数学 动态规划

  
package leetcode.editor.cn;
//java:剪绳子
public class P面试题14IJianShengZiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题14IJianShengZiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int cuttingRope(int n) {
            // 找规律
//            if(n <= 3) return n - 1;
//            int a = n / 3, b = n % 3;
//            if(b == 0) return (int)Math.pow(3, a);
//            if(b == 1) return (int)Math.pow(3, a - 1) * 4;
//            return (int)Math.pow(3, a) * 2;
            // 动态规划
            if (n < 2) {
                return 0;
            }
            int[] dp = new int[n + 1];
            dp[2] = 1;
            for (int i = 3; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
                }
            }
            return dp[n];
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}