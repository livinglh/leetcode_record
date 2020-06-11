package 公司真题.腾讯2018春招;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 题目有点问题
public class 安排机器 {

    static class Pair {
        int time;
        int diff;

        public Pair(int time, int diff) {
            this.time = time;
            this.diff = diff;
        }
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int machineNum = sc.nextInt();
            int taskNum = sc.nextInt();
            Pair[] machines = new Pair[machineNum];
            Pair[] tasks = new Pair[taskNum];
            for (int i = 0; i < machineNum; i++) {
                machines[i] = new Pair(sc.nextInt(), sc.nextInt());
            }
            for (int i = 0; i < taskNum; i++) {
                tasks[i] = new Pair(sc.nextInt(), sc.nextInt());
            }
            Comparator<Pair> cmp = new Comparator<Pair>() {

                @Override
                public int compare(Pair p1, Pair p2) {
                    if (p1.time == p2.time) {
                        return p2.diff - p1.diff;
                    } else {
                        return p2.time - p1.time;
                    }
                }

            };
            Arrays.sort(machines, cmp);
            Arrays.sort(tasks, cmp);
            long sum = 0;
            int count = 0;
            int j = 0;
            int[] dp = new int[101];
            for (int i = 0; i < taskNum; i++) {
                while (j < machineNum && machines[j].time >= tasks[i].time) {
                    dp[machines[j].diff]++;
                    j++;
                }
                for (int k = tasks[i].diff; k < 101; k++) {
                    if (dp[k] != 0) {
                        dp[k]--;
                        sum += 200 * tasks[i].time + 3 * tasks[i].diff;
                        count++;
                        break;
                    }
                }
            }
            System.out.println(count + " " + sum);
        }
        sc.close();
    }
}
