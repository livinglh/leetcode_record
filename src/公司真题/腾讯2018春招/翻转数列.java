package 公司真题.腾讯2018春招;

import java.util.Scanner;

public class 翻转数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        long sum = 0;

        sum = m * n / 2;
        System.out.println(sum);
    }
}
