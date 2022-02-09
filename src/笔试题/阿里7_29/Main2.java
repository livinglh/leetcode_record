package 笔试题.阿里7_29;

import java.util.Scanner;

/*
n 个客栈依次排列，给出 n - 1 条路的权重。从任意一处出发，每走过一条路，该路的权重减 1，但得到 1 点利益。不能走权重为 0 的路。求最大利益
 */
public class Main2 {
    static int MAX = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n-1];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            DFS(weight, i, 0);
        }
    }

    public static void DFS(int[] weight, int cur, int value){

//        MAX = Math.max(MAX, value);

        //当无法继续移动时
        if(cur==0 && weight[cur+1] == 0 || cur==weight.length && weight[cur-1] == 0 ||weight[cur-1] == 0 && weight[cur+1] == 0 ){
            MAX = Math.max(MAX, value);
        }

        //朝左走
        if(cur > 0 && weight[cur-1] > 0){
            weight[cur-1] -= 1;
            DFS(weight, cur-1, value+1);
            weight[cur-1] += 1;
        }
        //朝右走
        if(cur < weight.length+1 && weight[cur+1] > 0){
            weight[cur+1] -= 1;
            DFS(weight, cur+1, value+1);
            weight[cur+1] += 1;
        }
    }
}
