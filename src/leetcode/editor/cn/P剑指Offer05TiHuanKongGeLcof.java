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
// Related Topics 字符串 👍 193 👎 0


package leetcode.editor.cn;

// java: 替换空格
public class P剑指Offer05TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer05TiHuanKongGeLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private StringBuilder sb = new StringBuilder();

        public String replaceSpace(String s) {
            for (Character c : s.toCharArray()) {
                if (c == ' ') {
                    sb.append("%20");
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}