//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [2,3,6,7], target = 7,
//所求解集为:
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,3,5], target = 8,
//所求解集为:
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
// Related Topics 数组 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//java:组合总和
public class P39CombinationSum{
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>();
        DFS(candidates, 0,target,path);
        return ans;
    }
    public void DFS(int[] candidates, int start, int target, LinkedList<Integer> path){
        if(target == 0){
            ans.add(new LinkedList<>(path));
            // 注意这里的添加操作不能用ans.add(path);
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) break;
            path.offer(candidates[i]);
            DFS(candidates, i, target - candidates[i], path);
            path.removeLast();
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}