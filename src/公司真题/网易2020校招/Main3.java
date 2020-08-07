package 公司真题.网易2020校招;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] arr = new int[n];
        //将数字录入数组
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            arr[i] = num;
        }
        //先将数组排序
        Arrays.sort(arr);
        //查询次数
        for (int i = 0; i < q; i++) {
            //需要查询的数字
            int x = scanner.nextInt();
            System.out.println(demo4(arr, x));
        }
    }

    public static int demo4(int[] arr, int x) {
        int count = 0;
        //从大往小比较，碰到小于x的及时终止循环，能优化时间
        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] >= x) {
                arr[i]--;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
