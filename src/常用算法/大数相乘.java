package 常用算法;

public class 大数相乘 {
    public static void main(String[] args) {
        int[] ans = bigNumberMultiply(new int[]{1,0,0}, new int[]{1,1});
        for (int i : ans) {
            System.out.print(i);
        }
    }


    public static int[] bigNumberMultiply(int[] num1, int[] num2){
        // 分配一个空间，用来存储运算的结果，num1长的数 * num2长的数，结果不会超过num1+num2长
        int[] result = new int[num1.length + num2.length];
        // 先不考虑进位问题，根据竖式的乘法运算，num1的第i位与num2的第j位相乘，结果应该存放在结果的第i+j位上
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                result[i + j + 1] += num1[i] * num2[j];  // (因为进位的问题，最终放置到第i+j+1位)
            }
        }

        //单独处理进位
        for(int k = result.length-1; k > 0; k--){
            if(result[k] > 10){
                result[k-1] += result[k] / 10;
                result[k] %= 10;
            }
        }
        return result;
    }
}
