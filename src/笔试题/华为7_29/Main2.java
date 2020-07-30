package 笔试题.华为7_29;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] sdist = s1.split(",");
        int[] dist = Arrays.stream(sdist).mapToInt(Integer::parseInt).toArray();
        String s2 = sc.nextLine();
        String[] sduche = s2.split(",");
        int[] duche = Arrays.stream(sduche).mapToInt(Integer::parseInt).toArray();
        String s3 = sc.nextLine();
        String[] snumred = s3.split(",");
        int[] numred = Arrays.stream(snumred).mapToInt(Integer::parseInt).toArray();
        String s4 = sc.nextLine();
        String[] sleavl = s4.split(",");
        int[] leavl = Arrays.stream(sleavl).mapToInt(Integer::parseInt).toArray();

        int n = dist.length;

        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = (int) ((dist[i] - duche[i]) / 10.0 + duche[i] / 2.0 + numred[i] / 2.0 * 15);
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(time[i],i);
        }

        Arrays.sort(time);
        int mintime = time[0];
        int maxlevel = leavl[map.get(mintime)];
        int best = map.get(mintime);
        int besttime = time[0];
        for (int i = 1; i < n; i++) {
            if(time[i] >= mintime + 60) break;
            if(leavl[map.get(time[i])] > maxlevel){
                maxlevel = leavl[map.get(time[i])];
                best = map.get(time[i]);
                besttime = time[i];
            }
        }

        System.out.println(best+1 + "," + besttime);
    }
}

//1530,1760,2300,1990
//        240,320,0,0
//        2,1,0,0
//        8,10,10,9