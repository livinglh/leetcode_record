package 笔试题.字节8_9;

import java.util.Scanner;
/*

N个机器，每个机器都有各自的生产能力（只能生产型号小于其能力的产品）
现在需要生产N个产品，给出各产品的型号，计算一共有多少种生产方案
对F取余数

3
3 3 3
1 1 1
100

6
 */
public class Main4 {
    static long ans = 0;
    static int N, F;
    static boolean[] visited;
    static int[] model;
    static int[] power;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        power = new int[N];
        model = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            power[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            model[i] = sc.nextInt();
        }

        F = sc.nextInt();

        DFS(0);
        System.out.println(ans % F);
    }

    public static void DFS(int cur){
        if(cur == N){
            ans = (ans+1) % F;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i] && power[cur] >= model[i]){
                visited[i] = true;
                DFS(cur+1);
                visited[i] = false;
            }
        }
    }
}
