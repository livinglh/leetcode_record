package 笔试题.阿里8_3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
有n个人，每人有对应的钱币，有m个房子，每个房子有对应的价值和舒适度。
每个人只能买一个房子，每个房子只能被一个人买，求最大的舒适度和。
解法：
贪心，首先对每个人拥有的钱币大小排序，再对房子按价格大小排序。
每个人买他能买到的价格内最大舒适度的房子，总和即为所求。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] money = new int[n];
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }
        int[][] house = new int[m][2];
        for (int i = 0; i < m; i++) {
            house[i][0] = sc.nextInt();
            house[i][1] = sc.nextInt();
        }

        Arrays.sort(money);  //持有金币升序
        Arrays.sort(house, (o1, o2) -> o1[1] - o2[1]); //房间价格升序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int index = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int curmoney = money[i];
            while(index < m && house[index][1] < curmoney){
                queue.offer(house[index][0]);
                index ++;
            }
            int add = 0;
            if(!queue.isEmpty()){
                add = queue.poll();
            }
            ans += add;
        }
        System.out.println(ans);
    }
}
