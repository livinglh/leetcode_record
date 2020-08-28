package 笔试题.中兴8_27;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<Character, Set<Integer>> map = new HashMap<>();
        map.put('A', new HashSet<>());
        map.put('B', new HashSet<>());
        map.put('C', new HashSet<>());
        for (int i = 0; i < n; i++) {
            String[] strin = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                if(strin[j].equals("A")){
                    map.get('A').add(i);
                }else if(strin[j].equals("B")){
                    map.get('B').add(i);
                }else{
                    map.get('C').add(i);
                }
            }
        }

        int ans = 0;
        int len1 = map.get('A').size();
        int len2 = map.get('B').size();
        int len3 = map.get('C').size();
        ans += len1 * (len1 - 1) * (len1 - 2) / 6;
        ans += len2 * (len2 - 1) * (len2 - 2) / 6;
        ans += len3 * (len3 - 1) * (len3 - 2) / 6;
        ans += len1 * len2 * len3;
        System.out.println(ans);
    }
}
