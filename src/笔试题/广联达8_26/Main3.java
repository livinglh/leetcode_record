package 笔试题.广联达8_26;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] nums = new Integer[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            map.put(nums[i], i);
        }

        Arrays.sort(nums, Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if(map.get(nums[i]) < map.get(nums[i+1])){
                map.put(nums[i+1], -1);
                ans ++;
            }
        }
        System.out.println(ans);
    }
}
