package 笔试题.test;

import java.util.HashSet;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        HashSet<Character> set = new HashSet<>();
//        StringBuilder strB = new StringBuilder();
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if(set.contains(c)){
//                continue;
//            }else {
//                set.add(c);
//                strB.append(c);
//            }
//        }
//        System.out.println(strB.toString());
        Scanner sc = new Scanner(System.in);
        HashSet<Character> set = new HashSet<>();
        while(sc.hasNext()){
            char[] c = sc.next().toCharArray();
            StringBuilder strB = new StringBuilder();
            for(int i = 0; i < c.length; i++){
                if (set.contains(c[i])) {
                    continue;
                } else {
                    set.add(c[i]);
                    strB.append(c[i]);
                }
            }
            System.out.println(strB.toString());
        }

    }
}
