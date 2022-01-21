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
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
//pointer/ 
//
// 
// Related Topics 哈希表 链表 👍 376 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

// java: 复杂链表的复制
public class P剑指Offer35FuZaLianBiaoDeFuZhiLcof {
    public static void main(String[] args) {
        Solution solution = new P剑指Offer35FuZaLianBiaoDeFuZhiLcof().new Solution();
    }

    class Node {
        private int val;
        private Node next;
        private Node random;

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
        private Map<Node, Node> map = new HashMap<>();

        public Node copyRandomList(Node head) {
            //            // 法一：递归
            //            if (head == null) {
            //                return null;
            //            }
            //            Node newNode = new Node(head.val);
            //            map.put(head, newNode);
            //            newNode.next = copyRandomList(head.next);
            //            newNode.random = map.get(head.random);
            //            return newNode;
            // 法二：两次遍历
            Node cur = head;
            while (cur != null) {
                Node newNode = new Node(cur.val);
                map.put(cur, newNode);
                cur = cur.next;
            }
            cur = head;
            while (cur != null) {
                Node newNode = map.get(cur);
                newNode.next = map.get(cur.next);
                newNode.random = map.get(cur.random);
                cur = cur.next;
            }
            return map.get(head);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}