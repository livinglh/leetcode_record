//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划

  
package leetcode.editor.cn;
//java:乘积最大子数组
public class P152MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        solution.maxProduct(new int[]{-4,-3,-2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
//        if(nums.length == 0) return 0;
//        if(nums.length == 1) return nums[0];
//        int[] dpmax = new int[nums.length];
//        int[] dpmin = new int[nums.length];
//        dpmax[0] = dpmin[0] = nums[0];
//        int res = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dpmax[i] = Math.max(nums[i], Math.max(dpmax[i-1] * nums[i], dpmin[i-1] * nums[i]));
//            dpmin[i] = Math.min(nums[i], Math.min(dpmax[i-1] * nums[i], dpmin[i-1] * nums[i]));
//            res = Math.max(res , dpmax[i]);
//        }
//        return res;
        int max = Integer.MIN_VALUE, iMax = 1, iMin = 1;
        for (int num : nums) {
            if (num < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }
            iMax = Math.max(iMax * num, num);
            iMin = Math.min(iMin * num, num);
            max = Math.max(max, iMax);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}