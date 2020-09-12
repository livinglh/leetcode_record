package 笔试题.bigo9_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> ans = find(nums);
        for(List<Integer> each : ans){
            for(Integer i : each){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> find(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || i > 0 && nums[i] != nums[i-1]){
                int l = i + 1, r = nums.length - 1, target = 0 - nums[i];
                while(l < r){
                    if(nums[l] + nums[r] == target){
                        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1]){
                            l ++;
                        }
                        while(l < r && nums[r] == nums[r-1]){
                            r --;
                        }

                        l++;
                        r--;
                    }else if(nums[l] + nums[r] < target){
                        while(l < r && nums[l] == nums[l + 1]){
                            l ++;
                        }
                        l++;
                    }else{
                        while(l < r && nums[r] == nums[r-1]){
                            r --;
                        }
                        r--;
                    }
                }
            }
        }

        return ans;
    }
}
