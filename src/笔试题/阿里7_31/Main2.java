package 笔试题.阿里7_31;

import java.util.Scanner;

/*
小强最近在研究某个飘洋过海的游戏。

游戏可以看成一个n∗m的方格图，从左上角(1,1)到右下角的(n,m)有两种地面，C表示为陆地S表示海洋，每次穿行只能到达上下左右四个格子之一，不能走到方格图之外。

在陆地之间穿行一格需要花费三点行动力，在海洋之间穿行一格需要花费2点行动力。
但是从陆地和从海洋到陆地穿行则需要5点行动力。

输入描述：
第一行输入两个整数n,m,q表示方格图的大小和询问次数。
随后n行，每行m个元素每个元素为'C'或'S',详见样例。

随后q行每行四个数字bx,by,ex,ey，分别代表起点的坐标和终点的坐标。

输入：
4 4 2
CCCS
SSSS
CSCS
SSCC
1 1 3 4
3 1 1 3

输出
13
14
 */
public class Main2 {
    static char[][] grp;
    static int n, m, q, currVal, result;
    static boolean[][] isVisit;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        grp = new char[n][m];
        for (int i = 0; i < n; i++) {
            grp[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < q; i++) {
            isVisit = new boolean[n][m];
            result = Integer.MAX_VALUE;
            currVal = 0;
            int bx = sc.nextInt();
            int by = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            BackTrace(bx-1, by-1, ex-1, ey-1);
            System.out.println(result);
        }
    }

    public static void BackTrace(int bx, int by, int ex, int ey) {
        if (currVal >= result) {
            return;
        }
        if (bx == ex && by == ey) {
            if (currVal < result) {
                result = currVal;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nextX = bx + direction[i][0];
            int nextY = by + direction[i][1];
            if (isOk(nextX, nextY)) {
                int add = 2;
                if (grp[bx][by] != grp[nextX][nextY]) {
                    add = 5;
                } else if (grp[nextX][nextY] == 'C') {
                    add = 3;
                }
                isVisit[bx][by] = true;
                currVal += add;
                BackTrace(nextX, nextY, ex, ey);
                currVal -= add;
                isVisit[bx][by] = false;
            }
        }
    }

    public static boolean isOk(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m && !isVisit[x][y];
    }
}
