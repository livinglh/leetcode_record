//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例: 
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
// 
// Related Topics 链表

  
package leetcode.editor.cn;
//java:两两交换链表中的节点
public class P24SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        ListNode res = pre;
        while(cur != null && cur.next != null){
            pre.next = cur.next;
            ListNode curnext = cur.next.next;
            cur.next.next = cur;
            cur.next = curnext;
            pre = cur;
            cur = curnext;
        }
        return res.next;

        // 递归
//        // If the list has no node or has only one node left.
//        if ((head == null) || (head.next == null)) {
//            return head;
//        }
//
//        // Nodes to be swapped
//        ListNode firstNode = head;
//        ListNode secondNode = head.next;
//
//        // Swapping
//        firstNode.next  = swapPairs(secondNode.next);
//        secondNode.next = firstNode;
//
//        // Now the head is the second node
//        return secondNode;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}