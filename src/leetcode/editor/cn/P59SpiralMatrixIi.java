//给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。 
//
// 示例: 
//
// 输入: 3
//输出:
//[
// [ 1, 2, 3 ],
// [ 8, 9, 4 ],
// [ 7, 6, 5 ]
//] 
// Related Topics 数组 
// 👍 225 👎 0

  
package leetcode.editor.cn;
//java:螺旋矩阵 II
public class P59SpiralMatrixIi{
    public static void main(String[] args) {
        Solution solution = new P59SpiralMatrixIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int index = 0;
        int left = 0, right = n - 1, top = 0, down = n - 1;
        while(true){
            for (int i = left; i <= right; i++) {
                index ++;
                ans[top][i] = index;
            }
            if(++top > down) break;
            for (int i = top; i <= down; i++) {
                index ++;
                ans[i][right] = index;
            }
            if(left > --right) break;
            for (int i = right; i >= left; i--) {
                index ++;
                ans[down][i] = index;
            }
            if(top > --down) break;
            for (int i = down; i >= top; i--) {
                index ++;
                ans[i][left] = index;
            }
            if(++left > right) break;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}