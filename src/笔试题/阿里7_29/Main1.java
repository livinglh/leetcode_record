package 笔试题.阿里7_29;

import java.util.Scanner;

/*
给 n 个恐龙蛋及恐龙蛋的大小，按从大到小排列，第 i 个恐龙蛋每天增大 i，问最少几天会出现两个同样大小的恐龙蛋
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] V = new int[n];
        for (int i = 0; i < n; i++) {
            V[i] = sc.nextInt();
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, V[i-1]-V[i]);
        }
        System.out.println(min);
    }
}
