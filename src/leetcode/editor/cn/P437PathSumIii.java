//给定一个二叉树，它的每个结点都存放着一个整数值。 
//
// 找出路径和等于给定数值的路径总数。 
//
// 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。 
//
// 示例： 
//
// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//      10
//     /  \
//    5   -3
//   / \    \
//  3   2   11
// / \   \
//3  -2   1
//
//返回 3。和等于 8 的路径有:
//
//1.  5 -> 3
//2.  5 -> 2 -> 1
//3.  -3 -> 11
// 
// Related Topics 树


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:路径总和 III
public class P437PathSumIii {
    public static void main(String[] args) {
        Solution solution = new P437PathSumIii().new Solution();
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
        Map<Integer, Integer> map = new HashMap<>(); // 前缀和：路径数量
        int count = 0;
        public int pathSum(TreeNode root, int sum) {
            map.put(0,1); //前缀和为0的一条路径
            rec(root, sum, 0);
            return count;
        }

        public void rec(TreeNode root, int sum, int cursum){
            if(root == null){
                return;
            }
            cursum += root.val;
            if(map.containsKey(cursum - sum)){
                count += map.get(cursum - sum);
            }
            map.put(cursum,map.getOrDefault(cursum,0)+1);
            rec(root.left,sum,cursum);
            rec(root.right,sum,cursum);
            map.put(cursum,map.get(cursum) - 1);
            cursum -= cursum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}