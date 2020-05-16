//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-point
//er/ 
//
// 
// Related Topics 链表

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//java:复杂链表的复制
public class P面试题35FuZaLianBiaoDeFuZhiLcof{
    public static void main(String[] args) {
        Solution solution = new P面试题35FuZaLianBiaoDeFuZhiLcof().new Solution();
    }
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        //Map On On
//        Map<Node,Node> map=new HashMap<>();
//        Node p=head;
//        while(p!=null){
//            map.put(p,new Node(p.val));
//            p=p.next;
//        }
//        p=head;
//        while(p!=null){
//            map.get(p).next=map.get(p.next);
//            map.get(p).random=map.get(p.random);
//            p=p.next;
//        }
//        return map.get(head);
        // 复制拆分 On O1
        if(head==null) return null;
        copy2(head);
        randomAdd2(head);
        return build2(head);
    }

    public void copy2(Node head){
        while(head!=null){
            Node copy = new Node(head.val);
            copy.next = head.next;
            head.next =copy;
            head = copy.next;
        }
    }
    public void randomAdd2(Node head){
        while(head!=null){
            if(head.random!=null) head.next.random = head.random.next;
            head=head.next.next;
        }
    }
    public Node build2(Node head) {
        //将链表拆成两个，注意要恢复原有的链表
        Node res = head.next;
        Node tmp = res;

        head.next = head.next.next;//这一步不可缺少，保证第一个复制节点对N N'的分离操作
        head = head.next;
        while (head != null) {
            tmp.next = head.next;
            head.next = head.next.next;
            tmp = tmp.next;
            head = head.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}