package 笔试题.阿里8_7;

import java.util.Scanner;

public class Main2 {
    static String s;
    static String[] a;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        n = sc.nextInt();
        a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next();
        }
//        Arrays.sort(a, new Comparator<String>() {
//            public int compare(String o1, String o2) {
//                return o2.length() - o1.length();
//            }
//        });
        int count = 0;
        while (true) {
            count = -1;
            for (int i = 0; i < n; i++) {
                int start = s.indexOf(a[i]);
                if (start != -1) {
                    s = s.substring(0, start) + s.substring(start + a[i].length());
                    count = 0;
                    break;
                }
            }
            if (count == -1) {
                break;
            }
        }
        System.out.println(s);
    }
}

