//给定一个非空二叉树，返回其最大路径和。 
//
// 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。 
//
// 示例 1: 
//
// 输入: [1,2,3]
//
//       1
//      / \
//     2   3
//
//输出: 6
// 
//
// 示例 2: 
//
// 输入: [-10,9,20,null,null,15,7]
//
//   -10
//   / \
//  9  20
//    /  \
//   15   7
//
//输出: 42 
// Related Topics 树 深度优先搜索


package leetcode.editor.cn;

//java:二叉树中的最大路径和
public class P124BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution solution = new P124BinaryTreeMaximumPathSum().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        private int max = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            //通过后序遍历的方式，先计算出左右子树的最大路径和，然后再计算当前树的最大路径和
            maxSum(root);
            return max;
        }

        private int maxSum(TreeNode root) {
            //通过后序遍历的方式，先计算出左右子树的最大路径和，然后再计算当前树的最大路径和
            if (null == root) {
                return 0;
            }
            int leftMax = Math.max(maxSum(root.left), 0);
            int rightMax = Math.max(maxSum(root.right), 0);
            max = Math.max(max, leftMax + rightMax + root.val);
            return root.val + Math.max(leftMax, rightMax);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}