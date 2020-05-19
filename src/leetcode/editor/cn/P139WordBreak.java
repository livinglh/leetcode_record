//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划

  
package leetcode.editor.cn;

import java.util.*;

//java:单词拆分
public class P139WordBreak{
    public static void main(String[] args) {
        Solution solution = new P139WordBreak().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        //1. 递归回溯  备忘录
//        public boolean wordBreak(String s, List<String> wordDict) {
//            return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
//        }
//        public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
//            if (start == s.length()) {
//                return true;
//            }
//            if(memo[start] != null){
//                return memo[start];
//            }
//            for (int end = start + 1; end <= s.length(); end++) {
//                if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
//                    memo[start] = true;
//                    return true;
//                }
//            }
//            memo[start] = false;
//            return false;
//        }
        //2. 动态规划
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet=new HashSet(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
        //3. BFS
//        public boolean wordBreak(String s, List<String> wordDict) {
//            Set<String> wordDictSet=new HashSet(wordDict);
//            Queue<Integer> queue = new LinkedList<>();
//            int[] visited = new int[s.length()];
//            queue.add(0);
//            while (!queue.isEmpty()) {
//                int start = queue.remove();
//                if (visited[start] == 0) {
//                    for (int end = start + 1; end <= s.length(); end++) {
//                        if (wordDictSet.contains(s.substring(start, end))) {
//                            queue.add(end);
//                            if (end == s.length()) {
//                                return true;
//                            }
//                        }
//                    }
//                    visited[start] = 1;
//                }
//            }
//            return false;
//        }
}
//leetcode submit region end(Prohibit modification and deletion)

}