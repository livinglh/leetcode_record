package 常用算法.背包问题;

import java.util.Scanner;

/*
有 N 件物品和一个容量是 V 的背包，背包能承受的最大重量是 M。

每件物品只能用一次。体积是 vi，重量是 mi，价值是 wi。

求解将哪些物品装入背包，可使物品总体积不超过背包容量，总重量不超过背包可承受的最大重量，且价值总和最大。
输出最大价值。

输入格式
第一行两个整数，N，V, M，用空格隔开，分别表示物品件数、背包容积和背包可承受的最大重量。

接下来有 N 行，每行三个整数 vi,mi,wi，用空格隔开，分别表示第 i 件物品的体积、重量和价值。

输出格式
输出一个整数，表示最大价值。

数据范围
0<N≤1000
0<V,M≤100
0<vi,mi≤100
0<wi≤1000
输入样例
4 5 6
1 2 3
2 4 4
3 4 5
4 5 6
输出样例：
8

思路：这个题也很简单，就是在01背包的基础上加了一维重量，枚举的时候多一层循环就行了。因为是01背包的变形，所以重量和体积枚举的时候都从大到小枚举。
 */
public class 二维背包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int M = sc.nextInt();
        int[] v = new int[N];
        int[] m = new int[N];
        int[] w = new int[N];
//        for (int i = 0; i < N; i++) {
//            v[i] = sc.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            m[i] = sc.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            w[i] = sc.nextInt();
//        }
        for (int i = 0; i < N; i++) {   //没有使用二维方法，所以这里下标0-n-1简化一下方法
            v[i] = sc.nextInt();
            m[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int ans = solution1(N, V, M, v, m, w);
        System.out.println(ans);
    }

    public static int solution1(int N, int V, int M, int[] v, int[] m, int[] w){
        int[][] dp = new int[V+1][M+1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {
                for (int k = M; k >= m[i]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-v[i]][k-m[i]] + w[i]);
                }
            }
        }
        return dp[V][M];
    }
}
