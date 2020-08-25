package 笔试题.美团8_22;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = x + y;
        int[][] w = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            w[i][0] = i; //0放id
            w[i][1] = sc.nextInt();//1放实力值
        }
        if (x == y) {
            for (int i = 0; i < x; i++) {
                System.out.print('A');
            }
            for (int i = 0; i < x; i++) {
                System.out.print('B');
            }
            return;
        }
        if (x < y) { //A队人数少,
            //小的值去人数多的，大的值去人数少的
            Arrays.sort(w, (w1,w2)->{
                if(w1[1] > w2[1]) return -1;
                else if(w1[1] < w2[1]) return 1;
                else return w1[0] - w2[0];
            });
        } else {
            Arrays.sort(w, (w1,w2)->{
                if(w1[1] > w2[1]) return 1;
                else if(w1[1] < w2[1]) return -1;
                else return w1[0] - w2[0];
            });
        }
        //先放A中，再放B
        char[] ans = new char[cnt];
        for (int i = 0; i < x; i++) {
            ans[w[i][0]] = 'A';
        }
        for (int i = x; i <cnt ; i++) {
            ans[w[i][0]] = 'B';
        }
        System.out.println(String.valueOf(ans));
    }
}