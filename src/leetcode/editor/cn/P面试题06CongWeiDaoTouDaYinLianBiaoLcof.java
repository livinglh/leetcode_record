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
//

  
package leetcode.editor.cn;

import java.util.Stack;

//java:从尾到头打印链表
public class P面试题06CongWeiDaoTouDaYinLianBiaoLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题06CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
    public int[] reversePrint(ListNode head) {

        Stack<Integer> sk = new Stack<Integer>();
        ListNode temp = head;
        while(temp!=null){
            sk.push(temp.val);
            temp = temp.next;
        }
        int[] ans = new int[sk.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = sk.pop();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}