package 笔试题.bigo9_10;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str == null || str.length() == 0){
            System.out.println("false");
        }

        boolean flag = false;
        boolean nums = false;
        boolean ems = false;
        boolean dot = false;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] >= '0' && ch[i] <= '9') {
                nums = true;
            }else if(ch[i] == '-' || ch[i] == '+'){
                if(i != 0 && ch[i-1] != 'e'){
                    System.out.println("false");
                    flag = true;
                    break;
                }
            }else if(ch[i] == '.'){
                if(dot || ems){
                    System.out.println("false");
                    flag = true;
                    break;
                }
                dot = true;
            }else if(ch[i] == 'e'){
                if(ems || !nums){
                    System.out.println("false");
                    flag = true;
                    break;
                }
                ems = true;
                nums = false;
            }else{
                System.out.println("false");
                break;
            }
        }
        if(!flag){
            if(nums){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }
    }
}
