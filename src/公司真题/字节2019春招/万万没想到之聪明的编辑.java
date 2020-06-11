package 公司真题.字节2019春招;

import java.util.*;

public class 万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = sc.nextLine();
        }

        for(String str : strs){
            List<Character> res = new LinkedList<>();
            int len  = str.length();
            int index = 0, resindex = -1;
            while(index < len){

                res.add(str.charAt(index));
                resindex ++;

                if(resindex >= 3 && res.get(resindex) == res.get(resindex-1) && res.get(resindex-2) == res.get(resindex-3)){
                    res.remove(resindex--);
                }

                if(resindex >= 2 && res.get(resindex) == res.get(resindex-1) && res.get(resindex-1) == res.get(resindex-2)){
                    res.remove(resindex--);
                }

                index ++;
            }
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
            }
            System.out.println();
        }
    }
}
