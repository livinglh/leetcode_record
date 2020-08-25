package 笔试题.美团8_22;

import java.util.Arrays;
import java.util.Scanner;

/*
5 1
5 10
8 9
1 4
7 9
6 10
 */
public class Main2 {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int i = 1; i <= n; i++) {
//            map.put(i, sc.nextInt() + sc.nextInt() * 2);
//        }
//
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//        Collections.sort(list, (o1, o2) -> {
//            if(o2.getValue().equals(o1.getValue())){
//                return o1.getKey() - o2.getKey();
//            }else{
//                return o2.getValue() - o1.getValue();
//            }
//        });
//
//        for (int i = 0; i < m - 1; i++) {
//            System.out.print(list.get(i).getKey() + " ");
//        }
//        System.out.print(list.get(m-1).getKey());

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[][] d = new int[n][2]; //d[i][0]存放订单价格，d[i][1]存放订单编号
        for (int i = 0; i < n; i++) {
            d[i][0] = v[i] + 2 * w[i];
            d[i][1] = i + 1;
        }
        Arrays.sort(d, (d1,d2)->{
            if(d1[0] < d2[0]) return 1;
            else if(d1[0] > d2[0]) return -1;
            else return d1[1] - d2[1];
        });
        int cnt = Math.min(n, m);
        int[] ans = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            ans[i] = d[i][1];
        }
        Arrays.sort(ans);
        for (int i = 0; i < cnt; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
