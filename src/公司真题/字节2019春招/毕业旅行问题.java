package 公司真题.字节2019春招;

import java.util.Scanner;

public class 毕业旅行问题 {

    // 方法一 递归 50%
//    static int mincost = Integer.MAX_VALUE;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int[][] dis = new int[N][N]; // 距离矩阵
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                dis[i][j] = sc.nextInt();
//            }
//        }
//
//        boolean[] visited = new boolean[N];
//        visited[0] = true;
//        DFS(dis, visited, 0, 0, 1, N);
//        System.out.println(mincost);
//    }
//
//    private static void DFS(int[][] dis, boolean[] visited, int start, int curcost, int time, int N){
//        if(time == N){
//            curcost += dis[start][0];
//            mincost = Math.min(curcost, mincost);
//            return;
//        }
//        for (int i = 0; i < N; i++) {
//            if(!visited[i]){
//                if (curcost + dis[start][i] >= mincost) continue;
//                visited[i] = true;
//                DFS(dis, visited, i, curcost + dis[start][i], time + 1, N);
//                visited[i] = false;
//            }
//        }
//        return;
//    }
    // 方法二 动态规划 100%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n][n];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map.length; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][1 << (n - 1)];
        for (int i = 0; i < n; i++) {
            dp[i][0] = map[i][0];
        }

        for (int p = 1; p < 1 << (n - 1); p++) {  //遍历所有集合
            for (int i = 0; i < n; i++) {  //选定一个起点城市
                dp[i][p] = Integer.MAX_VALUE >> 1;  //除以2防止计算时越界
                if(self(i, p)) {  //城市i不能出现在集合p中，因为i是起点
                    continue;
                }
                for (int k = 1; k < n; k++) {  //依次枚举子问题
                    if(visit(k, p)) {  //判断城市k是否在集合p中
                        int op = unmark(p, k);
                        dp[i][p] = Math.min(dp[i][p], dp[k][op] + map[i][k]);
                    }
                }
            }
        }

        System.out.println(dp[0][(1 << (n - 1)) - 1]);
    }


    private static boolean self(int city, int p) {  //对城市0统一返回false
        return (p & (1 << (city - 1))) != 0;
    }

    private static boolean visit(int city, int p) {
        return self(city, p);
    }

    private static int unmark(int p, int city) {
        return (p & (~(1 << (city - 1))));
    }
}
