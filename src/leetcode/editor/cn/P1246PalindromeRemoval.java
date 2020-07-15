//给你一个整数数组 arr，每一次操作你都可以选择并删除它的一个 回文 子数组 arr[i], arr[i+1], ..., arr[j]（ i <= j）。
// 
//
// 注意，每当你删除掉一个子数组，右侧元素都会自行向前移动填补空位。 
//
// 请你计算并返回从数组中删除所有数字所需的最少操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,2]
//输出：2
// 
//
// 示例 2： 
//
// 输入：arr = [1,3,4,1,5]
//输出：3
//解释：先删除 [4]，然后删除 [1,3,1]，最后再删除 [5]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 100 
// 1 <= arr[i] <= 20 
// 
// Related Topics 动态规划 
// 👍 30 👎 0

  
package leetcode.editor.cn;
//java:删除回文子数组
public class P1246PalindromeRemoval{
    public static void main(String[] args) {
        Solution solution = new P1246PalindromeRemoval().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        if(n < 2) return n;
        int[][] dp = new int[n][n];
        // 初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if(i != n-1){
                dp[i][i+1] = arr[i] == arr[i+1] ? 1 : 2;
            }
        }

        // dp转移
        // dp[i][j] = Math.min(dp[i+1][j-1], dp[i][k] + dp[k+1][j];
        // dp[i][j] = Math.min(dp[i][k] + dp[k+1][j])
        for (int j = 2; j < n; j++) {
            for (int i = j-2; i >= 0; i--) {
                int min = n;
                if(arr[i] == arr[j]){
                    min = dp[i+1][j-1];
                }
                for (int k = i; k < j; k++) {
                    min = Math.min(min, dp[i][k] + dp[k+1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][n-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}