//对于一棵深度小于 5 的树，可以用一组三位十进制整数来表示。 
//
// 对于每个整数： 
//
// 
// 百位上的数字表示这个节点的深度 D，1 <= D <= 4。 
// 十位上的数字表示这个节点在当前层所在的位置 P， 1 <= P <= 8。位置编号与一棵满二叉树的位置编号相同。 
// 个位上的数字表示这个节点的权值 V，0 <= V <= 9。 
// 
//
// 给定一个包含三位整数的升序数组，表示一棵深度小于 5 的二叉树，请你返回从根到所有叶子结点的路径之和。 
//
// 样例 1: 
//
// 输入: [113, 215, 221]
//输出: 12
//解释: 
//这棵树形状如下:
//    3
//   / \
//  5   1
//
//路径和 = (3 + 5) + (3 + 1) = 12.
// 
//
// 
//
// 样例 2: 
//
// 输入: [113, 221]
//输出: 4
//解释: 
//这棵树形状如下: 
//    3
//     \
//      1
//
//路径和 = (3 + 1) = 4.
// 
//
// 
// Related Topics 树 
// 👍 15 👎 0

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:路径和 IV
public class P666PathSumIv{
    public static void main(String[] args) {
        Solution solution = new P666PathSumIv().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0, curVal = 0;

        public int pathSum(int[] nums) {
            if (nums.length == 0) return 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                int depth = num / 100;
                int pos = num / 10 % 10;
                int val = num % 10;
                int code = (int) Math.pow(2, depth - 1) + pos - 1;
                map.put(code, val);
            }
            //递归
            helper(map, 1);
            return res;
        }

        private void helper(Map<Integer, Integer> map, int index) {
            if (!map.containsKey(index)) return;
            curVal += map.get(index);
            //判断是否到达叶子节点
            //到达
            if (!map.containsKey(index * 2) && !map.containsKey(index * 2 + 1)) {
                res += curVal;
            }
            //未到达
            if (map.containsKey(index * 2)) {
                helper(map, index * 2);
            }
            if (map.containsKey(index * 2 + 1)) {
                helper(map, index * 2 + 1);
            }
            //回退
            curVal -= map.get(index);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}