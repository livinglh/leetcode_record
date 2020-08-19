package 笔试题.shopee8_19;

import java.util.LinkedList;
import java.util.Scanner;

/*
"(*))"
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1, str.length()-1);
        LinkedList<Integer> left = new LinkedList<Integer>();
        LinkedList<Integer> xinghao = new LinkedList<Integer>();
        char[] ch = str.toCharArray();
        boolean ans = true;
        for (int i = 0; i < ch.length; i++) {
            if(ch[i] == '*'){
                xinghao.addFirst(i);
            }else if(ch[i] == '('){
                left.addFirst(i);
            }else{
                if(left.size()!=0){
                    left.removeFirst();
                }else if(xinghao.size()!=0){
                    xinghao.removeFirst();
                }else{
                    ans = false;
                    break;
                }
            }
        }

        while(xinghao.size() != 0 && left.size()!=0){
            int a = left.removeFirst();
            int b = xinghao.removeFirst();
            if(a > b) {
                ans = false;
                break;
            }
        }
        if( left.size()!= 0){
            ans = false;
        }
        System.out.println(ans == true ? "true" : "false");
    }
}

