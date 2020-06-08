package 笔试题.vivo6_17;

import org.junit.Test;

public class 花坛 {
    public int solve(int n, int[] nums){
        int pre = -1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if ((i - pre) % 2 == 1) {
                    res += (i - pre) / 2;
                } else {
                    res += (i - 1 - pre) / 2;
                }
                pre = i;
                break;
            }
        }
        for (int i = pre+1; i < nums.length; i++) {
            if(nums[i] == 1){
                if ((i - pre) % 2 == 1) {
                    res += (i + 1 - pre) / 2 - 1;
                } else {
                    res += (i - pre) / 2 - 1;
                }
                pre = i;
            }
        }
        if((n-pre)%2 == 1){
            res += (n-pre)/2;
        }
        else{
            res += (n-1-pre)/2;
        }
        return res;
    }
    @Test
    public void test() {
        return;
    }
}
