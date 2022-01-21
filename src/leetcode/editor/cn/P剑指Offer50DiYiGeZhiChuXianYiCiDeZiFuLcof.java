//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 170 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// java: 第一个只出现一次的字符
public class P剑指Offer50DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer50DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Character c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}