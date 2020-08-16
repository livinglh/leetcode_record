package 笔试题.大疆8_16;

import java.util.Scanner;

/*

0/1背包

2 2
10 1
20 2

20
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] value = new int[x];
        int[] cost = new int[x];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
            cost[i] = sc.nextInt();
        }

        // dp[i][j] = max(dp[i-1][j], dp[i-1][j-c[i]] + v[i])
        int[] dp = new int[x+1];
        for (int i = 0; i < n; i++) {
            for (int j = x; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-cost[i]] + value[i]);
            }
        }
        System.out.println(dp[x]);
    }
}

