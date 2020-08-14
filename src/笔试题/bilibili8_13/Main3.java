package 笔试题.bilibili8_13;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int need = 1024 - N;
        int num64 = need / 64;
        need = need % 64;
        int num16 = need / 16;
        need = need % 16;
        int num4 = need / 4;
        need = need % 4;
        int num1 = need / 1;
        int ans = num1 + num4 + num16 + num64;
        System.out.println(ans);
    }
}
