//给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。 
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//java:最小覆盖子串
public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        solution.minWindow(s,t);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0){
            return "";
        }
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> windowsmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i),count+1);
        }
        int left = 0,right = 0;
        int match = 0;
        int[] ans = {-1,0,0}; //windows_length,left,right
        while(right < s.length()){
            char c = s.charAt(right);
            int count = windowsmap.getOrDefault(c, 0);
            windowsmap.put(c, count + 1);
            // .intValue() 必须加上，否则解答出错
            // 使用 new Integer() 创建的对象，使用 Integer.valueOf() 创建的对象，使用基本类型赋值创建的对象
            // 不能随便使用“==”来比较大小，但可以使用“<”、“>”、“<=”、“>=”来做大小比较。
            if(map.containsKey(c) && windowsmap.get(c).intValue() == map.get(c).intValue()){
                match++;
            }
            while(match == map.size()){
                c = s.charAt(left);
                if (ans[0] == -1 || ans[0] > right-left+1) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                left++;
                windowsmap.put(c,windowsmap.get(c)-1);
                if(map.containsKey(c) && windowsmap.get(c).intValue() < map.get(c).intValue()){
                    match--;
                }
            }
            right++;
        }
        return ans[0] == -1 ? "":s.substring(ans[1],ans[2]+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}