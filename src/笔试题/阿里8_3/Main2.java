package 笔试题.阿里8_3;

import java.util.Scanner;

/*
给定一个字符串，字符串只包含abcdef 6个字母，求满足下列规则的最长子序列：
1.a必须在c,e前，c必须在e前；
2.b必须在d,f前, d必须在f前;
解法：
两个条件相互独立，可以首先把输入字符串拆分成两个只包含ace的字符串和bdf的字符串
然后求每个字符串的最长不下降子序列，和即为所求。
最长不下降子序列的求法应用二分优化，不会的可以看看leetcode最长上升子序列的解法。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int len = cs.length;
        int l1 = 0, l2 = 0;
        char[] c1 = new char[len];
        char[] c2 = new char[len];
        for (char c : cs) {
            if (c == 'a' || c == 'c' || c == 'e') c1[l1++] = c;
            if (c == 'b' || c == 'd' || c == 'f') c2[l2++] = c;
        }
        System.out.println(LIS(c1, l1) + LIS(c2, l2));
    }

    public static int LIS(char[] arr, int len) {
        int[] dp = new int[arr.length];
        int res = 0;
        for (int i = 0; i < len; i++) {
            char num = arr[i];
            int l = 0, r = res;
            while (l < r) {
                int m = (l + r) / 2;
                if (dp[m] <= num) l = m + 1;
                else r = m;
            }
            dp[l] = num;
            if (l == res) res++;
        }
        return res;
    }
}
