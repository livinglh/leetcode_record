//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 432 👎 0


package leetcode.editor.cn;

//java:移除链表元素
public class P203RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode headpre = new ListNode(-1);
            headpre.next = head;
            ListNode pre = headpre;
            while(head != null){
                if(head.val == val){
                    pre.next = head.next;
                    head = head.next;
                }else{
                    pre = head;
                    head = head.next;
                }
            }
            return headpre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}