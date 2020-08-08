package 笔试题.网易8_8;

import java.util.Scanner;
/*
给了 n 个物品和它对应的价值。可以舍弃一部分物品，要两个人平分这些物品（数量可以不一样，价值总和要一样），问最少舍弃多少价值。
 */
public class Main3 {
    static int min = Integer.MAX_VALUE;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
                sum += nums[j];
            }
            dfs(nums, 0, 0, 0);
            System.out.println(min);
        }
    }

    public static void dfs(int[] nums, int index, int ans1, int ans2){
        if(index == nums.length){
            if(ans1 == ans2){
                min = Math.min(min, sum - 2 * ans1);
            }
            return;
        }

        int val = nums[index];
        // 丢弃
        dfs(nums, index+1, ans1, ans2);
        // 给第一位
        dfs(nums, index+1, ans1+val, ans2);
        // 给第二位
        dfs(nums, index+1, ans1, ans2+val);
    }

    // 背包解法
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T -- > 0) {
            sum = 0;
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
                sum += nums[j];
            }
            boolean[] dp = new boolean[sum+1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                for (int j = sum; j >= nums[i] ; j--) {
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }

            int ans = sum;
            for (int i = sum; i >= 0; i--) {
                if(i % 2 != 0){
                    continue;
                }
                if(dp[i] && dp[i/2]){
                    ans = sum - i;
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
