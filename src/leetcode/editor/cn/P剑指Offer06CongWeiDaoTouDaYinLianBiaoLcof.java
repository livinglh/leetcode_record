//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 222 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;

// java: 从尾到头打印链表
public class P剑指Offer06CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer06CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
    class Solution {
        private ArrayList<Integer> result = new ArrayList<>();
        public int[] reversePrint(ListNode head) {
            recur(head);
            int[] res = new int[result.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = result.get(i);
            }
            return res;
        }

        public void recur(ListNode head) {
            if (head == null) {
                return;
            }
            recur(head.next);
            result.add(head.val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}