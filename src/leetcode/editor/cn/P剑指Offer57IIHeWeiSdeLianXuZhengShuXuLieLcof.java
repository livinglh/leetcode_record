//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// Related Topics 数学 双指针 枚举 👍 357 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

// java: 和为s的连续正数序列
public class P剑指Offer57IIHeWeiSdeLianXuZhengShuXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer57IIHeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int left = 1, right = 1, sum = 1;
            List<int[]> ans = new ArrayList<>();
            while (right <= target / 2 + 1) {
                if (sum == target) {
                    int[] cur = new int[right - left + 1];
                    for (int i = left; i <= right; i++) {
                        cur[i - left] = i;
                    }
                    ans.add(cur);
                    sum -= left;
                    left++;
                } else if (sum < target) {
                    right++;
                    sum += right;
                } else {
                    sum -= left;
                    left++;
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}