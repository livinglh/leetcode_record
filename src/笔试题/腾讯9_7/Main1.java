package 笔试题.腾讯9_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
6
6 5 4 3 2 1
5
6 5 3 2 1
 */
public class Main1 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int v){
            val = v;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        ListNode l1 = new ListNode(0);
        ListNode cur1 = l1;
        for (int i = 0; i < n1; i++) {
            ListNode node = new ListNode(sc.nextInt());
            cur1.next = node;
            cur1 = node;
        }
        int n2 = sc.nextInt();
        ListNode l2 = new ListNode(0);
        ListNode cur2 = l2;
        for (int i = 0; i < n2; i++) {
            ListNode node = new ListNode(sc.nextInt());
            cur2.next = node;
            cur2 = node;
        }

        cur1 = l1.next;
        cur2 = l2.next;
        List<Integer> ans = new ArrayList<>();
        while(cur1 != null && cur2 != null){
            if(cur1.val > cur2.val){
                cur1 = cur1.next;
            }else if(cur1.val < cur2.val){
                cur2 = cur2.next;
            }else{
                ans.add(cur1.val);
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }

        for(int cur : ans){
            System.out.print(cur + " ");
        }

    }
}
