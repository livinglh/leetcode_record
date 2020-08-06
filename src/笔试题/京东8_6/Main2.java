package 笔试题.京东8_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    static Map<Integer, Boolean> Rememo = new HashMap<>();
    static Map<Integer, Boolean> Prmemo = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int ans = 0;
        for (int i = N; i <= M; i++) {
            String str = String.valueOf(i);
            for (int j = 0, flag = 0; j < str.length() && flag == 0; j++) {
                String strn = str.substring(0,j) + str.substring(j+1);
                int n = Integer.valueOf(strn);
                if(isPrime(n) && isReverse(n) ){
                    ans += 1;
                    flag = 1;
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean isPrime(int N) {
        if(Prmemo.containsKey(N)) return Prmemo.get(N);
        if (N < 2) return false;
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d)
            if (N % d == 0) {
                Prmemo.put(N, false);
                return false;
            }
        Prmemo.put(N, true);
        return true;
    }

    public static boolean isReverse(int N) {
        if(Rememo.containsKey(N)) return Rememo.get(N);
        int ans = 0, start = N;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        Rememo.put(N, ans == start);
        return ans == start;
    }

}
