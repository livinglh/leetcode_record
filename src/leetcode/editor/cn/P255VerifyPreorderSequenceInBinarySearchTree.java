//给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。 
//
// 你可以假定该序列中的数都是不相同的。 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [5,2,6,1,3]
//输出: false 
//
// 示例 2： 
//
// 输入: [5,2,1,3,6]
//输出: true 
//
// 进阶挑战： 
//
// 您能否使用恒定的空间复杂度来完成此题？ 
// Related Topics 栈 树 
// 👍 43 👎 0


package leetcode.editor.cn;

import java.util.Stack;

//java:验证前序遍历序列二叉搜索树
public class P255VerifyPreorderSequenceInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P255VerifyPreorderSequenceInBinarySearchTree().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean verifyPreorder(int[] preorder) {
            if (preorder.length == 0) {
                return true;
            }
            Stack<Integer> stack = new Stack<>();
            int currentMaxValue = Integer.MIN_VALUE;
            for (int value : preorder) {
                if (value < currentMaxValue) {
                    return false;
                }
                /// 找到最后一个比 val 小的元素，这个值即为 val 的根节点，同时记录该根节点值，后面的值不能比该值小
                while (!stack.isEmpty() && value > stack.peek()) {
                    currentMaxValue = stack.pop();
                }
                stack.push(value);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}