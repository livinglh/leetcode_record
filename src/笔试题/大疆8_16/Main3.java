package 笔试题.大疆8_16;

import java.util.Scanner;

/*
数字字符串，删除n个数，使得其最小


71245323308
4

1223308
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char[] ch = new char[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            while(count!=0 && n > 0 && s.charAt(i) < ch[count-1]){
                count--;
                n--;
            }
            ch[count++] = s.charAt(i);
        }
        int l = 0;
        while(l < count && ch[l] == '0'){   // 删除数字字符串的前置0
            l++;
        }
        String ans = "0";
        if(l >= count - n){  // 若非0字符不够删
            System.out.println(ans);
        }else{
            ans = new String(ch,l,count-l-n);
            System.out.println(ans);
        }
    }
}
