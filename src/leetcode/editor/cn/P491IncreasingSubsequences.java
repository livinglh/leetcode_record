//给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。 
//
// 示例: 
//
// 
//输入: [4, 6, 7, 7]
//输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7
//]] 
//
// 说明: 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 深度优先搜索 
// 👍 127 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:递增子序列
public class P491IncreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new P491IncreasingSubsequences().new Solution();
        solution.findSubsequences(new int[]{4,6,7,7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curlist = new ArrayList<>();
        public List<List<Integer>> findSubsequences(int[] nums) {

            DFS(0, Integer.MIN_VALUE, nums);
            return ans;
        }

        public void DFS(int cur, int pre, int[] nums){
            if(cur == nums.length){
                if(curlist.size() >= 2){
                    ans.add(new ArrayList<>(curlist));
                }
                return;
            }

            if(nums[cur] >= pre){
                curlist.add(nums[cur]);
                DFS(cur+1, nums[cur], nums);
                curlist.remove(curlist.size()-1);
            }
            // 只有当当前的元素不等于上一个选择的元素的时候，才考虑不选择当前元素，直接递归后面的元素。
            if(nums[cur] != pre){
                DFS(cur+1, pre, nums);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}