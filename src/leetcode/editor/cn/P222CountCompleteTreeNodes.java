//给出一个完全二叉树，求出该树的节点个数。 
//
// 说明： 
//
// 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为
//第 h 层，则该层包含 1~ 2h 个节点。 
//
// 示例: 
//
// 输入: 
//    1
//   / \
//  2   3
// / \  /
//4  5 6
//
//输出: 6 
// Related Topics 树 二分查找 
// 👍 217 👎 0


package leetcode.editor.cn;

//java:完全二叉树的节点个数
public class P222CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new P222CountCompleteTreeNodes().new Solution();
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
        //        int ans = 0;
//        public int countNodes(TreeNode root) {
//            if(root == null){
//                return 0;
//            }
//            DFS(root);
//            return ans;
//        }
//        public void DFS(TreeNode root){
//            if(root == null){
//                return;
//            }
//            ans += 1;
//            DFS(root.left);
//            DFS(root.right);
//        }
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            /*
            left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是2^left - 1，加上当前这个root节点，则正好是2^left。再对右子树进行递归统计。
            left != right。说明此时最后一层不满，但倒数第二层已经满了，可以直接得到右子树的节点个数。同理，右子树节点+root节点，总数为2^right。再对左子树进行递归查找。
             */
            int left = countLevel(root.left);
            int right = countLevel(root.right);
            if (left == right) {
                return countNodes(root.right) + (1 << left);
            } else {
                return countNodes(root.left) + (1 << right);
            }
        }

        private int countLevel(TreeNode root) {
            int level = 0;
            while (root != null) {
                level++;
                root = root.left;
            }
            return level;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}