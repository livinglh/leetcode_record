package 笔试题.腾讯9_7;

import java.util.*;

/*
50 5
2 1 2
5 10 11 12 13 14
2 0 1
2 49 2
4 6 7 8 2


7
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] flagp = new int[n];
        int[] flagz = new int[m];
        List<Set<Integer>> nums2zu = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> setnums2zu = new HashSet<>();
            nums2zu.add(setnums2zu);
        }
        List<Set<Integer>> zu = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> setzu = new HashSet<>();
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int cur = sc.nextInt();
                nums2zu.get(cur).add(i);
                setzu.add(cur);
            }
            zu.add(setzu);
        }

        Queue<Integer> queue = new LinkedList<>();
        flagp[0] = 1;
        int sum = 1;

        for(int cur : nums2zu.get(0)){
            queue.offer(cur);
            flagz[cur] = 1;
        }
        while(!queue.isEmpty()){
            int curzu = queue.poll();
            for(int eve : zu.get(curzu)){
                if(flagp[eve] == 0){
                    flagp[eve] = 1;
                    sum += 1;
                    for(int cur : nums2zu.get(eve)){
                        if(flagz[cur] != 1){
                            flagz[cur] = 1;
                            queue.offer(cur);
                        }
                    }
                }
            }
        }



        System.out.println(sum);


//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] flagp = new int[n];
//        int[] flagz = new int[m];
//        List<Set<Integer>> nums2zu = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            Set<Integer> setnums2zu = new HashSet<>();
//            nums2zu.add(setnums2zu);
//        }
//        List<Set<Integer>> zu = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            Set<Integer> setzu = new HashSet<>();
//            int k = sc.nextInt();
//            for (int j = 0; j < k; j++) {
//                int cur = sc.nextInt();
//                nums2zu.get(cur).add(i);
//                setzu.add(cur);
//            }
//            zu.add(setzu);
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        flagp[0] = 1;
//        int sum = 1;
//
//        for(int cur : nums2zu.get(0)){
//            queue.offer(cur);
//            flagz[cur] = 1;
//        }
//        while(!queue.isEmpty()){
//            int curzu = queue.poll();
//            for(int eve : zu.get(curzu)){
//                if(flagp[eve] == 0){
//                    flagp[eve] = 1;
//                    sum += 1;
//                    for(int cur : nums2zu.get(eve)){
//                        if(flagz[cur] != 1){
//                            flagz[cur] = 1;
//                            queue.offer(cur);
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(sum);
    }
}
