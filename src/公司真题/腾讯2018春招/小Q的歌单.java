package 公司真题.腾讯2018春招;

import java.util.Scanner;

public class 小Q的歌单 {
    public static final int ASD = 1000000007;

    public static void main(String[] args) {

        // 01背包 + 滚动数组

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int a = sc.nextInt(), x = sc.nextInt();
        int b = sc.nextInt(), y = sc.nextInt();
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 0; i < x; i++) {
            for (int j = k; j >= a; j--) {
                dp[j] = (dp[j] + dp[j - a]) % ASD;
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = k; j >= b; j--) {
                dp[j] = (dp[j] + dp[j - b]) % ASD;
            }
        }

        System.out.println(dp[k]);

    }
}
