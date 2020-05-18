//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划

  
package leetcode.editor.cn;

import java.util.Stack;

//java:最长有效括号
public class P32LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        //1. 暴力解法
        //2. 动态规划 dp[i] 表示以下标 i 为字符结尾的最长有效字符串的长度
        int maxLen = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < dp.length; i++) {
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = i-2 >= 0 ? dp[i-2] + 2 : 2;
                }else{
                    if(i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                        dp[i] = i-dp[i-1]-2 >= 0 ? dp[i-1] + dp[i-dp[i-1]-2] + 2 : dp[i-1] + 2;
                    }
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
        //3. 栈
//        if (s.length() < 2) {
//            return 0;
//        }
//        Stack<Integer> stack = new Stack<>();
//        int max = 0;
//        stack.add(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            } else {
//                stack.pop();
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                } else {
//                    max = max > (i - stack.peek()) ? max : (i - stack.peek());
//                }
//            }
//        }
//        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}