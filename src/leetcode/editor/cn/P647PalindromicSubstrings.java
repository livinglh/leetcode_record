//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。 
//
// 示例 1: 
//
// 
//输入: "abc"
//输出: 3
//解释: 三个回文子串: "a", "b", "c".
// 
//
// 示例 2: 
//
// 
//输入: "aaa"
//输出: 6
//说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 注意: 
//
// 
// 输入的字符串长度不会超过1000。 
// 
// Related Topics 字符串 动态规划


package leetcode.editor.cn;

//java:回文子串
public class P647PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new P647PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
//        //1. 中心扩展法
//        public int countSubstrings(String S) {
//            int N = S.length(), ans = 0;
//            for (int center = 0; center <= 2*N-1; ++center) {
//                int left = center / 2;
//                int right = left + center % 2;
//                while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
//                    ans++;
//                    left--;
//                    right++;
//                }
//            }
//            return ans;
//        }

        //2. 动态规划法
        public int countSubstrings(String s) {
            boolean[][] dp = new boolean[s.length()][s.length()];
            int ans = 0;

            for (int j = 0; j < s.length(); j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }

            return ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}