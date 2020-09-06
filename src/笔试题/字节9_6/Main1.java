package 笔试题.字节9_6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    static long ans;
    static Map<String, Long> memo = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ans = DFS(n,-1);
        System.out.println(ans);

    }

    public static long DFS(int n, int last){
        if(memo.containsKey(n + "_" + last)){
            return memo.get(n + "_" + last);
        }
        long res = 0;
        if(n < 0) {
            return res;
        }
        if(n == 0){
            res ++;
            return res;
        }

        if(last != 2){  //可以走1步或者2步
            int lasttemp = last;
            last = 1;
            res = (res + DFS(n-1, last));
            last = lasttemp;
            last = 2;
            res = (res + DFS(n-2, last));
            last = lasttemp;
        }else{  // 只能走1步
            int lasttemp = last;
            last = 1;
            res = (res + DFS(n-1, last));
            last = lasttemp;
        }

        memo.put(n + "_" + last, res);
        return res;
    }
}
