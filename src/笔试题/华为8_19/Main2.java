package 笔试题.华为8_19;

import java.util.Scanner;

public class Main2 {
    static long[] out = new long[1001];
    static long[] in = new long[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        out[0] = 1;
        in[0] = 1;
        int mod = (int) 1e9 + 7;
        for (int i = 1; i <= 1000; i++) {
            out[i] = out[i-1] * i % mod;
            in[i] = in[i-1] * help(i, mod - 2, mod) % mod;
        }
        for (int i = 0; i < N; i++) {
            nums[sc.nextInt()] += 1;
        }
        int ans = 1;
        for (int i = 0; i < N; i++) {
            if(nums[i] == 0){
                break;
            }else{
                int a;
                if(i == 0){
                    a = 1;
                }else{
                    a = 2 * nums[i-1];
                }

                int b = nums[i];
                long c = out[a] * in[a - b] % mod;
                c = c * in[b] % mod;
                ans = (int) (ans * c % mod);
            }
        }
        System.out.println(ans);
    }

    public static long help(long i, long k, long mod){
        long res = 1;
        while(k > 0){
            if((k & 1) == 1){
                res = res * i % mod;
            }
            k >>= 1;
            i = i * i % mod;
        }
        return res;
    }
}
