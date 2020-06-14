//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划

  
package leetcode.editor.cn;
//java:解码方法
public class P91DecodeWays{
    public static void main(String[] args) {
        Solution solution = new P91DecodeWays().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDecodings(String s) {
        //1. 直接递归 超时
//        if(s.length() == 0) return 1;
//        if(s.charAt(0) == '0') return 0;
//        if(s.length() == 1) return 1;
//        int curtwo = Integer.parseInt(s.substring(0,2));
//        System.out.println(curtwo);
//        if(curtwo <= 26){
//            return numDecodings(s.substring(1)) + numDecodings(s.substring(2));
//        }
//        else{
//            return numDecodings(s.substring(1));
//        }

        //2. 动态规划
        int len = s.length();
        if(len == 0) return 0;
        int[] dp = new int[len+1];
        if(s.charAt(0) == '0') return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int curtwo = Integer.parseInt(s.substring(i-2,i));
            if(curtwo <= 26 && curtwo > 0 && s.charAt(i - 2) != '0'){
                dp[i] += dp[i-2];
            }
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
        }
        return dp[len];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}