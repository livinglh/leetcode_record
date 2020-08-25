package 笔试题.猿辅导8_22;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][2*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = sc.nextInt();
                nums[i][j+m] = nums[i][j];
            }
        }

        int[][] total = nums;  //total[i][j]表示从第0行到第i行  第j列的累加和
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2*m; j++) {
                total[i][j] += total[i-1][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] result = new int[m*2];
                for (int k = 0; k < 2*m; k++) {
                    if(i == 0){
                        result[k] = total[j][k];
                    }else{
                        result[k] = total[j][k] - total[i-1][k];
                    }
                }

                int maxsub = maxSub(result);
                max = Math.max(max, maxsub);
            }
        }
        System.out.println(max);
    }


    // 求长度不大于m的最长连续子序列和
    public static int maxSub(int[] sub){
        if(sub.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int[] maxSubm = new int[sub.length];
        maxSubm[0] = sub[0];
        for (int i = 1; i < sub.length; i++) {
            maxSubm[i] = (maxSubm[i-1] > 0) ? (maxSubm[i-1] + sub[i]) : sub[i];
            if(max < maxSubm[i]){
                max = maxSubm[i];
            }
        }
        return max;
    }
}
