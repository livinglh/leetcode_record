package 笔试题.电信云9_9;

public class Main7 {
    public static void main(String[] args) {
        int a, b, c, d;
        for (int i = 0; i < 10000; i++) {
            a = i / 1000;
            b = (i - a * 1000) / 100;
            c = (i - a * 1000 - b * 100) / 10;
            d = i - a * 1000 - b * 100 - c * 10;
            if(i + b * 1000 + c * 100 + d * 10 + a == 8888 && d >= 0){
                System.out.println(a + " " + b + " " + c + " " + d);
            }
        }
    }
}
