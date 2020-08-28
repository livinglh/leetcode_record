package 笔试题.海康8_28;

public class Main2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) { // 质数
            boolean flag = true;
            for (int k = 2; k <= (int)Math.sqrt(i) + 1; k++) { // 除数
                // 排除所有在 i=k 之前 能被k整除(余数为0)的数
                if (i % k == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println(i);
            }
        }
    }
}
