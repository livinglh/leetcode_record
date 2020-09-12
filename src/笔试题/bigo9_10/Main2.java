package 笔试题.bigo9_10;

import java.util.Scanner;

/*
7 3 6
a b c d e f g
 */
public class Main2 {
    static class ListNode{
        String val;
        ListNode next;
        ListNode(String val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode start = new ListNode("#");
        ListNode tail = start;
        String[] str = sc.nextLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int n = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[2]);
        String[] strs = sc.nextLine().split(" ");
        for (int i = 0; i < N; i++) {
            tail.next = new ListNode(strs[i]);
            tail = tail.next;
        }
//        ListNode cur = start.next;
//        while(cur != null){
//            System.out.print(cur.val);
//            cur = cur.next;
//        }
//
//        System.out.println();

        ListNode newstart = reverseList(start.next, n, m);

        while(newstart != null){
            System.out.print(newstart.val);
            newstart = newstart.next;
        }
    }

    public static ListNode reverseList(ListNode head, int n, int m){
        ListNode ans = head;
        ListNode n_pre = null;
        int ch_len = m - n + 1;
        int index = 1;
        while(index < n){
            n_pre = head;
            head = head.next;
            index ++;
        }

        ListNode n_head = head;
        ListNode pre = null;
        ListNode temp = null;
        while(ch_len != 0){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
            ch_len --;
        }
        n_head.next = head;
        if(n_pre == null){
            ans = pre;
        } else {
            n_pre.next = pre;
        }

        return ans;
    }
}
