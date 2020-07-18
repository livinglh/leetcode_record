//给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。 
//
// 示例 1: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出: false 
// Related Topics 字符串 动态规划 
// 👍 220 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:交错字符串
public class P97InterleavingString {
    public static void main(String[] args) {
        Solution solution = new P97InterleavingString().new Solution();
        solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //一：超时
//    Map<String,Boolean> map = new HashMap<>();
//    public boolean isInterleave(String s1, String s2, String s3) {
//        String str = new StringBuilder().append(s1).append("@").append(s2).append("@").append(s3).toString();
//        if(map.containsKey(str)) return map.get(str);
//        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0){
//            map.put(str, true);
//            return true;
//        }
//        if(s3.length() == 0 && (s1.length() != 0 || s2.length() != 0)) {
//            map.put(str, false);
//            return false;
//        }
//        char c = s3.charAt(0);
//        char cs1 = s1.length() == 0? ' ' : s1.charAt(0);
//        char cs2 = s2.length() == 0? ' ' : s2.charAt(0);
//        if(cs1!=c && cs2!=c){
//            map.put(str, false);
//            return false;
//        }else if(cs1 == c && cs2 != c){
//            return isInterleave(s1.substring(1), s2, s3.substring(1));
//        }else if(cs1 != c && cs2 == c){
//            return isInterleave(s1, s2.substring(1), s3.substring(1));
//        }else{
//            return isInterleave(s1, s2.substring(1), s3.substring(1)) || isInterleave(s1.substring(1), s2, s3.substring(1));
//        }
//    }
        // 二： DFS
//        public boolean isInterleave(String s1, String s2, String s3) {
//            HashMap<String, Integer> memoization = new HashMap<>();
//            return getAns(s1, 0, s2, 0, s3, 0, memoization);
//        }
//
//        private boolean getAns(String s1, int i, String s2, int j, String s3, int k, HashMap<String, Integer> memoization) {
//            if (s1.length() + s2.length() != s3.length()) {
//                return false;
//            }
//            String key = i + "@" + j;
//            if (memoization.containsKey(key)) {
//                return memoization.getOrDefault(key, -1) == 1;
//            }
//            if (i == s1.length() && j == s2.length() && k == s3.length()) {
//                memoization.put(key, 1);
//                return true;
//            }
//            if (i == s1.length()) {
//                while (j < s2.length()) {
//                    if (s2.charAt(j) != s3.charAt(k)) {
//                        memoization.put(key, 0);
//                        return false;
//                    }
//                    j++;
//                    k++;
//                }
//                memoization.put(key, 1);
//                return true;
//            }
//
//            if (j == s2.length()) {
//                while (i < s1.length()) {
//                    if (s1.charAt(i) != s3.charAt(k)) {
//                        memoization.put(key, 0);
//                        return false;
//                    }
//                    i++;
//                    k++;
//                }
//                memoization.put(key, 1);
//                return true;
//            }
//            if (s1.charAt(i) == s3.charAt(k)) {
//                if (getAns(s1, i + 1, s2, j, s3, k + 1, memoization)) {
//                    memoization.put(key, 1);
//                    return true;
//                }
//            }
//            if (s2.charAt(j) == s3.charAt(k)) {
//                if (getAns(s1, i, s2, j + 1, s3, k + 1, memoization)) {
//                    memoization.put(key, 1);
//                    return true;
//                }
//            }
//            memoization.put(key, 0);
//            return false;
//        }
        // 三：动态规划
        // 定义一个 boolean 二维数组 dp [ i ] [ j ] 来表示 s1[ 0, i ) 和 s2 [ 0, j ） 组合后能否构成 s3 [ 0, i + j )，注意不包括右边界，主要是为了考虑开始的时候如果只取 s1，那么 s2 就是空串，这样的话 dp [ i ] [ 0 ] 就能表示 s2 取空串
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length(), n = s2.length();
            if (m + n != s3.length()) {
                return false;
            }
            boolean[][] dp = new boolean[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
                    } else {
                        dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                                || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                    }
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}