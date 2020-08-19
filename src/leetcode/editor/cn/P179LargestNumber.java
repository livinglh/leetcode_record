//给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: 210 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: 9534330 
//
// 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
// Related Topics 排序 
// 👍 355 👎 0

  
package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

//java:最大数
public class P179LargestNumber{
    public static void main(String[] args) {
        Solution solution = new P179LargestNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (o1, o2) -> {
            String res1 = o1 + o2;
            String res2 = o2 + o1;
            return res2.compareTo(res1);
        });

        if(str[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}