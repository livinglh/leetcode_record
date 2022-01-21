//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。 
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
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 168 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// java: 从上到下打印二叉树 III
public class P剑指Offer32IIICongShangDaoXiaDaYinErChaShuIiiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer32IIICongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curlevel = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> curList = new ArrayList<>();
            while (n-- > 0) {
                TreeNode cur = queue.poll();
                curList.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (ans.size() % 2 == 1) Collections.reverse(curList);
            ans.add(curList);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}