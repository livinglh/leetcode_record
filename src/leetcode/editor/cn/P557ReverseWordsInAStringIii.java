//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 示例 1: 
//
// 
//输入: "Let's take LeetCode contest"
//输出: "s'teL ekat edoCteeL tsetnoc" 
// 
//
// 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// Related Topics 字符串 
// 👍 214 👎 0

  
package leetcode.editor.cn;
//java:反转字符串中的单词 III
public class P557ReverseWordsInAStringIii{
    public static void main(String[] args) {
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(new StringBuilder(str).reverse().toString() + " ");
        }
        return sb.toString().trim();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}