package 笔试题.shopee8_19;

import java.util.Scanner;

/*
["a", ["b","c"],"d"]
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replace(" ", "");
        String[] strs = str.substring(1,str.length()-1).split(",");
        String ans = help(strs);
        ans = '"' + ans.substring(0,ans.length()-2) + '"';
        System.out.println(ans);

    }

    public static String help(String[] strs){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].trim();
            char[] c = strs[i].toCharArray();
            if(c[0] == '\"'){
                sb.append(c[1] + "\\n");
            }else{
                sb.append(help(strs[i].substring(1,strs[i].length()-1).split(",")));
            }
        }
        return sb.toString();
    }
}