//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 152 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// java: 从上到下打印二叉树
public class P剑指Offer32ICongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer32ICongShangDaoXiaDaYinErChaShuLcof().new Solution();
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
        public int[] levelOrder(TreeNode root) {
            if (root == null) return new int[0];
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            List<Integer> ans = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                ans.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}