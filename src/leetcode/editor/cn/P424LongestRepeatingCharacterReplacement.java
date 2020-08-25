//给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
// 
//
// 注意: 
//字符串长度 和 k 不会超过 104。 
//
// 示例 1: 
//
// 输入:
//s = "ABAB", k = 2
//
//输出:
//4
//
//解释:
//用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2: 
//
// 输入:
//s = "AABABBA", k = 1
//
//输出:
//4
//
//解释:
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
// Related Topics 双指针 Sliding Window 
// 👍 151 👎 0

  
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//java:替换后的最长重复字符
public class P424LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
        Solution solution = new P424LongestRepeatingCharacterReplacement().new Solution();
        solution.characterReplacement("AABABBA", 1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
//        char[] ch = s.toCharArray();
//        int n = s.length();
//        Set<Character> set = new HashSet<>(); //存其中不同的字母
//        for (int i = 0; i < s.length(); i++) {
//            if(!set.contains(ch[i])){
//                set.add(ch[i]);
//            }
//        }
//        int ans = 0;
//        for(char c : set){
//            int left = 0, right = 0, curuse = 0;
//            while(left < n && right < n){
//                if(ch[right] == c){
//                    right++;
//                }else{
//                    if(curuse < k){
//                        curuse++;
//                        right++;
//                    }else{
//                        ans = Math.max(right - left, ans);
//                        if(ch[left] != c){
//                            curuse--;
//                        }
//                        left++;
//                    }
//                }
//            }
//            ans = Math.max(right - left, ans);
//        }
//        return ans;

        int[] map = new int[26];
        if(s == null){
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0, right = 0, historyCharMax = 0;
        for(right = 0; right < chars.length; right ++){
            int index = chars[right] - 'A';
            map[index] ++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if(right - left + 1 > historyCharMax + k){
                map[chars[left] - 'A'] --;
                left++;
            }
        }
        return chars.length-left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}