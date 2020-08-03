package 笔试题.拼多多8_2;

import java.util.Scanner;

/*
玩飞行棋，给出初始位置K（距离终点的距离），然后给出丢了n次骰子。第二行输入n个数，代表骰子的值。
如果骰子的值没用完就到了终点，则需要输出paradox。
否则，最后输出两个数，分别代表飞行棋最终的位置，和回退的次数。（如果当前的骰子点数大于当前位置到终点的距离，
多出来的部分需要回退位置。）
输入:
10 2
6 3
输出示例 1 0
输入:
10 4
6 3 3 3
输出示例 1 2
输入:
6 3
4 2 6
输出示例 paradox

注意边界：边界条件测试的时候k可能就是0，这个时候也要输出"paradox"，另一个边界条件就是最后一个骰子掷完之后可能到终点，这个时候不能输出"paradox"
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        if (K == 0) {
            System.out.println("paradox");
            return;
        }
        int N = sc.nextInt();
        int idx = 0; //用来表示飞行棋的位置
        int count = 0;
        for (int i = 0; i < N; i++) {
            int t = sc.nextInt();
            idx += t;
            if (i !=N-1 && idx == K) {
                System.out.println("paradox");
                return;
            } else if (idx > K) {
                idx = K - (idx % K);
                count++;
            }
        }
        System.out.println((K - idx) + " " + count);
    }
}
