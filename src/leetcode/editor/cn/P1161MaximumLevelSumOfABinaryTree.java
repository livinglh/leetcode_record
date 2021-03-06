//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。 
//
// 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。 
//
// 
//
// 示例： 
//
// 
//
// 输入：[1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数介于 1 和 10^4 之间 
// -10^5 <= node.val <= 10^5 
// 
// Related Topics 图 
// 👍 25 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//java:最大层内元素和
public class P1161MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new P1161MaximumLevelSumOfABinaryTree().new Solution();
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
        public int maxLevelSum(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int h = 1;
            int res = 0, maxsum = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
                }
                if(sum > maxsum) {
                    res = h;
                    maxsum = sum;
                }
                h++;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}