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
// Related Topics 回溯算法

  
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//java:字符串的排列
public class P面试题38ZiFuChuanDePaiLieLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题38ZiFuChuanDePaiLieLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Set<String> ans = new HashSet<>();
    boolean[] visited;
    public String[] permutation(String s) {
        if(s == null) return new String[]{};
        visited = new boolean[s.length()];
        reback(s, "");
        return ans.toArray(new String[s.length()]);
    }
    public void reback(String s, String cur){
        if(cur.length() == s.length()){
            ans.add(cur);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(visited[i] == true) continue;
            visited[i] = true;
            char c = s.charAt(i);
            reback(s, cur + String.valueOf(c));
            visited[i] = false;
        }
    }
}
// 题解解法 排序 + 去重 + 递归 无set
//class Solution {
//    public String[] permutation(String s) {
//        List<String> ans = new ArrayList<>();
//        char[] arrayS = s.toCharArray();
//        Arrays.sort(arrayS);
//        permutationHelper(ans, new boolean[s.length()], new LinkedList<Character>(), arrayS);
//        String[] res = new String[ans.size()];
//        for(int i = 0; i < ans.size(); i++){
//            res[i] = ans.get(i);
//        }
//        return res;
//    }
//    private void permutationHelper(List<String> ans, boolean[] visited, LinkedList<Character> list, char[] s){
//        if(list.size() == s.length){
//            StringBuilder sb = new StringBuilder();
//            for(char c : list){
//                sb.append(c);
//            }
//            ans.add(sb.toString());
//            return;
//        }
//
//        for(int i = 0; i < s.length; i++){
//            if(i != 0 && s[i] == s[i - 1] && visited[i - 1]) continue;
//            if(!visited[i]){
//                list.addLast(s[i]);
//                visited[i] = true;
//                permutationHelper(ans, visited, list, s);
//                list.removeLast();
//                visited[i] = false;
//            }
//        }
//    }
//}

//leetcode submit region end(Prohibit modification and deletion)

}