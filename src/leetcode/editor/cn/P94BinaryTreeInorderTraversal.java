//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//java:二叉树的中序遍历
public class P94BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //1.递归
//        if(root == null) return ans;
//        inorderTraversal(root.left);
//        ans.add(root.val);
//        inorderTraversal(root.right);
//        return ans;
        //2. 迭代
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack< >();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}