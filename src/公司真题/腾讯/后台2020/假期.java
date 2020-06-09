package 公司真题.腾讯.后台2020;

import java.util.Arrays;
import java.util.Scanner;

public class 假期 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] work = new int[n];
        for (int i = 0; i < n; i++) {
            work[i] = sc.nextInt();
        }
//        System.out.println(work.toString());
        int[] health = new int[n];
        for (int i = 0; i < n; i++) {
            health[i] = sc.nextInt();
        }
//        System.out.println(health.toString());
        int[][] dp = new int[n+1][3]; //0：休息 1：工作 2：健身
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], 100001);
        }
        dp[0][0] = 0; dp[0][1] = 0; dp[0][2] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = Math.min(Math.min(dp[i-1][0], dp[i-1][1]), dp[i-1][2]) + 1;
            if(work[i-1] == 1){
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]);
            }
            if(health[i-1] == 1){
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]);
            }
        }
        int res = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(res);
    }
}
