package 公司真题.腾讯校招编程真题;

import java.util.Scanner;

public class 石子合并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int sum = 0;
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            sum += pre * nums[i];
            pre += nums[i];
        }
        System.out.println(sum);
    }
}
