//给定一个长度为 n 的整数数组和一个目标值 target，寻找能够使条件 nums[i] + nums[j] + nums[k] < target 成立的三
//元组 i, j, k 个数（0 <= i < j < k < n）。 
//
// 示例： 
//
// 输入: nums = [-2,0,1,3], target = 2
//输出: 2 
//解释: 因为一共有两个三元组满足累加和小于 2:
//     [-2,0,1]
//     [-2,0,3]
// 
//
// 进阶：是否能在 O(n2) 的时间复杂度内解决？ 
// Related Topics 数组 双指针 
// 👍 30 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//java:较小的三数之和
public class P259ThreeSumSmaller {
    public static void main(String[] args) {
        Solution solution = new P259ThreeSumSmaller().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int len = nums.length;
            int ans = 0;
            for (int i = 0; i < len - 2; i++) {
                int left = i + 1, right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        ans += right - left;
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}