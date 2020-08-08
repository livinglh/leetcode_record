package 笔试题.网易8_8;
/*
给了 n 个点， m 条边，(u,v,w)，从 m 条边中选 n - 1 条边构建生成树，求最大权值 - 最小权值的最小值

思路及代码：https://blog.csdn.net/hjd_love_zzt/article/details/14525117
 */
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(0);
        }
    }
}
