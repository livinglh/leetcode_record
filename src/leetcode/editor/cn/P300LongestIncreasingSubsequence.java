//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划

  
package leetcode.editor.cn;
//java:最长上升子序列
public class P300LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new P300LongestIncreasingSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        //动态规划
        //dp[i]代表以第i个元素结尾的最长上升子序列的长度
//        if(nums.length == 0) return 0;
//        int dp[] = new int[nums.length];
//        dp[0] = 1;
//        int ans = 1;
//        for(int i = 1; i < nums.length; i++){
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                if(nums[j] < nums[i]){
//                    dp[i] = Math.max(dp[j]+1,dp[i]);
//                }
//            }
//            ans = Math.max(ans,dp[i]);
//        }
//        return ans;
        //动态规划 + 二分查找
        //tails[k] 的值代表 长度为 k+1 子序列 的尾部元素值
        int res = 0;
        int[] tails = new int[nums.length];
        for (int num: nums) {
            int i = 0, j = res;
            while(i < j){
                int mid = (i + j)/2;
                if(tails[mid] < num) i = mid + 1;
                else j = mid;
            }
            tails[i] = num;
            if(j == res) res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}