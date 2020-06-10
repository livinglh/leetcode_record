package 公司真题.腾讯校招编程真题;

import java.util.Scanner;

public class geohash编码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int left = -90, right = 90;
        StringBuilder rsb = new StringBuilder();
        while(right > left && rsb.length() != 6){
            int mid = (left+right)/2;
            if(N >= mid){
                left = mid;
                rsb.append(1);
            }else{
                right = mid;
                rsb.append(0);
            }
        }

        System.out.println(rsb.toString());
    }
}
