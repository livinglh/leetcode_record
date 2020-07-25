//给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。 
//
// 注意: 
//数组长度 n 满足以下条件: 
//
// 
// 1 ≤ n ≤ 1000 
// 1 ≤ m ≤ min(50, n) 
// 
//
// 示例: 
//
// 
//输入:
//nums = [7,2,5,10,8]
//m = 2
//
//输出:
//18
//
//解释:
//一共有四种方法将nums分割为2个子数组。
//其中最好的方式是将其分为[7,2,5] 和 [10,8]，
//因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
// 
// Related Topics 二分查找 动态规划 
// 👍 205 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.Arrays;

//java:分割数组的最大值
public class P410SplitArrayLargestSum {
    public static void main(String[] args) {
        Solution solution = new P410SplitArrayLargestSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int splitArray(int[] nums, int m) {
//        // 法1： 动态规划 dp[i][j]表示前i个数分割为j段所能得到的最大连续子数组的最小值
//        // 转移方程 dp[i][j] = min(dp[k][j-1],sub(k+1,i)
//        int n = nums.length;
//        int[][] dp = new int[n+1][m+1];
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(dp[i], Integer.MAX_VALUE);
//        }
//        int[] sub = new int[n+1]; //前缀和数组 sub[i]表示前i个数的总和
//        for (int i = 0; i < n; i++) {
//            sub[i+1] = sub[i] + nums[i];
//        }
//        dp[0][0] = 0;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= Math.min(i,m) ; j++) {
//                for (int k = 0; k < i; k++) {
//                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1],sub[i] - sub[k]));
//                }
//            }
//        }
//        return dp[n][m];


            // 法2：二分查找+贪心
            int left = 0, right = 0;
            for (int i = 0; i < nums.length; i++) {
                right += nums[i];
                if (left < nums[i]) {
                    left = nums[i];
                }
            }
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (check(nums, mid, m)){
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        // 若x为最大值，计算可以分出多少个子数组，遍历结束后验证cnt不超过m
        public boolean check(int[] nums, int x, int m) {
            int cnt = 1, sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if(sum + nums[i] > x){
                    cnt += 1;
                    sum = nums[i];
                }else{
                    sum += nums[i];
                }
            }
            return cnt <= m;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}