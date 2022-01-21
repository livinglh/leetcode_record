//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。 
//
// 数值（按顺序）可以分成以下几个部分： 
//
// 
// 若干空格 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 若干空格 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分数值列举如下： 
//
// 
// ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"] 
// 
//
// 部分非数值列举如下： 
//
// 
// ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"] 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false 
//
// 示例 4： 
//
// 
//输入：s = "    .1  "
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。 
// 
// Related Topics 字符串 👍 275 👎 0


package leetcode.editor.cn;

// java: 表示数值的字符串
public class P剑指Offer20BiaoShiShuZhiDeZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer20BiaoShiShuZhiDeZiFuChuanLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }
            //标记是否遇到相应情况
            boolean numSeen = false;
            boolean dotSeen = false;
            boolean eSeen = false;
            char[] str = s.trim().toCharArray();
            for (int i = 0; i < str.length; i++) {
                if (str[i] >= '0' && str[i] <= '9') {
                    numSeen = true;
                } else if (str[i] == '.') {
                    //.之前不能出现.或者e
                    if (dotSeen || eSeen) {
                        return false;
                    }
                    dotSeen = true;
                } else if (str[i] == 'e' || str[i] == 'E') {
                    //e之前不能出现e，必须出现数
                    if (eSeen || numSeen == false) {
                        return false;
                    }
                    eSeen = true;
                    numSeen = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
                } else if (str[i] == '-' || str[i] == '+') {
                    //+-出现在0位置或者e/E的后面第一个位置才是合法的
                    if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                        return false;
                    }
                } else {//其他不合法字符
                    return false;
                }
            }
            return numSeen;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}