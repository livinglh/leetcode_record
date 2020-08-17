package 笔试题.字节8_16;

import java.util.Scanner;

/*
给出n和m，n个数字a[i]，每个数字只能用一次，问能凑出的最大的sum%m，sum是数字取和，其中n最大为35，m最大1e9+7。
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = sc.nextInt();
        }

        DFS(data, 0, m, 0);
    }


    public static int DFS(int[] data, int k, int m, int total) {

        int n = data.length;
        // 已经对数组中的所有数据进行判断了
        if (k==n) {
            // 必须继续添加一个参数作为最终结果的记录（尾递归，用空间换时间）
            return total%m;
        } else {
            // 选当前索引的数组，也就是total值增加
            int first = DFS(data, k+1, m, total+data[k]);
            // 不选当前索引的数组，total值不变
            int second = DFS(data, k+1, m, total);
            return Math.max(first, second);
        }
    }
}
