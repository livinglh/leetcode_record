package 公司真题.腾讯.后台2020;

import java.util.Scanner;

public class 逆序对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = (int) Math.pow(2,n);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] qi = new int[m];
        for (int i = 0; i < m; i++) {
            qi[i] = sc.nextInt();
        }


        // 归并排序中计数

    }
}
