package 笔试题.腾讯9_7;

import java.util.*;

/*
4 2
1
2
3
4


 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sin = sc.nextLine().split(" ");
        int N = Integer.parseInt(sin[0]);
        int K = Integer.parseInt(sin[1]);


        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        Set<Map.Entry<String, Integer>> top = map.entrySet();
        List<Map.Entry<String, Integer>> toplist = new ArrayList<>(top);
        Collections.sort(toplist, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o2.getValue() - o1.getValue();
            }
        });

        for (int i = 0; i < K; i++) {
            Map.Entry<String, Integer> entry = toplist.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Set<Map.Entry<String, Integer>> bot = map.entrySet();
        List<Map.Entry<String, Integer>> botlist = new ArrayList<>(bot);
        Collections.sort(botlist, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().equals(o2.getValue()) ? o1.getKey().compareTo(o2.getKey()) : o1.getValue() - o2.getValue();
            }
        });



        for (int i = 0; i < K; i++) {
            Map.Entry<String, Integer> entry = botlist.get(i);
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
