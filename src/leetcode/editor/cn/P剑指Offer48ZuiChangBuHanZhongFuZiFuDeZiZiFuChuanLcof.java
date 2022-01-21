//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。 
//
// 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// s.length <= 40000 
// 
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 343 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// java: 最长不含重复字符的子字符串
public class P剑指Offer48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer48ZuiChangBuHanZhongFuZiFuDeZiZiFuChuanLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
//        Set<Character> set = new HashSet<>();
//        int left = 0, right = 0, res = 0;
//        while (right < s.length()) {
//            char c = s.charAt(right);
//            while (set.contains(c)) {
//                set.remove(s.charAt(left++));
//            }
//            set.add(c);
//            right++;
//            res = Math.max(res, right - left);
//        }
//        return res;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c));
            }
            map.put(c, j + 1);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}