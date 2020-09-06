package 笔试题.网易9_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// ac
public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> namemap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] strin = sc.nextLine().split(" ");
            String id = strin[0];
            String name = strin[1];
            namemap.put(name, namemap.getOrDefault(name, 0)+1);
        }

        int sum = 0;
        for(String key : namemap.keySet()){
            if(namemap.get(key) >= 2){
                sum += 1;
            }
        }

        System.out.println(sum);
    }
}
