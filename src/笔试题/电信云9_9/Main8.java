package 笔试题.电信云9_9;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        int[] dp = new int[str.length];
        dp[0] = Integer.parseInt(str[0]);
        dp[1] = Math.max(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + Integer.parseInt(str[i]), dp[i-1]);
        }
        System.out.println(dp[dp.length-1]);
    }
}
