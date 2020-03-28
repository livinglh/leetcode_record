//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表

  
package leetcode.editor.cn;

import java.util.HashMap;

//java:第一个只出现一次的字符
public class P面试题50DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题50DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        // 暴力搜索
//        if(s == "") return ' ';
//        char ans = ' ';
//        for (int i = 0; i < s.length(); i++) {
//            boolean flag = false;
//            for (int j = 0; j < s.length(); j++) {
//                if(i==j) continue;
//                if(s.charAt(i) == s.charAt(j)){
//                    flag = true;
//                    break;
//                }
//            }
//            if(flag == false) return s.charAt(i);
//        }
//        return ans;
        // 哈希表
//        HashMap<Character, Integer> dic = new HashMap<>();
//        char[] sc = s.toCharArray();
//        for(char c : sc) {
//            if(!dic.containsKey(c)) dic.put(c, 1);
//            else dic.put(c, dic.get(c) + 1);
//        }
//        for(char c : sc) {
//            if(dic.get(c) == 1) return c;
//        }
//        return ' ';
        // 数组
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        for(char c : s.toCharArray()){
            if(count[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}