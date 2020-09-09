package 笔试题.腾讯9_7;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        PriorityQueue<Integer> queue1 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < n; i++) {
            queue1.add(nums[i]);
            queue2.add(queue1.poll());
            if(queue2.size() > queue1.size()){
                queue1.add(queue2.poll());
            }
        }

        int pre = queue1.peek();
        int post = queue2.peek();
        for (int i = 0; i < n; i++) {
            if(nums[i] < post){
                System.out.println(post);
            }else{
                System.out.println(pre);
            }
        }
    }
}
