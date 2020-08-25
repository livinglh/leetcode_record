package 笔试题.阿里8_21;
/*
5
1 2 3 4 5

74
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            res += nums[n-1] * nums[i];
        }
        for (int i = 0; i < n - 2; i++) {
            res += nums[n-2] * nums[i];
        }

        System.out.println(res);
    }
}
