//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 319 👎 0


package leetcode.editor.cn;

//java:删除排序链表中的重复元素 II
public class P82RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new P82RemoveDuplicatesFromSortedListIi().new Solution();
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
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode pre = new ListNode(0);
            ListNode res = pre;
            pre.next = head;
            ListNode cur = head;
            boolean flag = false;
            while(cur != null){
                while(cur.next != null && cur.val == cur.next.val){
                    cur.next = cur.next.next;
                    flag = true;
                }
                if(flag){
                    pre.next = cur.next;
                }else{
                    pre = pre.next;
                }
                cur = cur.next;
                flag = false;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}