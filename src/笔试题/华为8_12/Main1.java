package 笔试题.华为8_12;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.next().split(",");
        boolean ans1 = true;
        int ans2 = 0;
        int[] value = new int[3];
        for (int i = 0; i < strs.length; i++) {
            int need = Integer.valueOf(strs[i]);
            if(need == 5){
                value[0] += 1;
                continue;
            }else if(need == 10){
                if(value[0] >= 1){
                    value[0] -= 1;
                    value[1] += 1;
                }else{
                    ans1 = false;
                    ans2 = i+1;
                    break;
                }
            }else{
                if(value[0]>=1 && value[1]>=1){
                    value[0] -= 1;
                    value[1] -= 1;
                    value[2] += 1;
                }else if(value[0] >= 3){
                    value[0] -= 3;
                    value[2] += 1;
                }else{
                    ans1 = false;
                    ans2 = i+1;
                    break;
                }
            }
        }
        ans2 = ans1 == true ? strs.length : ans2;
        System.out.println(ans1 + "," + ans2);
    }
}
