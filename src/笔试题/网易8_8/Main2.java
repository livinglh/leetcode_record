package 笔试题.网易8_8;

/*
给定 n，再给了一个排列 T，扩充成排列 S（数字 1 - n 各使用一次）。问最小字典序的S
 */

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            list.add(x);
            set.add(x);
        }
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if(set.contains(i)){
                continue;
            }
            while(index < list.size() && list.get(index) < i){
                index++;
            }
            list.add(index, i);
        }

        for(int i : list){
            System.out.print(i + " ");
        }
    }
}

