package 笔试题.字节8_16;

import java.util.Scanner;

/*
给出一个字符串，其中不能出现0010，通过删除字符的方式让整个字符串不出现0010，求最少删除字符个数。
思路：只要找有几个“0010”即可
00100010
2

0010010
2

001010
1
 */
public class Main2 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = "0010";
        int ans = 0;
        int position = 0;
        while(str.indexOf(target, position) != -1){
            ans += 1;
            position = str.indexOf(target, position) + 1;
        }
        System.out.println(ans);
    }
}
