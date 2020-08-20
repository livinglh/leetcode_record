package 笔试题.华为8_19;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        if(M <= 1000 && N <= 1000 && M >= 10 && N >= 10){
            List<int[]> ans = new LinkedList<int[]>();
            long index = 0;
            int left = 0, right = N - 1, top = 0, down = M - 1;
            while(true){
                for (int i = left; i <= right; i++) {
                    index ++;
                    if(isOK(index)){
                        ans.add(new int[]{top, i});
                    }
                }
                if(++top > down) break;
                for (int i = top; i <= down; i++) {
                    index ++;
                    if(isOK(index)){
                        ans.add(new int[]{i, right});
                    }
                }
                if(left > --right) break;
                for (int i = right; i >= left; i--) {
                    index ++;
                    if(isOK(index)){
                        ans.add(new int[]{down, i});
                    }
                }
                if(top > --down) break;
                for (int i = down; i >= top; i--) {
                    index ++;
                    if(isOK(index)){
                        ans.add(new int[]{i, left});
                    }
                }
                if(++left > right) break;
            }
            System.out.print("[");
            for (int i = 0; i < ans.size(); i++) {
                if(i == ans.size() - 1){
                    System.out.print("[" + ans.get(i)[0] + "," + ans.get(i)[1] + "]");
                }else{
                    System.out.print("[" + ans.get(i)[0] + "," + ans.get(i)[1] + "],");
                }
            }
            System.out.print("]");

        }else{
            System.out.println("[]");
        }
    }

    public static boolean isOK(long i){
        if(i % 10 == 7 && ((i / 10) & 1) == 1){
            return true;
        }
        return false;
    }
}
