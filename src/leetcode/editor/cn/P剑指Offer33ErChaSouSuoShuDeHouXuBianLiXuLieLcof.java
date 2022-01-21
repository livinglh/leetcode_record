//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
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
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 409 👎 0


package leetcode.editor.cn;

// java: 二叉搜索树的后序遍历序列
public class P剑指Offer33ErChaSouSuoShuDeHouXuBianLiXuLieLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer33ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[] postorder;

        public boolean verifyPostorder(int[] postorder) {
            this.postorder = postorder;
            return recur(0, postorder.length - 1);
        }

        public boolean recur(int left, int right) {
            if (left >= right) {
                return true;
            }
            int root = postorder[right];
            int index = -1;
            for (int i = left; i <= right; i++) {
                if (postorder[i] >= root) {
                    index = i;
                    break;
                }
            }
            for (int i = index; i <= right; i++) {
                if (postorder[i] < root) {
                    return false;
                }
            }
            return recur(left, index - 1) && recur(index, right - 1);
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}