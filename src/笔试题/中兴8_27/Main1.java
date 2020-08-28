package 笔试题.中兴8_27;

import java.util.*;

/*
5
A A A
A A A
B B B
C C C
C C C
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<Set<String>> chars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<String> set = new HashSet<>();
            String[] strin = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                set.add(strin[j]);
            }
            chars.add(set);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    if(cheack(chars, i, j, k)){
                        ans += 1;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public static boolean cheack(List<Set<String>> chars, int i, int j, int k){
        String[] strs = new String[]{"A","B","C"};
        for(String s : strs){
            if(chars.get(i).contains(s) && chars.get(j).contains(s) && chars.get(k).contains(s)){
                return true;
            }
        }
        for(String s1 : chars.get(i)){
            for(String s2 : chars.get(j)){
                for (String s3 : chars.get(k)){
                    if(s1.equals(s2) || s1.equals(s3) || s2.equals(s3)){
                        continue;
                    }
                    return true;
                }
            }
        }

        return false;
    }
}
