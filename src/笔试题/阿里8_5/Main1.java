package 笔试题.阿里8_5;

import java.util.Scanner;

/*
扑克片排序的 输入一个n m 分别代表扑克牌从1 - n
m指从每种牌的四个花色中取出来来m个进行排序 两种不同的牌型指的是包含对应数字牌的个数不同 一共有多少种排序方法
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int ans = solve(n, m);
        System.out.println(ans);
    }

    public static int solve(int n, int m){
        int mod = 1000000007;
        int[][] dp = new int[n+1][m+1];  // dp[i][j] 代表取前i个数字的牌（抽完1到i)，手里有j张牌时的总方法数
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i-1][j]; //不取
                if(j - 1 >= 0)  //取1张
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % mod;
                if(j - 2 >= 0)  //取2张
                    dp[i][j] = (dp[i][j] + dp[i-1][j-2]) % mod;
                if(j - 3 >= 0)  //取3张
                    dp[i][j] = (dp[i][j] + dp[i-1][j-3]) % mod;
                if(j - 4 >= 0)  //取4张
                    dp[i][j] = (dp[i][j] + dp[i-1][j-4]) % mod;
            }
        }
        return dp[n][m];
    }
}
