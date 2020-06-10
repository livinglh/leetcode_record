package 公司真题.腾讯2018春招;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 纸牌游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        int niu = 0, yang = 0, turn = 1;
        for (int i = n-1; i >=0 ; i--) {
            if(turn == 1) {
                niu += nums[i];
            }else{
                yang += nums[i];
            }
            turn = turn * -1;
        }
        int res = niu - yang;
        System.out.println(res);
    }
}
