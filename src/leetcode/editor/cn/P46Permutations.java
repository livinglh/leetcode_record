//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//java:全排列
public class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        back(path,nums,visited);
        return ans;
    }
    public void back(List<Integer> path, int[] nums, boolean[] visited){
        if(path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == false){
                visited[i] = true;
                path.add(nums[i]);
                back(path,nums,visited);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}