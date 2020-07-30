package 笔试题.广联达7_29;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minheap.offer(sc.nextInt());
        }
        for (int i = 0; i < m; i++) {
            int curmin = minheap.poll();
            curmin += x;
            minheap.offer(curmin);
        }

        System.out.println(minheap.peek());
    }
}
