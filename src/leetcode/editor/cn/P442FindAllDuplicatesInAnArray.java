//给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。 
//
// 找到所有出现两次的元素。 
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？ 
//
// 示例： 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
// 
// Related Topics 数组 
// 👍 256 👎 0

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:数组中重复的数据
public class P442FindAllDuplicatesInAnArray{
    public static void main(String[] args) {
        Solution solution = new P442FindAllDuplicatesInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0){
                res.add(Math.abs(index+1));
            }
            else{
                nums[index] = -nums[index];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}