package 笔试题.拼多多9_1;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] w = new int[N+1];
        int[] v = new int[N+1];
        for (int i = 1; i < N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[] dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = M; j >= v[i]; j++) {
                dp[j] = Math.max(dp[j], dp[j-v[i] + w[i]]);
            }
        }
        System.out.println(dp[M]);
    }

}