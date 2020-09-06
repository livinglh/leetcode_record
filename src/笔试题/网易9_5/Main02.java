package 笔试题.网易9_5;

import java.util.Scanner;

/*
1
4 4
....
....
....
....
3 3
.O.
abc
.ac
0 0 1 1

26
 */


// 0
public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {  //T组数据
            int lastsum = 0, sum = 0;
            String[] s1 = sc.nextLine().split(" ");
            int W = Integer.parseInt(s1[0]);
            int H = Integer.parseInt(s1[1]);
            char[][] chsrc = new char[H+1][W+1];
            char[][] ch = new char[H+1][W+1];
            for (int j = 1; j <= H; j++) {
                char[] c = sc.nextLine().toCharArray();
                for (int k = 1; k <= W; k++) {
                    ch[j][k] = c[k-1];
                    chsrc[j][k] = c[k-1];
                }
            }

            String[] s2 = sc.nextLine().split(" ");
            int PW = Integer.parseInt(s2[0]);
            int PH = Integer.parseInt(s2[1]);
            char[][] pch = new char[PH][PW];
            for (int j = 0; j < PH; j++) {
                char[] c = sc.nextLine().toCharArray();
                pch[j] = c;
            }
            String[] s3 = sc.nextLine().split(" ");
            int si = Integer.parseInt(s3[0]);
            int sj = Integer.parseInt(s3[1]);
            int vi = Integer.parseInt(s3[2]);
            int vj = Integer.parseInt(s3[3]);


            while(si <= H || sj <= W){
//                sum += lastsum;
//                lastsum = 0;
//                for (int j = 0; j < PH; j++) {
//                    int cursi = si + j;
//                    if(cursi < 1){
//                        continue;
//                    }
//                    for (int k = 0; k < PW; k++) {
//                        int cursj = sj + k;
//                        if(cursj < 1){
//                            continue;
//                        }
//                        if(cheack(ch, cursi, cursj)){
//                            if(pch[j][k] != ch[cursi][cursj]){
//                                ch[cursi][cursj] = pch[j][k];
//                                sum+=1;
//                            }
//                            if(j <= vi && k <= vj && !(cursi == si + vi && cursj == sj + vj)){
//                                lastsum += 1;
//                            }
//                        }
//                    }
//                }
                int esi = si + PH - 1;
                int esj = sj + PW - 1;
                for (int j = 1; j <= H; j++) {
                    for (int k = 1; k <= W; k++) {
                        if(j >= si && j <= esi && k >= sj && k <= esj){
                            if(pch[j-si][k-sj] != ch[j][k]){
                                ch[j][k] = pch[j-si][k-sj];
                                sum+=1;
                            }
                        }
                        else {
                            if(ch[j][k] != chsrc[j][k]){
                                sum += 1;
                                ch[j][k] = chsrc[j][k];
                            }
                        }
                    }
                }

                si += vi;
                sj += vj;
            }


            System.out.println(sum);
        }
    }

    public static boolean cheack(char[][] nums, int i, int j){
        if(i < 1 || i >= nums.length || j < 1 || j >= nums[0].length){
            return false;
        }
        return true;
    }
}
