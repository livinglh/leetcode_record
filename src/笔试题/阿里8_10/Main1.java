package 笔试题.阿里8_10;

import java.util.Arrays;
import java.util.Scanner;

/*


 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] arr = new long[N];
        for (int i=0; i<N; i++) {
            arr[i] = in.nextLong();
        }
        Arrays.sort(arr);
        long ans = 0;
        int left = 0, right = N-1;
        while (left < right) {
            ans += (arr[right]-arr[left]);
            left++;
            right--;
        }
        System.out.println(ans);
    }
}
