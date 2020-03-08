//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
//

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:和为s的连续正数序列
public class P面试题57IIHeWeiSdeLianXuZhengShuXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题57IIHeWeiSdeLianXuZhengShuXuLieLcof().new Solution();
        solution.findContinuousSequence(10);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 1;
        int sum = 1;
        List<int[]> ans = new ArrayList<>();
        while(right <= target/2 + 1){
            if(sum < target){
                right++;
                sum+=right;
            }else if(sum == target){
                int[] arr = new int[right-left+1];
                for (int i = left; i < right+1; i++) {
                    arr[i-left] = i;
                }
                ans.add(arr);
                sum -= left;
                left ++;
            }else{
                sum -= left;
                left ++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}