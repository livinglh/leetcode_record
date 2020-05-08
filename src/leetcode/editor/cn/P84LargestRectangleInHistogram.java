//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组

  
package leetcode.editor.cn;

import java.util.Stack;

//java:柱状图中最大的矩形
public class P84LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();

        int[] heights = {2, 1, 5, 6, 2, 3};
        solution.largestRectangleArea(heights);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if(len == 0) return 0;
        if(len == 1) return heights[0];
        int[] newheights = new int[len+2]; //添加哨兵，避免弹栈为空，和遍历完成后栈中还有元素的情况
        newheights[0] = 0;
        System.arraycopy(heights, 0, newheights,1,len);
        newheights[len+1] = 0;
        len += 2;
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        stack.push(0); //最左哨兵
        for (int i = 1; i < len; i++) {
            while(newheights[i] < newheights[stack.peek()]){
                int heigth = newheights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, heigth * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}