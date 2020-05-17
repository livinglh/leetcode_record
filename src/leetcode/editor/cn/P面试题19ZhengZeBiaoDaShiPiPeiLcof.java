//请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配
//是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。 
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
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 
//
// 注意：本题与主站 10 题相同：https://leetcode-cn.com/problems/regular-expression-matching/
// 
// Related Topics 动态规划

  
package leetcode.editor.cn;
//java:正则表达式匹配
public class P面试题19ZhengZeBiaoDaShiPiPeiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题19ZhengZeBiaoDaShiPiPeiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            if(s==null||p==null){
                return false;
            }
            return match(s,p);
        }
        private boolean match(String s,String p){
            //如果p长度为0，则返回s是否匹配完·
            if (p.length() == 0) {
                return s.length() == 0;
            }
            //如果p当前匹配位置有下一个位置，且下一个是'*'
            if (p.length() > 1 && p.charAt(1) == '*') {
                //按是否跳过当前*分情况
                //一种情况，跳过当前*，匹配s和跳过*后的p
                //第二种情况，不跳过当前*，进行匹配，返回当前s的第一个和p的第一个匹配，并且s之后的也和p匹配
                return match(s, p.substring(2))
                        || (s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) && match(s.substring(1), p);
            } else {
                //如果当前位置下一个不为*，那么返回当前s的第一个和p的第一个匹配，并且s之后的也和p之后（因为没有*）匹配
                return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p.substring(1));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}