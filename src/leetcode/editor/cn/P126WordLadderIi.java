//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法

  
package leetcode.editor.cn;

import sun.plugin.javascript.navig.LinkArray;

import java.util.*;

//java:单词接龙 II
public class P126WordLadderIi{
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        Solution solution = new P126WordLadderIi().new Solution();
        solution.findLadders(beginWord,endWord,wordList);
    }
//leetcode submit region begin(Prohibit modification and deletion)
//    思路说明：在到达最短路径所在的层时，记录并输出所有符合条件的路径。
//
//    1.在单词接龙的基础上，需要将找到的最短路径存储下来；
//    2.之前的队列只用来存储每层的元素，那么现在就得存储每层添加元素之后的结果："ab","if",{"cd","af","ib","if"}；
//              （1）第一层：{"ab"}
//              （2）第二层：{"ab","af"}、{"ab","ib"}
//              （3）第三层：{"ab","af","if"}、{"ab","ib","if"}
//    3.如果该层添加的某一个单词符合目标单词，则该路径为最短路径，该层为最短路径所在的层，但此时不能直接返回结果，必须将该层遍历完，将该层所有符合的结果都添加进结果集；
//    4.每层添加单词的时候，不能直接添加到总的已访问单词集合中，需要每层有一个单独的该层访问的单词集，该层结束之后，再会合到总的已访问单词集合中，原因就是因为3.

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>(); //结果集
        Set<String> visited = new HashSet<>(); //记录访问过的字符串
        Queue<List<String>> queue = new LinkedList<>(); //队列
        List<String> li = new ArrayList<>();
        li.add(beginWord);
        queue.offer(li);
        boolean flag = false; //是否找到目标字符串，若找到，则不进行下一层搜索
        while(!queue.isEmpty() && !flag) {
            //该层已访问的字符串
            Set<String> subvisited = new HashSet<>();
            int size = queue.size();
            for (int i = 0; i < size ; i++) {
                List<String> path = queue.poll();
                String str = path.get(path.size()-1);
                //找到可以转换的字符
                char[] c_str = str.toCharArray();
                for (int j = 0; j < c_str.length; j++) {
                    char temp = c_str[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == temp) continue;
                        c_str[j] = ch;
                        String new_str = String.valueOf(c_str);
                        // 如果在wordlist中且未被访问过
                        if (wordSet.contains(new_str) && !visited.contains(new_str)) {
                            List<String> new_path = new ArrayList<>(path);
                            new_path.add(new_str);
                            if (new_str.equals(endWord)) {
                                flag = true;
                                ans.add(new_path);
                            }
                            queue.offer(new_path);
                            subvisited.add(new_str);
                        }
                    }
                    c_str[j] = temp;
                }
            }
            visited.addAll(subvisited);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}