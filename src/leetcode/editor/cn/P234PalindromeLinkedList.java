//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针


package leetcode.editor.cn;

//java:回文链表
public class P234PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new P234PalindromeLinkedList().new Solution();
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
        public boolean isPalindrome(ListNode head) {
//            if(head == null || head.next == null){
//                return true;
//            }
//            ListNode slow = head;
//            ListNode fast = head.next.next;
//
//            ListNode pre = null; //翻转前半链表
//            while(fast != null && fast.next != null){
//                ListNode cur = slow;
//                slow = slow.next;
//                cur.next = pre;
//                pre = cur;
//
//
//                fast = fast.next.next;
//            }
//
//            if(pre == null){ // [0,0] [1,0,1]
//                if(fast == null)
//                    return slow.val == slow.next.val;
//                else if(fast.next == null){
//                    return slow.val == fast.val;
//                }
//            }
//
//            ListNode temp = slow;
//            if(fast == null) slow = slow.next;
//            else slow = slow.next.next;
//
//            temp.next = pre;
//            pre = temp;
//
//            while(pre != null && slow != null){
//                if(pre.val != slow.val){
//                    return false;
//                }
//                slow = slow.next;
//                pre = pre.next;
//            }
//            return pre == null && slow == null ? true : false;

            if (head == null || head.next == null)
                return true;

            ListNode slow = head; // 一块一慢两个指针，为了找到需要翻转的半条链表的起点。遍历半个链表
            ListNode fast = head;
            ListNode pre = null; // 用于辅助翻转前半条链表
            while (fast != null && fast.next != null) {
                ListNode cur = slow;
                slow = slow.next;
                fast = fast.next.next;
                cur.next = pre;
                pre = cur;
            }
            if (fast != null) slow = slow.next;
            while (pre != null) { // 两个半长链表的比较 遍历两个 半长链表
                if (pre.val != slow.val)
                    return false;
                slow = slow.next;
                pre = pre.next;
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}