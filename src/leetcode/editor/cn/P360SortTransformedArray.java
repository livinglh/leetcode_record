//给你一个已经 排好序 的整数数组 nums 和整数 a、b、c。对于数组中的每一个数 x，计算函数值 f(x) = ax2 + bx + c，请将函数值产生
//的数组返回。 
//
// 要注意，返回的这个数组必须按照 升序排列，并且我们所期望的解法时间复杂度为 O(n)。 
//
// 示例 1： 
//
// 输入: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
//输出: [3,9,15,33]
// 
//
// 示例 2： 
//
// 输入: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
//输出: [-23,-5,1,7]
// 
// Related Topics 数学 双指针 
// 👍 14 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//java:有序转化数组
public class P360SortTransformedArray{
    public static void main(String[] args) {
        Solution solution = new P360SortTransformedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(a == 0){
            for (int i = 0; i < len; i++) {
                ans.add(cmp(nums[i],a,b,c));
            }
            if(b < 0){
                Collections.reverse(ans);
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }

        double maixvalue = - b / (2.0 * a);
        int left = 0, right = 0;

        for (right = 0; right < len; right++) {
            if(nums[right] > maixvalue){
                break;
            }
        }
        left = right - 1;
        while(left >= 0 && right <= len-1){
            int x = maixvalue - nums[left] > nums[right] - maixvalue ? nums[right++] : nums[left--];
            ans.add(cmp(x,a,b,c));
        }
        while(left >= 0){
            ans.add(cmp(nums[left--],a,b,c));
        }
        while(right <= len -1){
            ans.add(cmp(nums[right++],a,b,c));
        }

        if(a < 0){
            Collections.reverse(ans);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public int cmp(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}