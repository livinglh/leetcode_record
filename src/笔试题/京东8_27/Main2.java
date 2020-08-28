package 笔试题.京东8_27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static long ans = 0;
    static int n = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<List<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> curnums = new ArrayList<>();
            for (int j = 0; j < 2 * (i + 1) - 1; j++) {
                curnums.add(sc.nextInt());
            }
            nums.add(curnums);
        }
        DFS(nums, 0, 0, 0);
        System.out.println(ans);
    }


    public static void DFS(List<List<Integer>> nums, int cur, int cursum, int index){
        if(cur == n){
            ans = Math.max(ans, cursum);
            return;
        }

        DFS(nums, cur+1, cursum+nums.get(cur).get(index), index);
        DFS(nums, cur+1, cursum+nums.get(cur).get(index), index+1);
        DFS(nums, cur+1, cursum+nums.get(cur).get(index), index + 2);
    }
}
