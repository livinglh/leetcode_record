//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 334 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//java:组合
public class P77Combinations{
    public static void main(String[] args) {
        Solution solution = new P77Combinations().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(n <= 0 || k <= 0 || n < k){
            return res;
        }
        DFS(n, k, 1, new LinkedList<>());
        return res;
    }

    public void DFS(int n, int k, int cur, List<Integer> curlist){
        if(curlist.size() == k){
            res.add(new ArrayList<>(curlist));
            return;
        }

        for (int i = cur; i <= n - k + curlist.size() + 1; i++) {
            curlist.add(i);
            DFS(n, k, i + 1, curlist);
            curlist.remove(curlist.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}