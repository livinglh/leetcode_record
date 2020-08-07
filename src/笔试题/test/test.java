package 笔试题.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str = br.readLine()) != null) {
            String[] temp = str.split(" ");
            int count = Integer.parseInt(temp[0]); // 技能个数
            int magic = Integer.parseInt(temp[1]); // 角色魔法值
            int roletime = Integer.parseInt(temp[2]); // 角色存活时间
            int[] hurt = new int[count]; // 技能伤害值
            int[] cost = new int[count]; // 技能消耗的魔法值
            int[] cooltime = new int[count]; // 技能冷却时间
            int[] times = new int[count]; // 每个技能最多使用次数
            for(int i = 0; i < count; i++) {
                String[] data = br.readLine().split(" ");
                hurt[i] = Integer.parseInt(data[0]);
                cost[i] = Integer.parseInt(data[1]);
                cooltime[i] = Integer.parseInt(data[2]);
                //times[i] = Math.min(magic / cost[i], roletime / cooltime[i]);
                times[i] = roletime % cooltime[i] == 0 ? roletime / cooltime[i] : roletime / cooltime[i] + 1;
            }
            int[] dp =new int[magic + 1];
            for(int i = 0; i < count; i++) { // 技能总个数
                for(int j = magic; j >= cost[i]; j--) { // 魔法值
                    for(int k = 1; k <= times[i] && k * cost[i] <= j; k++) {
                        dp[j] = Math.max(dp[j], dp[j - k * cost[i]] + k * hurt[i]);
                    }
                }
            }
            System.out.println(dp[magic]);
        }
    }
}
