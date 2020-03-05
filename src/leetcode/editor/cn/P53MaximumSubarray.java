//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4],
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划

  
package leetcode.editor.cn;
//java:最大子序和
public class P53MaximumSubarray{
    public static void main(String[] args) {
        Solution solution = new P53MaximumSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        //将原问题：n个数的数组的最大字段和转换为分别求出以第1个，第2个，第n个数字结尾的最大字段和，再找出n个结果中最大的
//        if(nums.length==0) return 0;
//        int ans = nums[0];
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = dp[i-1]>0 ? dp[i-1]+nums[i] : nums[i];
//            ans = ans > dp[i] ? ans : dp[i];
//        }
//        return ans;
        //优化空间复杂度为O(1)
        if(nums.length==0) return 0;
        int ans = nums[0], cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            cur = Math.max(cur+nums[i],nums[i]);
            ans = Math.max(ans,cur);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}