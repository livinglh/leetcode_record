package 常用算法.背包问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
有 N 种物品和一个容量是 V 的背包。

第 i 种物品最多有 si 件，每件体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
输出最大价值。

4 5
1 2 3
2 4 1
3 4 3
4 5 2

10
 */
public class 多重背包 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] v = new int[N];
        int[] w = new int[N];
        int[] s = new int[N];
//        for (int i = 0; i < N; i++) {
//            v[i] = sc.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            w[i] = sc.nextInt();
//        }
//        for (int i = 0; i < N; i++) {
//            s[i] = sc.nextInt();
//        }
        for (int i = 0; i < N; i++) {   //没有使用二维方法，所以这里下标0-n-1简化一下方法
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        int ans = solution2(N, V, v, w, s);
        System.out.println(ans);
    }

    // 一维数组优化空间 O(NVS) O(V)
    public static int solution1(int N, int V, int[] v, int[] w, int[] s) {
        int[] dp = new int[V + 1];
        for (int i = 0; i < N; i++) {
            for (int j = V; j >= v[i]; j--) {  //注意
                for (int k = 1; k <= s[i] && k * v[i] <= j; k++) { //注意
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
        }
        return dp[V];
    }

    // 二进制优化时间 O(NVlog(S)) O(V)
    /*
    其实可以把它转化为一个01背包的问题。每个物品有s件，我们可以把它差分成s份
    每份物品当做不同的个体，即只能选一次，这就转化为了01背包物品
     */
    static class Good {
        int v;
        int w;

        Good(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public static int solution2(int N, int V, int[] v, int[] w, int[] s) {
        int[] dp = new int[V + 1];
        // 构建01背包
        List<Good> goods = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= s[i]; k = k * 2) {
                s[i] -= k;
                goods.add(new Good(k * v[i], k * w[i]));
            }
            if (s[i] > 0) {
                goods.add(new Good(s[i] * v[i], s[i] * w[i]));
            }
        }

        for (Good good : goods) {
            for (int j = V; j >= good.v; j--) {  //注意
                dp[j] = Math.max(dp[j], dp[j - good.v] + good.w);
            }
        }
        return dp[V];
    }


    // 二进制优化时间 O(NVlog(S)) O(V) 代码过程优化
    public static int solution3(int N, int V, int[] v, int[] w, int[] s) {
        int[] dp = new int[V + 1];
        // 构建01背包过程中进行计算
        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= s[i]; s[i] -= k, k = k * 2) {
                for (int j = V; j >= k * v[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - k * v[i]] + k * w[i]);
                }
            }
            if (s[i] > 0) {
                for (int j = V; j >= s[i] * v[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - s[i] * v[i]] + s[i] * w[i]);
                }
            }
        }
        return dp[V];
    }

    // 单调队列优化 O(NV) O(V) 待续
}
