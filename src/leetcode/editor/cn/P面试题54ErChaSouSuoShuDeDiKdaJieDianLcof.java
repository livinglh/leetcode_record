//给定一棵二叉搜索树，请找出其中第k大的节点。 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树

  
package leetcode.editor.cn;
//java:二叉搜索树的第k大节点
public class P面试题54ErChaSouSuoShuDeDiKdaJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题54ErChaSouSuoShuDeDiKdaJieDianLcof().new Solution();
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
    int index = 0, ans = -1;
    public int kthLargest(TreeNode root, int k) {
        DFS(root, k);
        return ans;
    }
    public void DFS(TreeNode root, int k){
        if(root == null) return;
        if(index > k) return;
        kthLargest(root.right, k);
        index ++;
        if(index == k){
            ans = root.val;
            return;
        }
        kthLargest(root.left, k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}