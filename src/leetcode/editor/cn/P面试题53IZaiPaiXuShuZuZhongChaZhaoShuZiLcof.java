//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找

  
package leetcode.editor.cn;

//java:在排序数组中查找数字 I
public class P面试题53IZaiPaiXuShuZuZhongChaZhaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题53IZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        solution.search(new int[]{1,2,2,2,3}, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            if(nums.length == 0) return 0;
            int left = -1, right = -1;
            // 寻找左边界
            int l = 0, r = nums.length - 1;
            while(l <= r){
                int m = l + ((r - l) >>> 1);
                if(nums[m] >= target) r = m - 1;
                else l = m + 1;
            }
            if(l >= nums.length || nums[l] != target) return 0;
            left = l;

            // 寻找右边界
            l = 0; r = nums.length - 1;
            while(l <= r){
                int m = l + ((r - l) >>> 1);
                if(nums[m] <= target) l = m + 1;
                else r = m - 1;
            }
            right = r;

            return right-left+1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}