package 笔试题.网易8_8;
/*
给你一组数组，每个元素可以拆成也可以不拆（5=2+3），求拆完后最多有多少个素数。

思路：
这个是找规律的题目：
元素：1    2    3    4    5    6    7    8    9    10    11
对应的素数个数：0    1    1    2    2    3    3    4    4    5        5
得出结论：元素整除2就是该元素拆分后的最多素数个数
 */
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
                sum += nums[i] / 2;
        }
        System.out.print(sum);
    }

}
