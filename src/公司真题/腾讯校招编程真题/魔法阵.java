package 公司真题.腾讯校招编程真题;

import java.util.Arrays;
import java.util.Scanner;

public class 魔法阵 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[2][4];
        String[] res = new String[N];
        double[] temp = new double[6];
        String s = String.valueOf(sc.nextLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                s = String.valueOf(sc.nextLine());
                for (int k = 0; k < 4; k++) {
                    nums[j][k] = Integer.parseInt(s.charAt(k) + "");
                }
            }
            temp[0] = Math.pow(nums[0][0]-nums[0][2],2) + Math.pow(nums[1][0]-nums[1][2],2);
            temp[1] = Math.pow(nums[0][0]-nums[0][3],2) + Math.pow(nums[1][0]-nums[1][3],2);
            temp[2] = Math.pow(nums[0][0]-nums[0][1],2) + Math.pow(nums[1][0]-nums[1][1],2);
            temp[3] = Math.pow(nums[0][1]-nums[0][2],2) + Math.pow(nums[1][1]-nums[1][2],2);
            temp[4] = Math.pow(nums[0][1]-nums[0][3],2) + Math.pow(nums[1][1]-nums[1][3],2);
            temp[5] = Math.pow(nums[0][2]-nums[0][3],2) + Math.pow(nums[1][2]-nums[1][3],2);

            Arrays.sort(temp);
            if(temp[0] == temp[1] && temp[0] == temp[2] && temp[0] == temp[3]
                    && temp[4] == temp[5] && temp[0] + temp[1] == temp[4]){
                res[i] = "Yes";
            }else{
                res[i] = "No";
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(res[i]);
        }
    }

}
