//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
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
// Related Topics 树 数组 哈希表 分治 二叉树 👍 645 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// java: 重建二叉树
public class P剑指Offer07ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer07ZhongJianErChaShuLcof().new Solution();
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
        private Map<Integer, Integer> map = new HashMap<>();
        private int[] preorder;
        private int[] inorder;

        public TreeNode build(int preleft, int preright, int inleft, int inright) {
            if (preleft > preright) {
                return null;
            }
            TreeNode node = new TreeNode(preorder[preleft]);
            int index = map.get(preorder[preleft]);
            int size = index - inleft;
            node.left = build(preleft + 1, preleft + size, inleft, index - 1);
            node.right = build(preleft + size + 1, preright, index + 1, inright);
            return node;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.inorder = inorder;
            this.preorder = preorder;
            int n = preorder.length;
            for (int i = 0; i < n; i++) {
                map.put(inorder[i], i);
            }
            return build(0, n - 1, 0, n - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}