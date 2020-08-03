package 常用算法.背包问题;

import java.util.Scanner;

/*
有 N 组物品和一个容量是 V 的背包。

每组物品有若干个，同一组内的物品最多只能选一个。
每件物品的体积是 vij，价值是 wij，其中 i 是组号，j 是组内编号。

求解将哪些物品装入背包，可使物品总体积不超过背包容量，且总价值最大。

输出最大价值。

输入格式
第一行有两个整数 N，V，用空格隔开，分别表示物品组数和背包容量。

接下来有 N 组数据：

每组数据第一行有一个整数 Si，表示第 i 个物品组的物品数量；
每组数据接下来有 Si行，每行有两个整数 vij,wij，用空格隔开，分别表示第 i 个物品组的第 j 个物品的体积和价值；
输出格式
输出一个整数，表示最大价值。

数据范围
0<N,V≤100
0<Si≤100
0<vij,wij≤100
输入样例
3 5
2
1 2
2 4
1
3 4
1
4 5
输出样例：
8

思路：和多重背包有一些类似，多重背包是每个物品有si件，可以选0,1，2…si件。而分组背包是不选，选第1个，或第2个或第3个…或第si个，都有si+1种决策方式，即使用三层循环即可解决。没有优化方式。
 */
public class 分组背包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[][] v = new int[N][];
        int[][] w = new int[N][];
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            v[i] = new int[n];
            w[i] = new int[n];
            for (int j = 0; j < n; j++) {
                v[i][j] = sc.nextInt();
                w[i][j] = sc.nextInt();
            }
        }

        int ans = solution1(N, V, v, w);
        System.out.println(ans);
    }

    public static int solution1(int N, int V, int[][] v, int[][] w){
        int[] dp = new int[V+1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= 0; j--) {
                for (int k = 0; k < v[i].length; k++) {
                    if(j >= v[i][k]){
                        dp[j] = Math.max(dp[j], dp[j-v[i][k]] + w[i][k]);
                    }
                }
            }
        }
        return dp[V];
    }
}
