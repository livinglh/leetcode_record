package 公司真题.腾讯校招编程真题;

import java.util.Scanner;

public class 小Q的排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = 0, min = 0;
        boolean issort = true;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if(issort && i >= 1 && nums[i-1] > nums[i]){
                issort = false;
            }
        }

        int res = -1;
        if(nums[0] == min && nums[n-1] == max){
            res = issort ? 0 : 1;
        }else if(nums[0] != min && nums[n-1] != max){
            if(nums[0] == max && nums[n-1] == min){
                res = 3;
            }else{
                res = 2;
            }
        }else{
            res = 1;
        }
        System.out.println(res);
    }
}
