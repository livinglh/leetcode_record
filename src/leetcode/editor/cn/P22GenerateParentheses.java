//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 
//
// 例如，给出 n = 3，生成结果为： 
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:括号生成
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    char[] ch = {'(', ')'};
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        find(0, 0, n, "");
        return ans;
    }
    public void find(int left, int right, int n, String s){
//        if(left < right) return;
        if(left == n && right == n){
            ans.add(s);
            return;
        }
        if(left<n) find(left+1,right,n,s+'(');
        if(right<left) find(left,right+1,n,s+')');
//        if(right<n) find(left,right+1,n,s+')');

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}