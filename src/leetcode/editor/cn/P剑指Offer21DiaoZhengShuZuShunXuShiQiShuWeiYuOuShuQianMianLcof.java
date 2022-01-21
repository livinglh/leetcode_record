//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 0 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 👍 184 👎 0


package leetcode.editor.cn;
// java: 调整数组顺序使奇数位于偶数前面
public class P剑指Offer21DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer21DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[right] % 2 == 1) {
                while (nums[left] % 2 == 1 && left < right) {
                    left++;
                }
                if (left >= right) break;
                swap(nums, left, right);
            }
            right--;
        }
        return nums;
    }

    public void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}