package 笔试题.广联达8_26;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] nums = new long[4];
        long sum = 0;
        for (int i = 0; i < 4; i++) {
            nums[i] = sc.nextLong();
            sum += nums[i];
        }
        long end = sum / 4;

        long left = 0, right = end;
        while(left < right){
            long mid = left + ((right - left) >> 1);
            int res = check(nums, mid);
            if(res == 0){
                left = mid;
                break;
            }else if(res == 1){
                left = mid + 1;
            }else{
                right = right - 1;
            }
        }

        if(check(nums, left) == 0){
            System.out.println(left * 4);
        }else{
            System.out.println(-1);
        }

    }

    public static int check(long[] nums, long cur){
        long down = 0, add = 0;

        for (long num : nums) {
            if(num > cur){
                down += num - cur;
            }else if(num < cur){
                add += (cur - num)*2;
            }
        }
        if(down == add){
            return 0;
        }else if(down > add){
            return 1;
        }
        return -1;
    }
}
