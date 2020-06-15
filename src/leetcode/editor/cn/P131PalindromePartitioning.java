//给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回 s 所有可能的分割方案。 
//
// 示例: 
//
// 输入: "aab"
//输出:
//[
//  ["aa","b"],
//  ["a","a","b"]
//] 
// Related Topics 回溯算法

  
package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//java:分割回文串
public class P131PalindromePartitioning{
    public static void main(String[] args) {
        Solution solution = new P131PalindromePartitioning().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        //1. 递归回溯
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if(len == 0) {
            return res;
        }

        Deque<String> stack = new ArrayDeque<>();
        backtracking(s,0,len,stack,res);
        return res;
    }

    private void backtracking(String s, int start, int len, Deque<String> stack, List<List<String>> res){
        if(start >= len){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            if(!cheack(s, start, i)){
                continue;
            }
            stack.addLast(s.substring(start,i+1));
            backtracking(s, i+1, len, stack, res);
            stack.pollLast();
        }
    }

    //字符串[left：right]是否是回文
    private boolean cheack(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}