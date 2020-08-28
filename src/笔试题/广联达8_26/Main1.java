package 笔试题.广联达8_26;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String right = sc.next();
        String fact = sc.next();
        int n = right.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(right.charAt(i) == fact.charAt(i)){
                ans += 20;
            }else if(ans >= 10){
                ans -= 10;
            }
        }
        System.out.println(ans);
    }
}
