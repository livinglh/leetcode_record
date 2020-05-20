//有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 
//left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 说明: 
//
// 
// 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。 
// 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 
// 
//
// 示例: 
//
// 输入: [3,1,5,8]
//输出: 167 
//解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//     coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
// 
// Related Topics 分治算法 动态规划

  
package leetcode.editor.cn;
//java:戳气球
public class P312BurstBalloons{
    public static void main(String[] args) {
        Solution solution = new P312BurstBalloons().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCoins(int[] nums) {
        // 动态规划
        // 1. 添加两侧虚拟气球 转换问题为求解气球（0,n+1)间的最大得分
        int n = nums.length;
        int[] points = new int[n + 2];
        points[0] = 1; points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        int[][] dp = new int[n + 2][n + 2];
        // 2. 初始化  dp[i][j] = 0，其中 0 <= i,j <= n+1, j - i <=1

        // 3. 开始遍历 由于最后我们需要得到 dp[0][n+1] 而dp[i][j]的求解需要知道 dp[i][k] dp[k][j], i < k < j
        // 所以这里选择从下往上，从左往右进行遍历
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j <= n+1; j++){
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }

        return dp[0][n+1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}