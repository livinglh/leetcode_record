package 常用算法.背包问题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
有 N 种物品和一个容量是 V 的背包。

物品一共有三类：

第一类物品只能用1次（01背包）；
第二类物品可以用无限次（完全背包）；
第三类物品最多只能用 si 次（多重背包）；
每种体积是 vi，价值是 wi。

求解将哪些物品装入背包，可使物品体积总和不超过背包容量，且价值总和最大。
输出最大价值。

si=−1 表示第 i 种物品只能用1次；
si=0 表示第 i 种物品可以用无限次；
si>0 表示第 i 种物品可以使用 si 次；

思路：是一个前三种背包问题的综合，如果明白了前面的，就很简单了，只需要判断一下类型
如果是多重背包，将它转换为01背包插入数组当中，然后按着不同类型的处理方式去遍历空间大小即可

4 5
1 2 -1
2 4 1
3 4 0
4 5 2

8
 */
public class 混合背包 {
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
        for (int i = 0; i < N; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        int ans = solution2(N, V, v, w, s);
        System.out.println(ans);
    }

    // 二进制优化时间 O(NVlog(S)) O(V)
    /*
    多重背包其实可以把它转化为一个01背包的问题。每个物品有s件，我们可以把它差分成s份
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

    public static int solution1(int N, int V, int[] v, int[] w, int[] s) {
        int[] dp = new int[V + 1];

        for (int i = 0; i < N; i++) {
            if (s[i] == 0) {    // 无限个， 完全背包
                for (int j = v[i]; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }
            } else {   // 0/1背包看作物品件数只有1个的多重背包
                // 多重背包转0/1背包
                List<Good> goods = new ArrayList<>();
                s[i] = Math.abs(s[i]);
                for (int k = 1; k <= s[i]; s[i] -= k, k = k * 2) {
                    goods.add(new Good(k * v[i], k * w[i]));
                }
                if (s[i] > 0) {
                    goods.add(new Good(s[i] * v[i], s[i] * w[i]));
                }
                for (Good good : goods) {
                    for (int j = V; j >= good.v; j--) {  //注意
                        dp[j] = Math.max(dp[j], dp[j - good.v] + good.w);
                    }
                }
            }
        }
        return dp[V];
    }


    // 优化代码过程
    public static int solution2(int N, int V, int[] v, int[] w, int[] s) {
        int[] dp = new int[V + 1];

        for (int i = 0; i < N; i++) {
            if (s[i] == 0) {    // 无限个， 完全背包
                for (int j = v[i]; j <= V; j++) {
                    dp[j] = Math.max(dp[j], dp[j - v[i]] + w[i]);
                }
            } else {   // 0/1背包看作物品件数只有1个的多重背包
                // 多重背包转0/1背包
                s[i] = Math.abs(s[i]);
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
        }
        return dp[V];
    }
}
