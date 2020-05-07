//给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 
//
// 示例 1： 
//输入: 
//
//   5
// /  \
//2   -3
// 
//
// 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。 
//
// 示例 2： 
//输入： 
//
//   5
// /  \
//2   -5
// 
//
// 返回 [2]，只有 2 出现两次，-5 只出现 1 次。 
//
// 
//
// 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。 
// Related Topics 树 哈希表

  
package leetcode.editor.cn;

import java.util.*;

//java:出现次数最多的子树元素和
public class P508MostFrequentSubtreeSum{
    public static void main(String[] args) {
        Solution solution = new P508MostFrequentSubtreeSum().new Solution();
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
    private Map<Integer, Integer> map = new HashMap();
    private int maxtimes = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        cmpSum(root);
        List<Integer> res = new ArrayList<>();
        for (int key:map.keySet()) {
            if(map.get(key) == maxtimes){
                res.add(key);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
    public int cmpSum(TreeNode root){
        if(root == null) return 0;
        int left = cmpSum(root.left);
        int right = cmpSum(root.right);
        int sum = left + right + root.val;
        int value = map.getOrDefault(sum,0);
        map.put(sum, value+1);
        maxtimes = Math.max(maxtimes, value+1);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}