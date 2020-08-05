package 笔试题.华为8_5;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int priov = help(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            int cur = help(strs[i]);
            if(Math.abs(cur-priov) <= min){
                min = Math.abs(cur-priov);
                ans = i;
            }
        }
        System.out.println(strs[ans]);
    }

    public static int help(String str){
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z'){
                res += str.charAt(i) - 'a' + 1;
            }else{
                res += str.charAt(i) - 'A' + 1;
            }
        }
        return res;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        String[] arr = str.split(" ");
        int num = 0;
        for (int i = 0; i < arr[0].length(); i++){
            num += arr[0].charAt(i)-'a'+1;
        }
        int sub = Integer.MAX_VALUE;
        String res = "";
        for (int i = 1; i < arr.length; i++){
            int temp = 0;
            for (int j = 0; j < arr[i].length(); j++){
                temp += arr[i].charAt(j)-'a'+1;
            }
            res = sub >= Math.abs(num-temp) ? arr[i] : res;
            if (sub >= Math.abs(num-temp)){
                sub = Math.abs(num-temp);
            }
        }
        System.out.println(res);
    }
}
