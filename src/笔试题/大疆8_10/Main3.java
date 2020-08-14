package 笔试题.大疆8_10;
/*
4
atmb
fueg
lyin
pkjd
4
dji
drone
flying
ideas


dji
flying
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main3 {
    static char[][] ch;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ch = new char[N][255];
        for (int i = 0; i < N; i++) {
            char[] tmp = sc.next().toCharArray();
            for (int j = 0; j < tmp.length; j++) {
                ch[i][j] = tmp[j];
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<>();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            String str = sc.next();
            if(isOK(str.toCharArray())){
                queue.offer(str);
            }
        }

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    public static boolean isOK(char[] target){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 255; j++) {
                if(ch[i][j] == target[0]){
                    if(DFS(target, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean DFS(char[] target, int x, int y, int index){
        if(index == target.length){
            return true;
        }
        if(x < 0 || x >= N || y < 0 || y >= 255 || ch[x][y] != target[index]){
            return false;
        }
        return DFS(target, x+1, y, index+1) ||
                DFS(target, x, y+1, index+1) ||
                DFS(target, x-1, y, index+1) ||
                DFS(target, x, y-1, index+1);

    }
}


