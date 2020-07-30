package 常用算法.背包问题;

/*
有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。
求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
特点是：每种物品仅有一件，可以选择放或不放

f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值。则其状态转移方程便是：f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
如果不放第i件物品，那么问题就转化为“前i-1件物品放入容量为v的背包中”；如果放第i件物品，那么问题就转化为“前i-1件物品放入剩下的容量为v-c[i]的背包中”

4 5
1 2
2 4
3 4
4 5

8
 */

import java.util.Scanner;

public class 背包01问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N+1];  //第i个元素表示第i个物品
        int[] w = new int[N+1];
//        for (int i = 1; i <= N; i++) {
//            v[i] = sc.nextInt();
//        }
//        for (int i = 1; i <= N; i++) {
//            w[i] = sc.nextInt();
//        }
        for (int i = 1; i <= N; i++) {  // 注意下标 1-N
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int ans = solution1(N, V, v, w);
        System.out.println(ans);

    }
    // 朴素做法 O(NV) O(NV)
    public static int solution1(int N, int V, int[] v, int[] w){
        int[][] dp = new int[N+1][V+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i-1][j]; //不选
                if(j >= v[i]){ //选择
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-v[i]] + w[i]);
                }
            }
        }
        return dp[N][V];
    }

    // 一维数组优化空间 O(NV) O(V)
    public static int solution2(int N, int V, int[] v, int[] w){
        int[] dp = new int[V+1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= v[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-v[i]] + w[i]);
            }
        }
        return dp[V];
        /*
        这时的dp[i]表示空间<=i的最大价值，所以最后直接输出dp[m]即可，这与初始化有关
        因为dp数组在主函数外定义，初始值均为0，所以如果存在一个k<m 使得空间最大为k的情况下dp[k]有最大价值，那么dp[m]一定可以从k这个状态转移过来—即dp[m]一定是最大值。
        若题目要求装满背包，即将物品恰装入一个容量为m的背包中，只需要将初始化条件改一改即可
        将dp数组初始化为负无穷，dp[0]=0，即可确保状态一定是从0转移过来的。
         */
    }
}
