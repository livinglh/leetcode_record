//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。 
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 483 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

//java:不同的二叉搜索树 II
public class P95UniqueBinarySearchTreesIi {
    public static void main(String[] args) {
        Solution solution = new P95UniqueBinarySearchTreesIi().new Solution();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if(n == 0) return new LinkedList<>();
            return generateTrees(1, n);
        }

        public List<TreeNode> generateTrees(int start, int end){
            List<TreeNode> allTrees = new LinkedList<>();
            if(start > end){
                allTrees.add(null);
                return allTrees;
            }

            //枚举所有可行根节点
            for (int i = start; i <= end; i++) {
                //获得所有可行的左子树集合
                List<TreeNode> leftTrees = generateTrees(start, i - 1);
                //获得所有可行的右子树集合
                List<TreeNode> rightTrees = generateTrees(i + 1, end);
                //从左子树集合中选出一颗子树，从右子树中选出一颗子树
                for(TreeNode left : leftTrees){
                    for(TreeNode right : rightTrees){
                        TreeNode curTree = new TreeNode(i);
                        curTree.left = left;
                        curTree.right = right;
                        allTrees.add(curTree);
                    }
                }
            }

            return allTrees;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}