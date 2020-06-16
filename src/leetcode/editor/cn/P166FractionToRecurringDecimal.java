//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 示例 1: 
//
// 输入: numerator = 1, denominator = 2
//输出: "0.5"
// 
//
// 示例 2: 
//
// 输入: numerator = 2, denominator = 1
//输出: "2" 
//
// 示例 3: 
//
// 输入: numerator = 2, denominator = 3
//输出: "0.(6)"
// 
// Related Topics 哈希表 数学

  
package leetcode.editor.cn;

import java.util.HashMap;

//java:分数到小数
public class P166FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new P166FractionToRecurringDecimal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long num = numerator;
        long den = denominator;
        String sign = "";
        //确定符号
        if (num > 0 && den < 0 || num < 0 && den > 0) {
            sign = "-";
        }
        //转为正数
        num = Math.abs(num);
        den = Math.abs(den);
        //记录整数部分
        long integer = num / den;
        //计算余数
        num = num - integer * den;
        HashMap<Long, Integer> map = new HashMap<>();
        int index = 0;
        String decimal = "";//记录小数部分
        int repeatIndex = -1;//保存重复的位置
        while (num != 0) {
            num *= 10;//余数乘以 10 作为新的被除数
            if (map.containsKey(num)) {
                repeatIndex = map.get(num);
                break;
            }
            //保存被除数
            map.put(num, index);
            //保存当前的商
            long decimalPlace = num / den;
            //加到所有的商中
            decimal = decimal + decimalPlace;
            //计算新的余数
            num = num - decimalPlace * den;
            index++;
        }
        //是否存在循环小数
        if (repeatIndex != -1) {
            String dec = decimal;
            return sign + integer + "." + dec.substring(0, repeatIndex) + "(" + dec.substring(repeatIndex) + ")";
        } else {
            if (decimal == "") {
                return sign + integer;
            } else {
                return sign + integer + "." + decimal;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}