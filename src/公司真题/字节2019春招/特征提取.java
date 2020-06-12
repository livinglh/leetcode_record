package 公司真题.字节2019春招;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 特征提取 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        HashMap<String, Integer> preMap = new HashMap<>();
        HashMap<String, Integer> curMap = new HashMap<>();
        int N = sc.nextInt();
        // N个测试用例
        for (int i = 0; i < N; i++) {
            int Max = 1;
            int M = sc.nextInt();
            // M个帧
            for (int j = 0; j < M; j++) {
                // 该帧有K个特征
                curMap.clear();
                int K = sc.nextInt();
                for (int k = 0; k < K; k++) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    String key = x + "_" + y;
                    curMap.put(key, preMap.getOrDefault(key, 0) + 1);
                    Max = Math.max(Max, curMap.get(key));
                }
                preMap.clear();
                preMap.putAll(curMap);
            }
            System.out.println(Max);
        }
    }

}
