//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//java:找到字符串中所有字母异位词
public class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        solution.findAnagrams("cbaebabacd","abc");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 双指针
        if(s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length(); //用total检测窗口中是否已经涵盖了p中的字符
        for(char ch : p.toCharArray()){
            needs[ch - 'a'] ++;
        }
        while(right < s.length()){
            char chr = s.charAt(right);
            if(needs[chr - 'a'] > 0){
                window[chr - 'a'] ++;
                if(window[chr - 'a'] <= needs[chr - 'a']){
                    total --;
                }
            }
            while(total == 0){
                if(right-left+1 == p.length()){
                    res.add(left);
                }
                char chl = s.charAt(left);
                if(needs[chl - 'a'] > 0){
                    window[chl - 'a'] --;
                    if(window[chl - 'a'] < needs[chl - 'a']){
                        total ++;
                    }
                }
                left ++;
            }
            right ++;
        }
        return res;




//        List<Integer> ans = new ArrayList<>();
//        if (s==null || s.length() == 0 || p == null || p.length() == 0)
//            return ans;
//
//        int plen = p.length();
//
//        Map<Character,Integer> pmap = new HashMap<>();
//        char[] ch = p.toCharArray();
//        for(char c : ch){
//            pmap.put(c, pmap.getOrDefault(c,0)+1);
//        }
//        Map<Character,Integer> smap = new HashMap<>();
//        char[] chs = s.toCharArray();
//        for (int i = 0; i < chs.length; i++) {
//            if(i < plen-1) {
//                smap.put(chs[i], smap.getOrDefault(chs[i], 0) + 1);
//            }else if(i == plen -1){
//                smap.put(chs[i], smap.getOrDefault(chs[i],0)+1);
//                if(pmap.equals(smap)){
//                    ans.add(i-plen+1);
//                }
//            }else{
//                smap.put(chs[i-plen], smap.getOrDefault(chs[i-plen],0)-1);
//                smap.put(chs[i], smap.getOrDefault(chs[i],0)+1);
//                boolean bl = true;
//                for(Character c : pmap.keySet()){
//                    if(pmap.get(c) != smap.getOrDefault(c, 0)){
//                        bl = false;
//                        break;
//                    }
//                }
//                if(bl == true) ans.add((i-plen+1));
//            }
//        }
//        return ans;
     }
}
//leetcode submit region end(Prohibit modification and deletion)

}