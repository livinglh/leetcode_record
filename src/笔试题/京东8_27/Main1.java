package 笔试题.京东8_27;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = 1;
        while (n != 0){
            start++;
            if(check(start)){
                n--;
            }
        }
        System.out.println(start);
    }

    public static boolean check(int k){
        String s = String.valueOf(k);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '2' || s.charAt(i) == '3' || s.charAt(i) == '5'){
                continue;
            }
            return false;
        }
        return true;
    }
}
