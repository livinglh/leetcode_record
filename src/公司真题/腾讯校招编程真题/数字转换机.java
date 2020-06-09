package 公司真题.腾讯校招编程真题;

import java.util.Scanner;

public class 数字转换机 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] src = new int[2];
        int[] target = new int[2];
        int res = -1;
        for ( int i = 0; i < 2; i++){
            src[i] = sc.nextInt();
        }
        for ( int i = 0; i < 2; i++) {
            target[i] = sc.nextInt();
        }
        int count1 = 0, count2 = 0,count3 = 0;
        int tar = target[0];
        while(tar / 2 >= src[0]){
            tar = tar/2;
            count2 ++;
        }

        count1 = tar - src[0];
        count3 = target[0] - target[0] / 2 * 2;

        if((src[1] + count1) * Math.pow(2, count2) + count3 == target[1]){
            res = count1 + count2 + count3;
        }

        if(res == -1){  //1 100 2 101
            if(target[1] - src[1] == target[0] - src[0]){
                res = target[0] - src[0];
            }
        }

        System.out.println(res);
    }
}
