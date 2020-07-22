//给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
// 输入: [1,2,2]
//输出:
//[
//  [2],
//  [1],
//  [1,2,2],
//  [2,2],
//  [1,2],
//  []
//] 
// Related Topics 数组 回溯算法 
// 👍 273 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//java:子集 II
public class P90SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new P90SubsetsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> sub){
        res.add(new ArrayList<>(sub));
        for (int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            sub.add(nums[i]);
            backtrack(i+1, nums, res, sub);
            sub.remove(sub.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}