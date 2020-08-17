package 笔试题.字节8_16;

import java.util.Scanner;

/*
给出n段视频，每段视频的时长是L[i]，
要在视频里插入广告，如果广告间隔时间是x，则第i段视频可以插入L[i]/x+1个广告，
现在一共要插入m个广告，求广告间隔时间的最大值

思路：二分这个间隔时间，左边界是0，表示不能放视频，只能一直放广告，右边界是max{L[i]}，因为如果m = n + 1，广告间隔最长就是max{L[i]}，其余m > n的情况间隔肯定小于等于max{L[i]}。


 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] L = new int[n];
        long right = 0;
        for (int i = 0; i < n; i++) {
            L[i] = sc.nextInt();
            right = Math.max(right, L[i]);
        }

        long left = 0;
        while(left < right){
            long mid = left + (right - left) / 2 + 1;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += L[i] / mid + 1;
            }
            if(sum == m){
                left = mid;
            }else if (sum < m){
                right = mid - 1;
            }else{
                left = mid;
            }
        }

        System.out.println(left);
    }
}
