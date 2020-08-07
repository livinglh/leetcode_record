package 公司真题.网易2020校招;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] things = new int[n+1][m+1];
            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                things[x][y] = 1;
            }
            int c = sc.nextInt();
            int d = sc.nextInt();

            System.out.println(isYes(n,m,c,d,things));
        }
    }

    public static String isYes(int n, int m, int c, int d, int[][] things){
        int[][] dp = new int[n+1][m+1];
        for (int row = 1; row < n+1; row++) {
            for (int col = 1; col < m+1; col++) {
                if(things[row][col] == 1) continue;
                dp[row][col] = col >= 1 ? dp[row][col-1]+1 : 1;
                int weight = dp[row][col];
                if(weight < c && weight < d) continue;
                for (int r = row; r >= 1; r--) {
                    weight = Math.min(dp[r][col], weight);
                    if(weight < c && weight < d) break;
                    int height = row - r + 1;
                    if(weight >= c && height >= d || weight >= d && height >= c){
                        return "YES";
                    }
                }
            }
        }
        return "NO";
    }
}
