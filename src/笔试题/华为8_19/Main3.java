package 笔试题.华为8_19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        String in = sc.nextLine();
        List<Integer> frame = new ArrayList<>();   // 原有方块的数字数组
        for (int i = 0; i < src.length(); i++) {
            frame.add(src.charAt(i)-'0');
        }

        List<Integer> brick = new LinkedList<>();   // 落下方块的数字数组
        for (int i = 0; i < in.length(); i++) {
            brick.add(in.charAt(i)-'0');
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < frame.size() - brick.size() + 1; i++) {
            int val = check(frame, brick, i);
            res = Math.min(res, val);
        }

        System.out.println(res);
    }

    public static int check(List<Integer> frame, List<Integer> brick, int i){
        List<Integer> tmp = new LinkedList<>(frame);
        int bricklen = brick.size();
        for (int j = i; j < i + bricklen; j++) {
            tmp.set(j, tmp.get(j) + brick.get(j-i));
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int j = 0; j < tmp.size(); j++) {
            max = Math.max(max, tmp.get(j));
            min = Math.min(min, tmp.get(j));
        }

        return max - min;
    }
}
