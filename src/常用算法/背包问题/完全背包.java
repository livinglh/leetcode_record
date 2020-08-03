package 常用算法.背包问题;
/*
有 N 种物品和一个容量是 V 的背包，每种物品都有无限件可用。

第 i 种物品的体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使这些物品的总体积不超过背包容量，且总价值最大。
输出最大价值

也是两种选择，选或不选，只不过每个物品可以选无限次，在01的基础上把
dp[i][j]=max(dp[i][j],dp[i-1][j-v[i]]+w[i])
改为
dp[i][j]=max(dp[i][j],dp[i][j-v[i]]+w[i])即可

4 5
1 2
2 4
3 4
4 5

10
 */
import java.util.Scanner;

public class 完全背包 {
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
        int ans = solution2(N, V, v, w);
        System.out.println(ans);
    }

    // 朴素做法 O(NV) O(NV)
    public static int solution1(int N, int V, int[] v, int[] w){
        int[][] dp = new int[N+1][V+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= V; j++) {
                dp[i][j] = dp[i-1][j]; //不选
                if(j >= v[i]){ //选择
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-v[i]] + w[i]);
                }
            }
        }
        return dp[N][V];
    }

    // 一维数组优化空间 O(NV) O(V)
    public static int solution2(int N, int V, int[] v, int[] w){
        int[] dp = new int[V+1];
        for (int i = 1; i <= N; i++) {
            for (int j = v[i]; j <= V; j++) {  //注意
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
