//给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出: 
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2: 
//
// 输入: 
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出: 
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//] 
//
// 进阶: 
//
// 
// 一个直接的解决方案是使用 O(mn) 的额外空间，但这并不是一个好的解决方案。 
// 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。 
// 你能想出一个常数空间的解决方案吗？ 
// 
// Related Topics 数组

  
package leetcode.editor.cn;
//java:矩阵置零
public class P73SetMatrixZeroes{
    public static void main(String[] args) {
        Solution solution = new P73SetMatrixZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean iscol = false; //标记第一列是否需要置零
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if(matrix[i][0] == 0){
                iscol = true;
            }

            // 若matrix[i][j]为0，则将第i行第一个数置0，第j列第一个数置0，标记该行该列全都需要置零
            for (int j = 1; j < col; j++) {
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        //开始置零
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    System.out.println(i + " " + j);
                    matrix[i][j] = 0;
                }
            }
        }
        // 第一行
        if(matrix[0][0] == 0){
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        // 第一列
        if(iscol){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}