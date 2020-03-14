//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针

  
package leetcode.editor.cn;


//java:删除链表的倒数第N个节点
public class P19RemoveNthNodeFromEndOfList{
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 两次遍历
//        int L = 0;
//        ListNode start = new ListNode(0);
//        start.next = head;
//        ListNode first = head;
//        while(first != null){
//            L++;
//            first = first.next;
//        }
//        L = L - n;
//        first = start;
//        while(L > 0){
//            first = first.next;
//            L--;
//        }
//        first.next = first.next.next;
//       return start.next;
        // 双指针
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode left = start;
        ListNode right = start;
        while(n+1>0){
            right = right.next;
            n--;
        }
        while(right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return start.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}