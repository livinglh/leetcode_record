//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 108] 
// 
// Related Topics 数组 数学 
// 👍 104 👎 0

  
package leetcode.editor.cn;
//java:最大交换
public class P670MaximumSwap{
    public static void main(String[] args) {
        Solution solution = new P670MaximumSwap().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        char[] c = String.valueOf(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < c.length; i++) {
            last[c[i] - '0'] = i;
        }

        for (int i = 0; i < c.length; i++) {
            for (int j = 9; j > c[i] - '0'; j--) {
                if(last[j] > i){
                    char tmp = c[last[j]];
                    c[last[j]] = c[i];
                    c[i] = tmp;
                    return Integer.valueOf(new String(c));
                }
            }
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}