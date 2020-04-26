//合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。 
//
// 示例: 
//
// 输入:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//输出: 1->1->2->3->4->4->5->6 
// Related Topics 堆 链表 分治算法

  
package leetcode.editor.cn;

import java.util.PriorityQueue;

//java:合并K个排序链表
public class P23MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
    // 1. 优先级队列
//    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
//            if(o1.val < o2.val) return -1;
//            else if (o1.val == o2.val) return 0;
//            else return 1;
//        }));
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//        for (ListNode node: lists) {
//            if(node!=null)  priorityQueue.offer(node);
//        }
//        while(!priorityQueue.isEmpty()){
//            cur.next = priorityQueue.poll();
//            cur = cur.next;
//            if(cur.next != null) priorityQueue.offer(cur.next);
//        }
//        return head.next;
//    }
    // 分治
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid+1,end);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}