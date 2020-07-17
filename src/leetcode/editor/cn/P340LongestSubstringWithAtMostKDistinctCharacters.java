//给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。 
//
// 示例 1: 
//
// 输入: s = "eceba", k = 2
//输出: 3
//解释: 则 T 为 "ece"，所以长度为 3。 
//
// 示例 2: 
//
// 输入: s = "aa", k = 1
//输出: 2
//解释: 则 T 为 "aa"，所以长度为 2。
// 
// Related Topics 哈希表 字符串 Sliding Window 
// 👍 47 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:至多包含 K 个不同字符的最长子串
public class P340LongestSubstringWithAtMostKDistinctCharacters{
    public static void main(String[] args) {
        Solution solution = new P340LongestSubstringWithAtMostKDistinctCharacters().new Solution();
        solution.lengthOfLongestSubstringKDistinct("aa",1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int ans = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            int count = map.getOrDefault(s.charAt(right),0);
            map.put(s.charAt(right), count+1);
            while(map.size() > k){
                int popcount = map.get(s.charAt(left)) - 1;
                map.put(s.charAt(left), popcount);
                if(popcount == 0) map.remove(s.charAt(left));
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}