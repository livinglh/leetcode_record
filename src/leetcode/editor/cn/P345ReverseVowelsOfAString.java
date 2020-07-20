//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 示例 1: 
//
// 输入: "hello"
//输出: "holle"
// 
//
// 示例 2: 
//
// 输入: "leetcode"
//输出: "leotcede" 
//
// 说明: 
//元音字母不包含字母"y"。 
// Related Topics 双指针 字符串 
// 👍 101 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//java:反转字符串中的元音字母
public class P345ReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new P345ReverseVowelsOfAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int left = 0, right = len - 1;
        Character[] Y = new Character[]{'a','e','i','o','u','A','E','I','O','U'};
        Set<Character> set = new HashSet<>(Arrays.asList(Y));
        while(left < right){
            while(left < right && !set.contains(c[left])) left++;
            while(left < right && !set.contains(c[right])) right--;
//            System.out.println(left + " " + right);
            char temp = c[left];
            c[left++] = c[right];
            c[right--] = temp;
        }
        return String.valueOf(c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}