//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。 
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:杨辉三角
public class P118PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();

        pre.add(1);
        ans.add(new ArrayList<>(pre));
        if(numRows == 1){
            return ans;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 0; j < pre.size() - 1; j++) {
                cur.add(pre.get(j) + pre.get(j+1));
            }
            cur.add(1);
            pre = cur;
            ans.add(cur);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}