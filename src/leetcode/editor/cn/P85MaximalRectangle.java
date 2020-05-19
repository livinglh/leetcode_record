//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 示例: 
//
// 输入:
//[
//  ["1","0","1","0","0"],
//  ["1","0","1","1","1"],
//  ["1","1","1","1","1"],
//  ["1","0","0","1","0"]
//]
//输出: 6 
// Related Topics 栈 数组 哈希表 动态规划

  
package leetcode.editor.cn;

import java.util.Stack;

//java:最大矩形
public class P85MaximalRectangle{
    public static void main(String[] args) {
        Solution solution = new P85MaximalRectangle().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 1. 动态规划
    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') continue;
                int width = dp[i][j] = j >= 1 ? dp[i][j-1] + 1 : 1;
                for (int k = i; k >= 0; k--) {
                    width = Math.min(width, dp[k][j]);
                    max = Math.max(max, width * (i-k+1));
                }
            }
        }
        return max;
    }

    // 2. 单调栈 84题复用
//    public int maximalRectangle(char[][] matrix) {
//        int max = 0;
//        if(matrix.length == 0) return 0;
//        int[] heigths = new int[matrix[0].length];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                if(matrix[i][j] == '1'){
//                    heigths[j] += 1;
//                }
//                else{
//                    heigths[j] = 0;
//                }
//            }
//            max = Math.max(max, largestRectangleArea(heigths));
//        }
//        return max;
//    }
//
//    public int largestRectangleArea(int[] heights) {
//        int len = heights.length;
//        if(len == 0) return 0;
//        if(len == 1) return heights[0];
//        int[] newheights = new int[len+2]; //添加哨兵，避免弹栈为空，和遍历完成后栈中还有元素的情况
//        newheights[0] = 0;
//        System.arraycopy(heights, 0, newheights,1,len);
//        newheights[len+1] = 0;
//        len += 2;
//        Stack<Integer> stack = new Stack<>();
//
//        int maxArea = 0;
//        stack.push(0); //最左哨兵
//        for (int i = 1; i < len; i++) {
//            while(newheights[i] < newheights[stack.peek()]){
//                int heigth = newheights[stack.pop()];
//                int width = i - stack.peek() - 1;
//                maxArea = Math.max(maxArea, heigth * width);
//            }
//            stack.push(i);
//        }
//        return maxArea;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}