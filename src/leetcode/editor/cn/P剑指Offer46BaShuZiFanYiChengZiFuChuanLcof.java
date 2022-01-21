//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 345 👎 0


package leetcode.editor.cn;

// java: 把数字翻译成字符串
public class P剑指Offer46BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer46BaShuZiFanYiChengZiFuChuanLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {
            char[] chars = String.valueOf(num).toCharArray();
            if (chars.length == 0) {
                return 0;
            }
            int[] dp = new int[chars.length + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= chars.length; i++) {
                int val = Integer.parseInt(String.valueOf(num).substring(i - 2, i));
                if (val >= 10 && val <= 25) {
                    dp[i] = dp[i - 2] + dp[i - 1];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[chars.length];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}