//给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 你找到的子数组应是最短的，请输出它的长度。 
//
// 示例 1: 
//
// 
//输入: [2, 6, 4, 8, 10, 9, 15]
//输出: 5
//解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 说明 : 
//
// 
// 输入的数组长度范围在 [1, 10,000]。 
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。 
// 
// Related Topics 数组

  
package leetcode.editor.cn;
//java:最短无序连续子数组
public class P581ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
        Solution solution = new P581ShortestUnsortedContinuousSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        //从左到右找出最后一个破坏递增的数
        //从右到左找出最后一个破坏递减的数
        //无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界
        int len = nums.length;
        if(len <= 1) {
            return 0;
        }
        int high = 0,low = len-1,curMax = Integer.MIN_VALUE,curMin=Integer.MAX_VALUE;
        for(int i = 0;i<len;i++){
            if(nums[i] >= curMax){
                curMax = nums[i];
            } else {
                high = i;
            }
            if(nums[len-i-1] <= curMin){
                curMin = nums[len-i-1];
            } else {
                low = len - i - 1;
            }
        }
        return high > low ? high -low + 1 : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}