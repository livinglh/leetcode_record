//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
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
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:

public class P面试题07ZhongJianErChaShuLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题07ZhongJianErChaShuLcof().new Solution();
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