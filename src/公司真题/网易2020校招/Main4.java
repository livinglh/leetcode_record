package 公司真题.网易2020校招;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int nums1 = sc.nextInt();
            int nums2 = sc.nextInt();
            if(nums1 == 1){
                list.add(nums2);
            }else{
                int end = 0;
                for(int num : list){
                    if((num | nums2) == nums2){
                        end |= num;
                    }
                }
                if(end == nums2){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
}
