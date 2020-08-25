package 笔试题.猿辅导8_22;

import java.util.Scanner;
/*
猜数字游戏，免费次数k
leetcode 375改
 */
public class Main3 {
    static int[][] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        memo = new int[n+1][n+1];
        int ans = DFS(1, n);
        System.out.println(ans);
    }

    public static int DFS(int left, int right){
        if(right-left==1){
            return left;
        }
        if(left >= right){
            return 0;
        }
        if(memo[left][right] != 0){
            return memo[left][right];
        }

        int min = Integer.MAX_VALUE;
        for (int i = (left+right)/2; i <= right; i++) {
            min = Math.min(min, Math.max(DFS(left, i-1), DFS(i+1, right)) + i);
        }

        return memo[left][right] = min;
    }
}
