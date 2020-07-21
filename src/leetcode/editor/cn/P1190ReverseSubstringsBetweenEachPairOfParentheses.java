//给出一个字符串 s（仅含有小写英文字母和括号）。 
//
// 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。 
//
// 注意，您的结果中 不应 包含任何括号。 
//
// 
//
// 示例 1： 
//
// 输入：s = "(abcd)"
//输出："dcba"
// 
//
// 示例 2： 
//
// 输入：s = "(u(love)i)"
//输出："iloveu"
// 
//
// 示例 3： 
//
// 输入：s = "(ed(et(oc))el)"
//输出："leetcode"
// 
//
// 示例 4： 
//
// 输入：s = "a(bcdefghijkl(mno)p)q"
//输出："apmnolkjihgfedcbq"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 2000 
// s 中只有小写英文字母和括号 
// 我们确保所有括号都是成对出现的 
// 
// Related Topics 栈 
// 👍 39 👎 0

  
package leetcode.editor.cn;

import java.util.Stack;

//java:反转每对括号间的子串
public class P1190ReverseSubstringsBetweenEachPairOfParentheses{
    public static void main(String[] args) {
        Solution solution = new P1190ReverseSubstringsBetweenEachPairOfParentheses().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public String reverseParentheses(String s) {

            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] == '(')
                    stack.push(i);

                if (arr[i] == ')')
                    reverse(arr, stack.pop() + 1, i - 1);
            }

            for (int i = 0; i < arr.length; i++)
                if (arr[i] != ')' && arr[i] != '(')
                    sb.append(arr[i]);

            return sb.toString();
        }

        public void reverse(char[] arr, int left, int right) {

            while (right > left) {
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                right--;
                left++;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}