package 笔试题.阿里8_21;



/*
过桥问题
方案一：用最快的成员nums[1]传递手电筒帮助最慢的nums[n]和nums[n-1]过桥，易知来回所用的时间为2*nums[1]+nums[n]+nums[n-1]。#
方案二：用最快的成员nums[1]和次快的成员nums[2]传递手电筒帮助最慢的nums[n]和nums[n-1]过桥，具体方案如下：
        第一步：nums[1]和nums[2]到对岸，所用时间为nums[2];
        第二步：nums[1]返回，将手电筒给最慢的nums[n]和nums[n-1]，并且nums[n]和nums[n-1]到对岸后将手电筒交给nums[2]，所用时间为：nums[1]+nums[n];
        第三步：nums[2]返回,所用时间为nums[2];
        综合起来方案二所用的总时间为2*nums[2]+nums[n]+nums[1]。


2
4
2 3 7 8
19
4
2 10 12 11
37
*/

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- != 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);

            int[] dp = new int[n];
            dp[0] = a[0];
            dp[1] = a[1];
            for (int i = 2; i < n; i++) {
                dp[i] = Math.min(dp[i-1] + a[0] + a[i], dp[i-2]+a[0]+a[i]+2*a[1]);
            }
            System.out.println(dp[n-1]);
        }
    }

}
