package 笔试题.科大讯飞9_12;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] max1 = new long[n];
        long[] max1index = new long[n];
        long[] max2 = new long[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Long num = sc.nextLong();
                if(num > max1[i]){
                    max2[i] = max1[i];
                    max1[i] = num;
                    max1index[i] = j;
                }else{
                    if(num > max2[i]){
                        max2[i] = num;
                    }
                }
            }
        }


        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j < n; j++) {
                if(max1index[i] != max1index[j]){
                    ans = Math.max(ans, max1[i] * max1[j]);
                }else{
                    ans = Math.max(ans, Math.max(max1[i] * max2[j], max1[j] * max2[i]));
                }
            }
        }
        System.out.println(ans);
    }
}
