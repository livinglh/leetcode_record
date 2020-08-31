package 笔试题.顺丰8_29;

import java.util.Scanner;

/*
9
-1 -1 -1 4 5 -1 8 1 2


2
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int ans = 0;
        boolean flag = false; //是否进入等差序列
        int cha = 0; //差
        int num1 = 0; // -1个数
        int last = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {
                num1 += 1;
                continue;
            } else {
                if (i == 0) {
                    last = nums[i];
                    continue;
                } else if (nums[i - 1] == -1) {
                    if (flag == false) {
                        if (last == -1) {
                            last = nums[i];
                            continue;
                        } else {
                            if ((nums[i] - last) % (num1 + 1) == 0) {
                                flag = true;
                                cha = (nums[i] - last) / (num1 + 1);
                                num1 = 0;

                            } else {
                                flag = false;
                                ans += 1;
                            }
                        }
                    } else {
                        if ((nums[i] - last) % (num1 + 1) == 0) {
                            int curcha = (nums[i] - last) / (num1 + 1);
                            if(curcha != cha){
                                ans += 1;
                                flag = false;
                            }
                        } else {
                            flag = false;
                            ans += 1;
                        }
                    }
                } else if (nums[i - 1] != -1 && flag == false) {
                    num1 = 0;
                    flag = true;
                    cha = nums[i] - nums[i - 1];
                } else {
                    if (nums[i] - nums[i - 1] == cha) {
                        continue;
                    } else {
                        ans += 1;
                    }
                }

                last = nums[i];

            }
        }
        System.out.println(ans + 1);

    }
}
