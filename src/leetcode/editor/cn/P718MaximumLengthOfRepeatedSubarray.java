//给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。 
//
// 示例 1: 
//
// 
//输入:
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出: 3
//解释: 
//长度最长的公共子数组是 [3, 2, 1]。
// 
//
// 说明: 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 哈希表 二分查找 动态规划

  
package leetcode.editor.cn;
//java:最长重复子数组
public class P718MaximumLengthOfRepeatedSubarray{
    public static void main(String[] args) {
        Solution solution = new P718MaximumLengthOfRepeatedSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] A, int[] B) {
        //1. 动态规划 dp[i][j] 表示A[i:] B[j:] 的公共子数组长度  O(MN)
//        int m = A.length, n = B.length;
//        int ans = -1;
//        int[][] dp = new int[m+1][n+1];
//        for (int i = m-1; i >= 0; i--) {
//            for (int j = n-1; j >= 0; j--) {
//                dp[i][j] = A[i] == B[j] ? dp[i+1][j+1] + 1 : 0;
//                ans = Math.max(ans, dp[i][j]);
//            }
//        }
//        return ans;
        //2. 滑动窗口
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int Astart, int Bstart, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[Astart + i] == B[Bstart + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}