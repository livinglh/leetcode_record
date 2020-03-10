//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
//

  
package leetcode.editor.cn;
//java:替换空格
public class P面试题05TiHuanKongGeLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题05TiHuanKongGeLcof().new Solution();
        solution.replaceSpace("dsfa sfs");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {
            StringBuilder res = new StringBuilder();
            for(Character c : s.toCharArray())
            {
                if(c == ' ') res.append("%20");
                else res.append(c);
            }
            return res.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}