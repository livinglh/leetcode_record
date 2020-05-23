//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组

  
package leetcode.editor.cn;
//java:除自身以外数组的乘积
public class P238ProductOfArrayExceptSelf{
    public static void main(String[] args) {
        Solution solution = new P238ProductOfArrayExceptSelf().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //1. 左右乘积数组
//        int len = nums.length;
//        int[] left = new int[len];
//        int[] right = new int[len];
//        int[] ans = new int[len];
//        left[0] = 1;
//        for (int i = 1; i < len; i++) {
//            left[i] = left[i-1] * nums[i-1];
//        }
//        right[len-1] = 1;
//        for (int i = len-2; i >=0 ; i--) {
//            right[i] = right[i+1] * nums[i+1];
//        }
//        for (int i = 0; i < len; i++) {
//            ans[i] = left[i] * right[i];
//        }
//        return ans;
        //1. 左右乘积数组，空间优化位O1；
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1; //左
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int preright = 1;
        for (int i = len-1; i >=0 ; i--) {
            ans[i] = ans[i] * preright;
            preright = preright * nums[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}