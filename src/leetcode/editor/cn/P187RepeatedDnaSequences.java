//所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究
//非常有帮助。 
//
// 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。 
//
// 
//
// 示例： 
//
// 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC", "CCCCCAAAAA"] 
// Related Topics 位运算 哈希表

  
package leetcode.editor.cn;

import java.util.*;

//java:重复的DNA序列
public class P187RepeatedDnaSequences{
    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        Solution solution = new P187RepeatedDnaSequences().new Solution();
        List<String> reslut = new ArrayList<>();
        reslut = solution.findRepeatedDnaSequences(str);
        System.out.println(reslut);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        //1.暴力枚举 HashMap
//        int n = s.length();
//        Set<String> set = new HashSet<>();
//        Set<String> result = new HashSet<>();
//        for (int i = 0; i + 10 <= n; i++) {
//            String key = s.substring(i,i+10);
//            if (set.contains(key)){
//                result.add(key);
//            }else {
//                set.add(key);
//            }
//        }
//        return new ArrayList<>(result);
        //2.将字符串转换为二进制数组
        int n = s.length();
        if(n == 0 || n < 10){
            return new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        Set<String> result = new HashSet<>();
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        char[] array = s.toCharArray();
        int key = 0;
        for (int i = 0; i < 10; i++) {
            key = key << 2 | map[array[i] - 'A'];
        }
        set.add(key);
        for (int i = 10; i < n; i++) {
            key = key << 2 | map[array[i] - 'A'];
            key &= 0xfffff;
            if(set.contains(key)){
                result.add(s.substring(i-9,i+1));
            }else{
                set.add(key);
            }
        }
        return new ArrayList<>(result);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}