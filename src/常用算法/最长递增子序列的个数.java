package 常用算法;

import java.util.Arrays;

public class 最长递增子序列的个数 {
    public static void main(String[] args) {
        return;
    }
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n]; //dp[i]表示以i位置结尾，即nums[i]值结尾的，最长连续递增序列的长度
        int[] counter = new int[n];  //count[i]为以nums[i]结尾的最长递增子序列的组合数量
        Arrays.fill(dp, 1);
        Arrays.fill(counter, 1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        counter[i] = counter[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        counter[i] += counter[j];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == max) res += counter[i];
        }
        return res;
    }
}
