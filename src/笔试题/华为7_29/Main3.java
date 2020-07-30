package 笔试题.华为7_29;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<>();
        String start;
        while(true){
            String s = sc.nextLine();
            String[] sleft = s.split("\\(");
            String[] skong = s.split(" ");
            if(sleft[0].equals("sizeof")){
                start = sleft[1].split("\\)")[0];
                break;
            }else if(skong[0].equals("struct")){
                String keystring = skong[1];
                List<String> value = new ArrayList<>();
                while(true){
                    String seach = sc.nextLine();
                    if(seach.equals("};")){
                        break;
                    }
                    String[] sseach = seach.split(" ");
                    if(sseach[4].equals("struct")){
                        value.add(sseach[5]);
                    }else{
                        value.add(sseach[4]);
                    }
                }
                map.put(keystring, value);
            }
        }

        int ans = DFS(map, start);

        System.out.println(ans);
    }

    public static int DFS(Map<String, List<String>> map, String s){
        if(s.equals("char")) return 1;
        if(s.equals("short")) return 2;
        if(s.equals("long")) return 4;
        if(!map.containsKey(s)) return 0;
        List<String> slist = map.get(s);
        int res = 0;
        for(String sl : slist){
            int r = DFS(map, sl);
            if(r == -1) return 0;
            res += r;
        }
        return res;
    }
}

