//给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。 
//
// 示例 1: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2: 
//
// 输入:
//[
//  [1, 2, 3, 4],
//  [5, 6, 7, 8],
//  [9,10,11,12]
//]
//输出: [1,2,3,4,8,12,11,10,9,5,6,7]
// 
// Related Topics 数组

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//java:螺旋矩阵
public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1;

        while(left <= right){
            // 从左往右
            for (int i = left; i <= right ; i++) {
                res.add(matrix[top][i]);
            }
            if(++top > bottom) break;
            // 从上到下
            for (int i = top; i <= bottom ; i++) {
                res.add(matrix[i][right]);
            }
            if(--right < left) break;
            // 从右向左
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            if(--bottom < top) break;
            // 从下往上
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if(++left > right) break;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}