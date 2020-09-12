package 笔试题.科大讯飞9_12;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long N = sc.nextLong();
        int ans = 0;
        while(N != 0){
            N = N & (N - 1);
            ans ++;
        }
        System.out.println(ans);
    }
}
