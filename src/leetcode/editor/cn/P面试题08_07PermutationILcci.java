//无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。 
//
// 示例1: 
//
// 
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
// 
//
// 示例2: 
//
// 
// 输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 22 👎 0

  
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//java:无重复字符串的排列组合
public class P面试题08_07PermutationILcci{
    public static void main(String[] args) {
        Solution solution = new P面试题08_07PermutationILcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> ans = new LinkedList<>();
    public String[] permutation(String S) {
        int len = S.length();

        boolean[] visited = new boolean[len];
        StringBuilder sb = new StringBuilder();
        DFS(S.toCharArray(), visited, sb, 0, len);

        return ans.toArray(new String[ans.size()]);
    }

    private void DFS(char[] ch, boolean[] visited, StringBuilder sb, int cur, int len){
        if(cur == len){
            ans.add(sb.toString());
        }

        for (int i = 0; i < len; i++) {
            if(!visited[i]){
                visited[i] = true;
                sb.append(ch[i]);
                DFS(ch, visited, sb, cur + 1, len);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}