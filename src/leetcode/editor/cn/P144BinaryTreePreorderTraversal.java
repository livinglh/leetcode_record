//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 349 👎 0


package leetcode.editor.cn;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//java:二叉树的前序遍历
public class P144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P144BinaryTreePreorderTraversal().new Solution();
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
        List<Integer> ans = new LinkedList<>();
        public List<Integer> preorderTraversal(TreeNode root) {
//            DFS(root);
            // 迭代写法 使用栈
            if(root == null){
                return ans;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                ans.add(cur.val);
                if(cur.right != null) {
                    stack.push(cur.right);
                }
                if(cur.left != null){
                    stack.push(cur.left);
                }

            }
            return ans;
        }

        public void DFS(TreeNode root){
            if(root == null) {
                return;
            }

            ans.add(root.val);
            DFS(root.left);
            DFS(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}