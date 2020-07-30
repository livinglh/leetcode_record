package 笔试题.华为7_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        String[] strs2 = br.readLine().split(" ");
        int st = Integer.parseInt(strs2[0]);
        int len = Integer.parseInt(strs2[1]);
        int idx = 1;
        int ed = st + len - 2;
        if(st + len -1 > strs.length) ed = strs.length-1;
        for (int i = st - 1; i <= ed; i++) {
            if(idx < 20 && i != ed) {
                idx++;
                System.out.print(strs[i]+";");
            } else {
                System.out.println(strs[i]);
                idx = 1;
            }
        }
    }
}
