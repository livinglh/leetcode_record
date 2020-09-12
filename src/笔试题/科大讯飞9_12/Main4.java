package 笔试题.科大讯飞9_12;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        int n = Integer.parseInt(sc.nextLine());
        n = n % len;
        String ans = str.substring(n, len) + str.substring(0, n);
        System.out.println(ans);
    }
}
