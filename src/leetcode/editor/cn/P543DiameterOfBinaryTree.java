//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。 
//
// 示例 : 
//给定二叉树 
//
// 
//          1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树

  
package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

//java:二叉树的直径
public class P543DiameterOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new P543DiameterOfBinaryTree().new Solution();
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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root.left == null && root.right == null)
            return 0;
        int left = 0,right = 0;
        if(root.left != null)
            left = dfs(root.left) + 1;
        if(root.right != null)
            right = dfs(root.right) + 1;
        ans = Math.max(right+left,ans);
        return Math.max(right,left);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}