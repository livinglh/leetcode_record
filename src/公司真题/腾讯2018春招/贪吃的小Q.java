package 公司真题.腾讯2018春招;

import java.util.Scanner;

public class 贪吃的小Q {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int res = -1;
        int left = 1, right = M;
        while(left < right){
            int mid =  (right + left + 1) >> 1;
            int s = sum(mid,N);
            if(s == M){
                res = mid;
                break;
            }
            else if(s < M){
                left = mid;
            }else{
                right = mid - 1;
            }
        }
        if(res == -1)  res = left;
        System.out.println(res);

    }

    public static int sum(int x, int N){
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += x;
            x = (x+1) >> 1;
        }
        return sum;
    }
}
