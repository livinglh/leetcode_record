package 笔试题.广联达7_29;

import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void setAdd(Set<Integer> set, Integer i) {
        if (!set.add(i)) {
            set.remove(i);
            setAdd(set, i << 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
//        LinkedHashSet<Integer> res = new LinkedHashSet<>((x, y) -> (y - x));
//        for (int i = 0; i < array.length; i++) {
//            setAdd(res, array[i]);
//        }
//        Iterator<Integer> iterator = res.iterator();
//        while (iterator.hasNext()) {
//            System.out.print(iterator.next());
//            if (iterator.hasNext()) System.out.print(" ");
//        }
    }
}
