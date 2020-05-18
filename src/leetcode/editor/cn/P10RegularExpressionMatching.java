//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// '.' 匹配任意单个字符
//'*' 匹配零个或多个前面的那一个元素
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "a*"
//输出: true
//解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3: 
//
// 输入:
//s = "ab"
//p = ".*"
//输出: true
//解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4: 
//
// 输入:
//s = "aab"
//p = "c*a*b"
//输出: true
//解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5: 
//
// 输入:
//s = "mississippi"
//p = "mis*is*p*."
//输出: false 
// Related Topics 字符串 动态规划 回溯算法

  
package leetcode.editor.cn;
//java:正则表达式匹配
public class P10RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //1. 递归
//        public boolean isMatch(String s, String p) {
//            if(s == null || p == null) return false;
//            return match(s,p);
//        }
//        public boolean match(String s, String p){
//            if(p.length() == 0){
//                return s.length()==0;
//            }
//            if(p.length() > 1 && p.charAt(1) == '*'){
//                return match(s, p.substring(2)) ||
//                        s.length() > 0 &&(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && match(s.substring(1), p);
//            }else{
//                return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && match(s.substring(1), p.substring(1));
//            }
//        }

        //2. 动态规划
        public boolean isMatch(String s, String p) {
            char[] schar = s.toCharArray();
            char[] pchar = p.toCharArray();
            int m = schar.length, n = pchar.length;
            // 这里dp矩阵是要大一圈的，用来处理s或者p为空串的情况，矩阵的行标i对应s的i-1，矩阵的列标j对应p的j-1
            boolean[][] dp = new boolean[m + 1][n + 1];
            // s和p都是空串的时候自然true
            dp[0][0] = true;
            // 初始化首列
            for(int i = 1; i <= m; i++){
                dp[i][0] = false;
            }
            // 初始化首行
            for(int j = 1; j <= n; j++){
                if(j == 1 || pchar[j - 1] != '*') dp[0][j] = false;
                else dp[0][j] = dp[0][j - 2];

            }
            // 通过递推公式开始填充矩阵
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(pchar[j - 1] != '*'){
                        dp[i][j] = (schar[i - 1] == pchar[j - 1] || pchar[j - 1] == '.') && dp[i - 1][j - 1];
                    }
                    else{
                        if(schar[i - 1] == pchar[j - 2] || pchar[j - 2] == '.'){
                            dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                            if(j > 1) dp[i][j] = dp[i][j] || dp[i][j - 2];
                        }
                        else{
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}