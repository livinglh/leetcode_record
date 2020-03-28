//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
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
// Related Topics 哈希表 双指针 字符串 Sliding Window

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//java:无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        //1.使用HashSet
//        int n = s.length();
//        Set<Character> set = new HashSet<>();
//        int ans = 0,i = 0,j = 0;
//        while(i < n && j < n){
//            if(!set.contains(s.charAt(j))){
//                set.add(s.charAt(j++));
//                ans = Math.max(ans,j-i);
//            }else{
//                set.remove(s.charAt(i++));
//            }
//        }
//        return ans;
        //2.使用HashMap
//        int n = s.length(),ans = 0;
//        Map<Character,Integer> map = new HashMap<>();
//        for (int j = 0,i = 0; j < n; j++) {
//            if(map.containsKey(s.charAt(j))){
//                i = Math.max(map.get(s.charAt(j)),i);
//            }
//            map.put(s.charAt(j),j+1);
//            ans = Math.max(ans,j-i+1);
//        }
//        return ans;
        //3. 动态规划
        if(s.equals("")) return 0;
        int len = s.length();
        //dp(i)为以第i个字符为结尾的不包含重复字符的子字符串的最长长度
        int[] dp = new int[len];
        dp[0] = 1;
        for(int i = 1;i < len;i++){
            char cur = s.charAt(i);
            String subStr = s.substring(0,i);
            if(!subStr.contains(cur+"")){
                dp[i] = dp[i-1] + 1;
            }else{
                int d = subStr.length() - subStr.lastIndexOf(cur) ;//距离
                if(d <= dp[i -1]) dp[i] = d;
                else dp[i] = dp[i - 1] + 1;
            }
        }
        int max = 0;
        for(int i : dp){
            max = Math.max(max,i);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}