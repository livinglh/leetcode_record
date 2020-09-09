package 笔试题.电信云9_9;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        nums[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < N; i++) {
            int f2 = 2 * nums[index2];
            int f3 = 3 * nums[index3];
            int f5 = 5 * nums[index5];
            int curmin = Math.min(f2, Math.min(f3, f5));
            nums[i] = curmin;
            if(curmin == f2) {
                index2 ++;
            }
            if(curmin == f3){
                index3 ++;
            }
            if(curmin == f5){
                index5 ++;
            }
        }
        System.out.println(nums[N-1]);
    }
}
