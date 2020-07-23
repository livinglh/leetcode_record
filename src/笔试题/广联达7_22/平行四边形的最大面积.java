package 笔试题.广联达7_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//给定一个数组，取四条边组成最大平行四边形的面积，输入数组，输出最大面积。
public class 平行四边形的最大面积 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] lines = new long[n];
        int i = 0;
        while (i < n) {
            lines[i++] = scanner.nextInt();
        }
        Arrays.sort(lines);
        List<Long> side = new ArrayList<>();
        int count = 1;
        for (i = n - 1; i >= 0; i--) {
            if (side.size() >= 2) {
                break;
            }
            if (i > 0 && lines[i] == lines[i - 1]) {
                count++;
            } else {
                if (count >= 4) {
                    side.add(lines[i]);
                    side.add(lines[i]);
                } else if (count >= 2) {
                    side.add(lines[i]);
                }
                count = 1;
            }
        }
        if (side.size() < 2) {
            System.out.println(-1);
        } else {
            System.out.println(side.get(0) * side.get(1));
        }
    }
}
