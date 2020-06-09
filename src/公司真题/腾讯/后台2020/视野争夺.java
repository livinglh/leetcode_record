package 公司真题.腾讯.后台2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 视野争夺 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
        int index = 0;
        int count = 0;
        int pre = 0;   //右边界
        while (pre < L) {
            if (arr[index][0] > pre) {
                System.out.println(-1);
            }
            int max = 0;
            while (index < n && arr[index][0] <= pre) {
                max = Math.max(max, arr[index][1]);
                index++;
            }
            count++;
            pre = max;
            if (pre >= L) {
                System.out.println(count);
                return;
            }
            if (index >= n) {
                System.out.println(-1);
                return;
            }
        }
    }
}
