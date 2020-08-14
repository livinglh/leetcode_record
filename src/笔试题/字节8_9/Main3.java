package 笔试题.字节8_9;

import java.util.Arrays;
import java.util.Scanner;
/*

有n块牌，每张牌都有各自高度和宽度，
牌阵规则为后边的牌的高度和宽度必须都大于前面的牌，那么最多能选多少张组成一个牌阵


5
5 5
3 1
2 6
4 2
1 4
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums= new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        Arrays.sort(nums, (o1, o2) -> o2[0] - o1[0]);
        // 求第二维度的最长递减子序列

        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = nums[i][1];
        }

        int ans = longdeslen(weight);

        System.out.println(ans);
    }

    // 求最长递减子序列的长度
    public static int longdeslen(int[] nums){
        int[] dp = new int[nums.length];
        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
