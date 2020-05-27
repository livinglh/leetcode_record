//给你两个数组 nums1 和 nums2 。 
//
// 请你返回 nums1 和 nums2 中两个长度相同的 非空 子序列的最大点积。 
//
// 数组的非空子序列是通过删除原数组中某些元素（可能一个也不删除）后剩余数字组成的序列，但不能改变数字间相对顺序。比方说，[2,3,5] 是 [1,2,3,4
//,5] 的一个子序列而 [1,5,3] 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
//输出：18
//解释：从 nums1 中得到子序列 [2,-2] ，从 nums2 中得到子序列 [3,-6] 。
//它们的点积为 (2*3 + (-2)*(-6)) = 18 。 
//
// 示例 2： 
//
// 
//输入：nums1 = [3,-2], nums2 = [2,-6,7]
//输出：21
//解释：从 nums1 中得到子序列 [3] ，从 nums2 中得到子序列 [7] 。
//它们的点积为 (3*7) = 21 。 
//
// 示例 3： 
//
// 
//输入：nums1 = [-1,-1], nums2 = [1,1]
//输出：-1
//解释：从 nums1 中得到子序列 [-1] ，从 nums2 中得到子序列 [1] 。
//它们的点积为 -1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 500 
// -1000 <= nums1[i], nums2[i] <= 100 
// 
//
// 
//
// 点积： 
//
// 
//定义 a = [a1, a2,…, an] 和 b = [b1, b2,…, bn] 的点积为：
//
//
//
//这里的 Σ 指示总和符号。
// 
// Related Topics 动态规划

  
package leetcode.editor.cn;

import java.util.Arrays;

//java:两个子序列的最大点积
public class P1458MaxDotProductOfTwoSubsequences{
    public static void main(String[] args) {
        Solution solution = new P1458MaxDotProductOfTwoSubsequences().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
//        dp[i][j]的含义是到nums1[i-1]和nums2[j-1]为止的子序列的最大点积。
//        其中dp[i][j]有四种选择，
//            （1）只选择nums1[i-1]和nums2[j-1]
//            （2）选择nums1[i-1],不选择nums2[j-1]
//            （3）不选择nums1[i-1],选择nums2[j-1]
//            （4）选择nums1[i-1]和nums2[j],同时选择前面的
        int m = nums1.length, n = nums2.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -1000000);
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1 ; j++) {
                dp[i][j] = nums1[i-1] * nums2[j-1];
                dp[i][j] = Math.max(dp[i][j], dp[i][j] + dp[i-1][j-1]);
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                //dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]);  //包含在dp[i-1][j]情况中
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}