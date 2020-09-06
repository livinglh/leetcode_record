package 笔试题.搜狗9_5;

import java.util.Arrays;
import java.util.Scanner;
// ac
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[3];
        nums[0] = sc.nextInt();
        nums[1] = sc.nextInt();
        nums[2] = sc.nextInt();

        Arrays.sort(nums);

        int left = nums[0], right = nums[2];
        while(left < right){
            int mid = left + ((right - left+1) >>> 1);
            if(isOK(nums, mid)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(left);

    }

    public static boolean isOK(int[] nums, int mid){
        int down = 0, more = 0;
        for(int num : nums){
            if(num > mid){
                more += num - mid;
            }else{
                down += mid - num;
            }
        }
        return more >= down * 2;
    }
}

