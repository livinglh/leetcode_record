//给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。 
//
// 
//
// 示例 1： 
//
// 输入：[-4,-1,0,3,10]
//输出：[0,1,9,16,100]
// 
//
// 示例 2： 
//
// 输入：[-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 10000 
// -10000 <= A[i] <= 10000 
// A 已按非递减顺序排序。 
// 
// Related Topics 数组 双指针 
// 👍 102 👎 0

  
package leetcode.editor.cn;

import com.sun.scenario.animation.shared.ClipEnvelope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//java:有序数组的平方
public class P977SquaresOfASortedArray{
    public static void main(String[] args) {
        Solution solution = new P977SquaresOfASortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int left = 0, right = len-1;   //最大值肯定在两边，从两边向中间计算
        int leftvalue = 0, rightvalue = 0;
        int[] ans = new int[A.length];
        int index = A.length - 1;
        while(left <= right){
            leftvalue = A[left] * A[left];
            rightvalue = A[right] * A[right];
            if(leftvalue > rightvalue){
                ans[index--] = leftvalue;
                left++;
            }else{
                ans[index--] = rightvalue;
                right--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}