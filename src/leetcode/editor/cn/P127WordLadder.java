//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索

  
package leetcode.editor.cn;

import java.util.*;

//java:单词接龙
public class P127WordLadder{
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        Solution solution = new P127WordLadder().new Solution();
        solution.ladderLength(beginWord,endWord,wordList);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 0;
        while(!queue.isEmpty()){
            count ++;
            int size = queue.size();
            while(size-- > 0) {
                String str = queue.poll();
                for (int j = 0; j < wordList.size(); j++) {
                    if(visited[j]) continue;
                    String s = wordList.get(j);
                    if(!can_go(str,s)) continue;
                    if(s.equals(endWord)) return count+1;
                    queue.add(wordList.get(j));
                    visited[j] = true;
                }
            }
        }
        return 0;
    }
    public boolean can_go(String s1,String  s2){
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}
//双端BFS
//class Solution {
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        HashSet<String> start = new HashSet<>();
//        start.add(beginWord);
//        HashSet<String> end = new HashSet<>();
//        end.add(endWord);
//        HashSet<String> words = new HashSet<>(wordList);
//        if (!words.contains(endWord)) {
//            return 0;
//        }
//
//        return deBfs(start,end,words,2);
//    }
//    private int deBfs(HashSet<String> start, HashSet<String> end, HashSet<String> words, int depth) {
//
//        if (start.size() > end.size()) {
//            return deBfs(end, start, words, depth);
//        }
//        words.removeAll(start);
//        HashSet<String> next = new HashSet<>();
//        for (String str : start) {
//            char[] chars = str.toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                char temp = chars[i];
//                for (char j = 'a'; j <= 'z'; j++) {
//                    chars[i] = j;
//                    String word = new String(chars);
//                    if (words.contains(word)) {
//                        if (end.contains(word)) {
//                            return depth;
//                        }
//                        next.add(word);
//                    }
//                }
//                chars[i] = temp;
//            }
//        }
//        if (start.isEmpty()) {
//            return 0;
//        }
//        return deBfs(next, end, words, depth + 1);
//
//    }
//}


//leetcode submit region end(Prohibit modification and deletion)

}