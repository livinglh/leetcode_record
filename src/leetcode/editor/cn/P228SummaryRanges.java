//给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。 
//
// 示例 1: 
//
// 输入: [0,1,2,4,5,7]
//输出: ["0->2","4->5","7"]
//解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。 
//
// 示例 2: 
//
// 输入: [0,2,3,4,6,8,9]
//输出: ["0","2->4","6","8->9"]
//解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。 
// Related Topics 数组 
// 👍 53 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:汇总区间
public class P228SummaryRanges{
    public static void main(String[] args) {
        Solution solution = new P228SummaryRanges().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums == null) return null;
        int len = nums.length;
        List<String> ans = new ArrayList<>();
        for (int left = 0, right = 0; right < len; right++) {
            if(right == len-1 || nums[right] + 1  != nums[right+1]){
                String str = String.valueOf(nums[left]) + (left == right ? "" : "->"+String.valueOf(nums[right]));
                ans.add(str);
                left = right + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}