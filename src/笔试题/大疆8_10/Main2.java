package 笔试题.大疆8_10;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        int[] s = new int[N];
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }

        int[] dp = new int[T + 1];
        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= s[i]; s[i] -= k, k = k * 2) {
                for (int j = T; j >= k * v[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
            if (s[i] > 0) {
                for (int j = T; j >= s[i] * v[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - s[i] * v[i]] + s[i] * w[i]);
                }
            }
        }
        System.out.println(dp[T]);
    }
}
