package 公司真题.字节2019春招;

import java.util.Scanner;

public class 万万没想到之抓捕孔连顺 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int D = sc.nextInt();
//        int[] height = new int[N];
//        for (int i = 0; i < N; i++) {
//            height[i] = sc.nextInt();
//        }
//
//        int left = 0;
//        int right = 2;
//        long res = 0;
//        while(left < N - 2){
////            int first = findfirst(left, N-1, height, D);
////            right = first == -1 ? N : first;
//
//            while(right < N && height[right] - height[left] <= D){
//                right++;
//            }
//            if (right - 1 - left >= 2){
//                int nums = right - left - 1;
//                res += nums*(nums-1) /2;
//            }
//            left ++;
//        }
//        System.out.println(res % 99997867);
//    }
//
//    public static int findfirst(int l, int r, int[] height, int D){
//        int target = height[l] + D;
//        int left = l,right = r;
//        while(left < right){
//            int mid = left + (right - left) / 2;
//            if(height[mid] <= target){
//                left = mid + 1;
//            }else{
//                right = mid;
//            }
//        }
//
//        if(height[left] <= target) return -1;
//        return left;
//    }
        int mod = 99997867;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), D = sc.nextInt();
        long cnt = 0;
        if (N <= 2) {
            System.out.println(-1);
            return;
        }
        int[] locs = new int[N];
        for (int i = 0; i < N; i++) {
            locs[i] = sc.nextInt();
        }
        sc.close();
        int left = 0, right = 2;
        while (right < N) {
            if (locs[right] - locs[left] > D) left++;
            else if (right - left < 2) right++;
            else {
                cnt += calC(right - left);
                right++;
            }
        }
        cnt %= mod;
        System.out.println(cnt);
    }

    private static long calC(long num) {
        return num * (num - 1) / 2;
    }
}
