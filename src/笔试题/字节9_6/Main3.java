package 笔试题.字节9_6;
/*
5 1
1 3 -9 2 4

6


5 3
1 3 -9 2 4

11
 */
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        long ans = nums[0];
        long cur = 0, last = 0;

        for (int k = 0; k < K; k++) {
            for (int i = 0; i < nums.length; i++) {
                cur = nums[i];
                cur += Math.max(last, 0);
                last = cur;
                ans = Math.max(ans, cur);
            }
        }
        System.out.println(ans);
    }
}
