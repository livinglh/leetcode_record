//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串


package leetcode.editor.cn;

//java:验证回文串
public class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            if (s.isEmpty())
                return true;//特殊判断
            int left = 0, right = s.length() - 1;//左指针从左边开始，右指针从右边开始
            while (left < right) {//直到左右指针相遇，我们才遍历完所有字符
                while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                    left++;//跳过不相关字符
                while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                    right--;//跳过不相关字符
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))//只要有一次不相等，就返回false
                    return false;
                left++;//相等的话，就移动两个指针，向下一对字符靠近。
                right--;
            }
            return true;//遍历完成都没有返回false，就说明这是个回文串，就返回true；
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}