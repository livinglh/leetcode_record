package 笔试题.字节8_9;

import java.util.Scanner;
/*
最大交替和
给出一个长为N 的整数序列，找出一段连续子序列，使得该段连续子序列的交替和最大

Ap - Aq 的连续子序列和为 A(p) - A(p+1) + A(p+2) - A(p+3) + --- + (-1)^(q-p)*A(q)

5
1 2 3 4 5

5

5
1 -2 3 -4 5
15

 */


public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        // 暴力解 60%
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < N; i++) {
//            int sum = 0;
//            for (int j = i; j < N; j++) {
//                sum += (int) Math.pow(-1,j-i)*nums[j];
//                max = Math.max(sum, max);
//            }
//        }
//        System.out.println(max);
        /*
        动态规划
        dp[i][0] 表示以第i个数结尾，其为正数时的最大和
        dp[i][1] 表示以第i个数结尾，其为负数时的最大和


        dp[i][-]=dp[i-1][+]-nums[i]
        dp[i][+]=max(dp[i-1][-]+nums[i-1],nums[i])

         */

        int ans = 0;
        int[][] dp = new int[N][2];
        dp[0][0] = nums[0];
        for (int i = 1; i < N ; i++) {
            dp[i][0] = Math.max(dp[i-1][1] + nums[i], nums[i]);
            dp[i][1] = dp[i-1][0] - nums[i]; //不存在以-号开头的子序列
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(ans);
    }
}
