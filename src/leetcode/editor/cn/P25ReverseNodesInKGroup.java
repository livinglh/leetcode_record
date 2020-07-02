//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表

  
package leetcode.editor.cn;
//java:K 个一组翻转链表
public class P25ReverseNodesInKGroup{
    public static void main(String[] args) {
        Solution solution = new P25ReverseNodesInKGroup().new Solution();
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null) return head;
        int n = 0;

        boolean blean = false;
        ListNode res = head;

        ListNode pretail = new ListNode(0);
        pretail.next = head;
        ListNode curNode = head;
        ListNode curhead = head, curtail = head;
        while(true){
            if(curNode == null) return res;
            while(n++ != k-1){
                curNode = curNode.next;
                if(curNode == null){
                    return res;
                }
            }
            curhead = pretail.next;
            curtail = curNode;
            curNode = curNode.next;
            ListNode[] ht = reverserNode(curhead,curtail.next);
            ListNode newhead = ht[0], newtail =  ht[1];

            if(!blean) {
                res = newhead;
                blean = true;
            }
            pretail.next = newhead;
            newtail.next = curNode;
            pretail = newtail;

            n = 0;
        }
    }

    //翻转链表 返回新的头尾节点  翻转范围[cur, tail-1)
    public ListNode[] reverserNode(ListNode cur, ListNode tail){
        ListNode newtail = cur;
        ListNode pre = null;
        while(cur != tail){
            ListNode tempNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tempNode;
        }
        return new ListNode[]{pre, newtail};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}