//给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 
//
// 注意: 
//
// 
// num 的长度小于 10002 且 ≥ k。 
// num 不会包含任何前导零。 
// 
//
// 示例 1 : 
//
// 
//输入: num = "1432219", k = 3
//输出: "1219"
//解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
// 
//
// 示例 2 : 
//
// 
//输入: num = "10200", k = 1
//输出: "200"
//解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 : 
//
// 
//输入: num = "10", k = 2
//输出: "0"
//解释: 从原数字移除所有的数字，剩余为空就是0。
// 
// Related Topics 栈 贪心算法 
// 👍 288 👎 0

  
package leetcode.editor.cn;

import java.util.LinkedList;

//java:移掉K位数字
public class P402RemoveKDigits{
    public static void main(String[] args) {
        Solution solution = new P402RemoveKDigits().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        char[] re = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            while (index != 0 && k != 0 && re[index-1] > num.charAt(i)) {
                k--;
                index--;
            }
            re[index++] = num.charAt(i);
        }

        int num0 = 0;
        for (int i = 0; i < index; i++) {
            if(re[i] == '0'){
                num0 ++;
            }else{
                break;
            }
        }

        if(index - num0 > k){
            return new String(re, num0, index-num0-k);
        }else{
            return "0";
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}