package 笔试题.搜狗9_5;

import java.util.Scanner;
// 80
public class Main6 {
    static int sum = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
            DFS(i, 1, s);
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sum);
    }

    public static void DFS(int cur, int index, String s){
        if(index == s.length()){
            if(!sb.toString().equals(s)){
                sum += 1;
            }
            return;
        }
        int twoSum = (cur + (s.charAt(index) - '0'));
        if(twoSum % 2 == 0){
            sb.append(twoSum / 2);
            DFS(twoSum / 2, index + 1, s);
            sb.deleteCharAt(sb.length()-1);
        }else{
            sb.append(twoSum / 2);
            DFS(twoSum / 2, index + 1, s);
            sb.deleteCharAt(sb.length()-1);
            sb.append(twoSum / 2 + 1);
            DFS(twoSum / 2 + 1, index + 1, s);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
