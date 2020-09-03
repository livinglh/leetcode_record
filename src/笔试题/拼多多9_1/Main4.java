package 笔试题.拼多多9_1;

import java.util.Scanner;

public class Main4 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//        int[] nums = new int[M];
//        for (int i = 0; i < M; i++) {
//            nums[i] = sc.nextInt();
//        }
//
//        boolean[] flag = new boolean[1000000001];
//        for (int i = 1; i < N + 1; i++) {
//            if(flag[i] == false){
//                for (int j = 0; j < M; j++) {
//                    if(i % nums[j] == 0){
//                        for (int cur = i; cur < N+1; cur += i) {
//                            flag[cur] = true;
//                        }
//                    }
//                }
//            }
//        }
//
//        int sum = 0;
//        for (int i = 1; i < N + 1; i++) {
//            if(flag[i]){
//                sum += 1;
//            }
//        }
//        System.out.println(sum);
//    }

    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        long N = S.nextLong();
        int M = S.nextInt();
        long[] arr = new long[M + 1];
        for (int i = 1; i <= M; i++) {
            arr[i] = S.nextInt();
        }
        long ed = pw(2, M), ans = N;
        for (int i = 1; i < ed; i++) {
            long cnt = 0, tmp = 1;
            for (int j = 1; j <= M; j++) {
                if ((i & (1 << (j - 1))) != 0) {
                    cnt++;
                    tmp = tmp / gcd(tmp, arr[j]) * arr[j];
                }
            }
            if (cnt % 2 == 1) ans -= (N / tmp);
            else ans += (N / tmp);
        }
        System.out.println(N - ans);
    }

    public static long pw(long a, long b) {
        long ans = 1, base = a;
        while (b != 0) {
            if (b % 2 == 1) ans = (ans * base);
            base = (base * base);
            b >>= 1;
        }
        return ans;
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
