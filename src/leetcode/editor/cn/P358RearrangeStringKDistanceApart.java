//给你一个非空的字符串 s 和一个整数 k，你要将这个字符串中的字母进行重新排列，使得重排后的字符串中相同字母的位置间隔距离至少为 k。 
//
// 所有输入的字符串都由小写字母组成，如果找不到距离至少为 k 的重排结果，请返回一个空字符串 ""。 
//
// 示例 1： 
//
// 输入: s = "aabbcc", k = 3
//输出: "abcabc" 
//解释: 相同的字母在新的字符串中间隔至少 3 个单位距离。
// 
//
// 示例 2: 
//
// 输入: s = "aaabc", k = 3
//输出: "" 
//解释: 没有办法找到可能的重排结果。
// 
//
// 示例 3: 
//
// 输入: s = "aaadbbcc", k = 2
//输出: "abacabcd"
//解释: 相同的字母在新的字符串中间隔至少 2 个单位距离。
// 
// Related Topics 堆 贪心算法 哈希表 
// 👍 28 👎 0

  
package leetcode.editor.cn;

import java.util.*;

//java:K 距离间隔重排字符串
public class P358RearrangeStringKDistanceApart{
    public static void main(String[] args) {
        Solution solution = new P358RearrangeStringKDistanceApart().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String rearrangeString(String s, int k) {
        if(k <= 1){
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Character cha : s.toCharArray()){
            map.put(cha, map.getOrDefault(cha, 0) + 1);
        }
        maxHeap.addAll(map.entrySet());
        StringBuilder result = new StringBuilder(s.length());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            result.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            queue.offer(currentEntry);
            if (queue.size() == k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0){
                    maxHeap.add(entry);
                }
            }
        }
        return result.length() == s.length() ? result.toString() : "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}