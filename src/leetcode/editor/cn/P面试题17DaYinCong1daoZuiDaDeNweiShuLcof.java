//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数学

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//java:打印从1到最大的n位数
public class P面试题17DaYinCong1daoZuiDaDeNweiShuLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题17DaYinCong1daoZuiDaDeNweiShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    // 1.  简单解法
class Solution {
    public int[] printNumbers(int n) {
        int nums = (int)Math.pow(10,n);
        int[] ans = new int[nums-1];
        for(int i = 0; i < nums-1; i++){
            ans[i] = i+1;
        }
        return ans;
    }
}

    //2. 考虑大数


//leetcode submit region end(Prohibit modification and deletion)

}