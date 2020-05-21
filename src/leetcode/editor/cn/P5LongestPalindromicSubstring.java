//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划

  
package leetcode.editor.cn;
//java:最长回文子串 中心扩展法 动态规划
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        solution.longestPalindrome("cbbd");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            //法1 中心扩展
//            if(s == null ||s.length() == 0) return "";
//            int l = 0, r = 0;
//            for (int i = 0; i < s.length(); i++) {
//                int len1 = help(s,i,i);
//                int len2 = help(s,i,i+1);
//                int max = Math.max(len1,len2);
//                if(r - l<max){
//                    l = i - (max-1)/2;
//                    r = i + max/2;
//                }
//            }
//            return s.substring(l,r+1);
            // 法2 动态规划 逆序后 求最长公共子串 判断是否回文
//            if(s.equals("")) return "";
//            String rs = new StringBuffer(s).reverse().toString();
//            int[][] dp = new int[s.length()][s.length()];
//            int maxlen = 0, maxend = 0;
//            for(int i = 0; i < s.length(); i++){
//                for (int j = 0; j < rs.length(); j++) {
//                    if(s.charAt(i) == rs.charAt(j)){
//                        if(i == 0 || j == 0){
//                            dp[i][j] = 1;
//                        }else{
//                            dp[i][j] = dp[i-1][j-1]+1;
//                        }
//                        if(maxlen < dp[i][j]){
//                            int prestart = s.length() - 1- j;
//                            if(prestart + dp[i][j] - 1 == i){
//                                maxlen = dp[i][j];
//                                maxend = i;
//                            }
//                        }
//                    }
//                }
//            }
//            return s.substring(maxend-maxlen+1,maxend+1);
            //动态规划 dp(i,j) 表示字符串  的第 i 到 j 个字母组成的串是否是回文子串
            if(s == null ||s.length() == 0) return "";
            int n = s.length();
            boolean[][] dp = new boolean[s.length()][s.length()];
            int res = 0, resi = 0, resj = 0;
            for (int j = 0; j < n; j++) {
                for (int i = 0; i <= j; i++) {
                    if(s.charAt(i) == s.charAt(j) && (j - i < 2 ||  dp[i+1][j-1])){
                        dp[i][j] = true;
                        if(j-i+1 > res){
                            res = j-i+1;
                            resi = i;
                            resj = j;
                        }
                    }
                }
            }
            return s.substring(resi,resj+1);
        }
        public int help(String s, int l, int r){
            while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            return r-l-1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}