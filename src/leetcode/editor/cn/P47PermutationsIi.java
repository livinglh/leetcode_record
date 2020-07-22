//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法 
// 👍 354 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:全排列 II
public class P47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new P47PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            boolean[] visited = new boolean[nums.length];
            List<Integer> path = new ArrayList<>();
            back(path, nums, visited);
            return ans;
        }

        public void back(List<Integer> path, int[] nums, boolean[] visited) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] == false) {
                    if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
                    visited[i] = true;
                    path.add(nums[i]);
                    back(path, nums, visited);
                    visited[i] = false;
                    path.remove(path.size() - 1);
                }
            }
            return;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}