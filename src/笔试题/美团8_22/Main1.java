package 笔试题.美团8_22;

import java.util.Scanner;

/*
5
Ooook
Hhhh666
ABCD
Meituan
6666
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while(T-- != 0){
            String s = sc.nextLine();
            char[] ch = s.toCharArray();
            int charnum = 0;
            int num = 0;
            boolean flag = false;
            if(ch[0] >= 'A' && ch[0] <= 'Z' || ch[0] >= 'a' && ch[0] <= 'z'){
                for (int i = 0; i < ch.length; i++) {
                    char c = ch[i];
                    if(c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' ){
                        charnum ++;
                    }else if( c >= '0' && c <= '9'){
                        num++;
                    }else{
                        flag =true;
                        System.out.println("Wrong");
                        break;
                    }
                }
                if(!flag){
                    if(num > 0 && charnum > 0){
                        System.out.println("Accept");
                    }else{
                        System.out.println("Wrong");
                    }
                }
            }else{
                System.out.println("Wrong");
            }
        }
    }
}
