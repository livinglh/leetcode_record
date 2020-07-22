//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入: S = "3z4"
//输出: ["3z4", "3Z4"]
//
//输入: S = "12345"
//输出: ["12345"]
// 
//
// 注意： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 回溯算法 
// 👍 189 👎 0

  
package leetcode.editor.cn;
import java.util.ArrayList;
import java.util.List;

//java:字母大小写全排列
public class P784LetterCasePermutation{
    public static void main(String[] args) {
        Solution solution = new P784LetterCasePermutation().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        backtrack(S, ans, builder, 0);
        return ans;
    }

    public void backtrack(String S,List<String> ans, StringBuilder builder, int i){
        if(i == S.length()){
            ans.add(builder.toString());
        }else{
            if(S.charAt(i) >= '0' && S.charAt(i) <= '9'){
//                int len = builder.length();
                builder.append(S.charAt(i));
                backtrack(S, ans, builder, i+1);
//                builder.setLength(len);
            }else{
                int len = builder.length();
                builder.append(Character.toLowerCase(S.charAt(i)));
                backtrack(S, ans, builder, i+1);
                builder.setLength(len);
                builder.append(Character.toUpperCase(S.charAt(i)));
                backtrack(S, ans, builder, i+1);
                builder.setLength(len);
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}