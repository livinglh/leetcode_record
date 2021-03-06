//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
//

  
package leetcode.editor.cn;

import java.util.Collection;
import java.util.Map;

//java:二叉搜索树的后序遍历序列
public class P面试题33ErChaSouSuoShuDeHouXuBianLiXuLieLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题33ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 1. 递归 On On
        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }
        boolean recur(int[] po, int i, int j) {
            if(i >= j) return true;
            int l = i;
            while(po[l] < po[j]) l++;
            int m = l;
            while(po[l] > po[j]) l++;
            return l == j && recur(po, i, m - 1) && recur(po, m, j - 1);
        }

        // 2. 辅助单调栈

    }
//leetcode submit region end(Prohibit modification and deletion)

}