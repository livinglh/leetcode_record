//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索


package leetcode.editor.cn;

import java.util.*;

//java:二叉树的锯齿形层次遍历
public class P103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root == null) return new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<List<Integer>> res = new ArrayList<>();
            int height = 1;
            while(!queue.isEmpty()){
                int nums = queue.size();
                List<Integer> cures = new ArrayList<>();
                for (int i = 0; i < nums; i++) {
                    TreeNode node = queue.poll();
                    cures.add(node.val);
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
                if(height % 2 == 1) {
                    res.add(cures);
                }else{
                    Collections.reverse(cures);
                    res.add(cures);
                }
                height ++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}