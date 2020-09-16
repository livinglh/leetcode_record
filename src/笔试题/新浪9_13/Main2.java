package 笔试题.新浪9_13;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] ch = str.toCharArray();
        int len = ch.length;
        int flag = 1;
        Arrays.sort(ch);
        for (int i = 1; i < len; i++) {
            if(ch[i] == ch[i-1]){
                flag = 0;
                break;
            }
        }

        if(flag == 1){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}
