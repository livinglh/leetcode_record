//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 481 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

// java: 字符串的排列
public class P剑指Offer38ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer38ZiFuChuanDePaiLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> ans = new HashSet<>();
        boolean[] visited;

        public String[] permutation(String s) {
            if (s == null) {
                return new String[] {};
            }
            visited = new boolean[s.length()];
            reback(s, "");
            return ans.toArray(new String[s.length()]);
        }

        public void reback(String s, String cur) {
            if (s.length() == cur.length()) {
                ans.add(cur);
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                reback(s, cur + s.charAt(i));
                visited[i] = false;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}