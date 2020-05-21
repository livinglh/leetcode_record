//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:从前序与中序遍历序列构造二叉树
public class P105ConstructBinaryTreeFromPreorderAndInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer,Integer> map;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return build(0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int prel, int prer, int inl, int inr){
        if(prel > prer || inl > inr) return null;
        TreeNode root = new TreeNode(preorder[prel]);
        int pivot = map.get(preorder[prel]);
        root.left = build(prel+1, prel + (pivot - inl), inl, pivot-1);
        root.right = build(prel + (pivot - inl)+1,prer,pivot+1,inr);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}