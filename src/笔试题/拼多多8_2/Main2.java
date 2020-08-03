package 笔试题.拼多多8_2;

import java.util.*;

/*
题目大致意思是，如果一个骰子可以通过上下，或者左右，或者前后翻转。如果通过若干次翻转后两个筛子的六个面点数
一样，则可以算作一个类骰子。
然后第一行输入一个整数n，表示有n个骰子。接下来的n行每行六个数，分别代表骰子的上下，左右，前后六个面的数字，然
后要求计算后输出，有多少类骰子，第二行输出每一类的骰子个数，需要降序排列。
示例 1:
输入:  2
1 2 3 4 5 6
1 2 6 5 3 4
 输出:
1
2
示例 2:
输入:
 3
 1 2 3 4 5 6
 1 2 6 5 3 4
 1 2 3 4 6 5
输出:
2
2 1
示例 3:
输入:
10
2 5 1 3 4 6
5 4 3 2 1 6
1 4 6 2 3 5
1 5 6 3 4 2
6 4 2 1 5 3
3 6 4 5 2 1
1 6 3 4 2 5
5 1 4 2 6 3
6 2 3 1 5 4
5 3 6 1 4 2
 输出:
 9
 2 1 1 1 1 1 1 1 1


 思路：用了硬编码dic把index都转换成1在top的情况，然后遍历一下水平旋转的4种情况(也是硬编码p数组）
 */
public class Main2 {
    static int[][] dic = new int[][]{
            {0,1,2,3,4,5},
            {1,0,2,3,5,4},
            {2,3,1,0,4,5},
            {3,2,0,1,4,5},
            {4,5,2,3,1,0},
            {5,4,2,3,0,1}
    };
    static int[][] p = new int[][] {
            {2,3,4,5},
            {5,4,2,3},
            {3,2,5,4},
            {4,5,3,2}
    };
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] s = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                s[i][j] = scanner.nextInt();
            }
        }
        Map<String, Integer> map = new HashMap<>();
        for (int[] sh : s) {
            for (int j = 0; j < 6; j++) {
                if (sh[j] == 1) {
                    String t = "" + sh[dic[j][0]] + sh[dic[j][1]];
                    String po = "";
                    boolean b = false;
                    for (int k = 0; k < 4; k++) {
                        po = t;
                        for (int l = 0; l < 4; l++) {
                            int index = p[k][l];
                            po += sh[dic[j][index]];
                        }
                        if (map.containsKey(po)) {
                            map.put(po, map.get(po) + 1);
                            b = true;
                            break;
                        }
                    }
                    if (!b) {
                        map.put(po, 1);
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b)->b - a);
        System.out.println(map.size());
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
