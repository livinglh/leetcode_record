package 笔试题.京东8_6;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double f = 0;
        for (int i = 1; i <= n*2; i++) {
            if((i & 1) == 1 ){
                f += 1.0 / (5 * i);
            }else{
                f -= 1.0 / (5 * i);
            }
        }
        System.out.printf("%.4f", f);
    }
}
