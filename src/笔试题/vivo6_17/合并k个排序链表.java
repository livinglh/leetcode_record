package 笔试题.vivo6_17;

import org.junit.Test;

import java.util.PriorityQueue;

public class 合并k个排序链表 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode solve(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(((o1, o2) -> {
            if (o1.val < o2.val) return -1;
            else if (o1.val == o2.val) return 0;
            else return 1;
        }));
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (ListNode node : lists) {
            if (node != null) priorityQueue.offer(node);
        }
        while (!priorityQueue.isEmpty()) {
            cur.next = priorityQueue.poll();
            cur = cur.next;
            if (cur.next != null) priorityQueue.offer(cur.next);
        }
        return head.next;
    }
    @Test
    public void test() {
        return;
    }
}
