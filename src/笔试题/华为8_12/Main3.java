package 笔试题.华为8_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
everythinggoeswell,5
eiwetgelyorhgslvne
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.next().split(",");
        char[] str = strs[0].toCharArray();
        int N = Integer.valueOf(strs[1]);
        List<StringBuilder> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ans.add(new StringBuilder());
        }

        int mid = N / 2;
        int cur = 0;
        boolean goright = false;
        for (int i = 0; i < str.length; i+=2) {
            ans.get(cur).append(str[i]);
            if(cur == mid) i--;
            if(cur != mid && i+1<str.length) ans.get(N-1-cur).append(str[i+1]);
            if(cur==0 || cur == mid) goright = !goright;
            cur += goright ? 1 : -1;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(ans.get(i).toString());
        }
    }
}
