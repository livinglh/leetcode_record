package 笔试题.阿里8_7;

import java.util.Scanner;
/*
给一个数字N，一个数组a。求全排列的数量，使得每一个排列满足 a[i] 不在位置 i 上
 */

public class Main1 {
    static int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve3(n));
    }

    //错排公式
    public static int solve1(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int num1 = 0, num2 = 1, num3 = 0;
        for (int i = 3; i <= n; i++) {
            num3 = (i - 1) * (num2 + num1) % mod;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }

    //错排公式递归解法
    public static int solve2(int index) {
        if (index == 1) {
            return 0;
        } else if (index == 2) {
            return 1;
        } else {
            for (int i = index; i > 0; i--) {
                return (i - 1) * (solve2(i - 1) + solve2(i - 2));
            }
        }
        return -1;
    }

    public static int solve3(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = (int) (((i - 1L) * (dp[i - 1] + dp[i - 2])) % 1000000007);
        }
        return dp[n];
    }


}
