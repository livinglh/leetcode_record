package 公司真题.腾讯校招编程真题;

import java.util.Arrays;
import java.util.Scanner;

public class 素数对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        boolean[] isPrim = countPrimes(N);
        for (int i = 2; i * 2 <= N ; i++) {
            if(isPrim[i] && isPrim[N-i]){
                res ++;
            }
        }

        System.out.println(res);
    }

    public static boolean[] countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for (int i = 2; i * i < n; i++)
            if (isPrim[i])
                for (int j = i * i; j < n; j += i)
                    isPrim[j] = false;


        return isPrim;
    }
}
