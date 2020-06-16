//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的
//句子。 
//
// 说明： 
//
// 
// 分隔时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入:
//s = "catsanddog"
//wordDict = ["cat", "cats", "and", "sand", "dog"]
//输出:
//[
//  "cats and dog",
//  "cat sand dog"
//]
// 
//
// 示例 2： 
//
// 输入:
//s = "pineapplepenapple"
//wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
//输出:
//[
//  "pine apple pen apple",
//  "pineapple pen apple",
//  "pine applepen apple"
//]
//解释: 注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入:
//s = "catsandog"
//wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出:
//[]
// 
// Related Topics 动态规划 回溯算法


package leetcode.editor.cn;

import java.util.*;

//java:单词拆分 II
public class P140WordBreakIi {
    public static void main(String[] args) {
        Solution solution = new P140WordBreakIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. 记忆化递归回溯
        HashMap<Integer, List<String>> map = new HashMap<>();
        public List<String> wordBreak(String s, List<String> wordDict) {
            return word_Break(s, new HashSet(wordDict), 0);
        }

        public List<String> word_Break(String s, Set<String> wordDict, int start) {
            if (map.containsKey(start)) {
                return map.get(start);
            }
            LinkedList<String> res = new LinkedList<>();
            if (start == s.length()) {
                res.add("");
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDict.contains(s.substring(start, end))) {
                    List<String> list = word_Break(s, wordDict, end);
                    for (String l : list) {
                        res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                    }
                }
            }
            map.put(start, res);
            return res;
        }

//        //2. 动态规划
//        public List<String> wordBreak(String s, List<String> wordDict) {
//            LinkedList<String>[] dp = new LinkedList[s.length() + 1];
//            Set<String> wordDictset = new HashSet(wordDict);
//            LinkedList<String> initial = new LinkedList<>();
//            initial.add("");
//            dp[0] = initial;
//            for (int i = 1; i <= s.length(); i++) {
//                LinkedList<String> list = new LinkedList<>();
//                for (int j = 0; j < i; j++) {
//                    if (dp[j].size() > 0 && wordDictset.contains(s.substring(j, i))) {
//                        for (String l : dp[j]) {
//                            list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
//                        }
//                    }
//                }
//                dp[i] = list;
//            }
//            return dp[s.length()];
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}