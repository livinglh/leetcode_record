//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 如果数组中不存在目标值，返回 [-1, -1]。 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: [3,4] 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: [-1,-1] 
// Related Topics 数组 二分查找 
// 👍 540 👎 0

  
package leetcode.editor.cn;
//java:在排序数组中查找元素的第一个和最后一个位置
public class P34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1,-1};
        int len = nums.length;
        if(len == 0) return ans;
        int left = 0, right = len - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        if(nums[left] != target || left >= len){
            return ans;
        }
        ans[0] = left;
        int start = left, end = len -1;
        while(start < end){
            int mid = start + (end - start) / 2 + 1;
            if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid;
            }
        }
        ans[1] = start;
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}