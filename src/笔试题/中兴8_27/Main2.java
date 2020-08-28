package 笔试题.中兴8_27;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[][] nums = new long[n][m];
        long ans = -5000000000L;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextLong();
            }
        }

        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                ans = Math.max(nums[i][j] + nums[i+1][j] + nums[i-1][j] + nums[i][j+1] + nums[i][j-1], ans);
            }
        }

        System.out.println(ans);

    }
}
