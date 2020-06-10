package 公司真题.腾讯校招编程真题;

import java.util.Scanner;

public class 编码 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] arr = str.toCharArray();
        int len = arr.length;

        int curSum = 0;
        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            curSum *= 25;
            if (i <= len) {
                curSum += arr[i - 1] - 'a';
            }
            sum += curSum;
            if (i < len) {
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
