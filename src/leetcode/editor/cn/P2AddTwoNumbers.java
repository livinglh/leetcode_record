//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学

  
package leetcode.editor.cn;
//java:两数相加
public class P2AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        超出表示范围
//        int num1 = 0, num2 = 0;
//        int i = 0;
//        while(l1 != null){
//            num1 += l1.val * Math.pow(10, i);
//            l1 = l1.next;
//            i++;
//        }
//        i = 0;
//        while(l2 != null){
//            num2 += l2.val * Math.pow(10, i);
//            l2 = l2.next;
//            i++;
//        }
//        int sum = num1 + num2;
//        ListNode root = null;
//        char[] str = String.valueOf(sum).toCharArray();
//        System.out.println(str);
//        for(char c:str) {
//            ListNode node = new ListNode(c-'0');
//            node.next = root;
//            root = node;
//        }
//        return root;
        ListNode root = new ListNode(0);
        ListNode pre = root;
        int flag = 0;
        while(l1 != null || l2 != null){
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;
            int sum = x + y + flag;
            flag = sum / 10;
            sum = sum % 10;
            pre.next = new ListNode(sum);
            pre = pre.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(flag == 1) pre.next = new ListNode(1);
        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}