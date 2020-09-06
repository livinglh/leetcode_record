package 笔试题.搜狗9_5;

import java.util.Scanner;
// 20
public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[]{-1,4,5,2};
        System.out.println(find(2, nums));
    }

    public static int find(int n, int[] nums){
        int last = -Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            int x = nums[i];
            int length = nums[i];
            int left = x - length / 2, right = x + length / 2;
            if(left - last == n){
                sum += 1;
            }else if(left - last > n){
                sum += 2;
            }
            last = right;
        }

        //sum += 1;
        return sum;
    }
}
