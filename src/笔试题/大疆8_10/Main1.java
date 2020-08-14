package 笔试题.大疆8_10;
/*
4
3
3
333
77
100
13

175
 */
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int A = sc.nextInt();
        int X = sc.nextInt();

        int[] time = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            time[i] = sc.nextInt();
            sum += time[i];
        }
        int ans = 0;
        float hours = sum / 60 / A;
        if(hours <= X){
            ans = sum % A == 0 ? sum / A : sum / A + 1;
        }else{
            ans = X * 60 + (sum - 60 * X * A);
        }

        ans = ans > 8 * 60 ? 0 : ans;

        System.out.println(ans);
    }
}
