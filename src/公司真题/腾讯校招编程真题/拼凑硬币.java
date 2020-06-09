package 公司真题.腾讯校招编程真题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 拼凑硬币 {
    private static Map<Long,Long> map=new HashMap<>();
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        map.put(0L,1L);
        map.put(1L,1L);
        long n=in.nextLong();
        System.out.println(cal(n));
    }
    private static Long cal(long n) {
        if(map.containsKey(n)) {
            return map.get(n);
        }
        long result1=cal(n>>1);
        map.put(n>>1,result1);
        Long result;
        if(n%2==1) {
            result=result1;
        }else {
            long result2=cal((n>>1) -1);
            map.put((n>>1)-1,result2);
            result=result1+result2;
        }
        map.put(n,result);
        return result;
    }
}


//        假设 n = 1*a1+2*a2+…..+k*ak;
//        如果n为奇数：
//        n = 1 + 2*a2+….+k*ak;
//        n-1 = 2*a2+….+k*ak;
//        (n-1)>>1 = 1*a2+2*a3+…..+(k/2)*ak  = n>>1
//        设f(n)为（a1,a2,a3…ak）的解的总数
//        当n为奇数时，f(n)的解集（1,a2,a3,…ak）,f(n>>1)的解集为（a2,a3….ak）
//        解集的个数相同。
//        当n为偶数时，f(n)的解集为（0,a2,a3…ak）加上（2,a2',a3'…ak'）
//        n>>1 = 2*a2+….+k*ak; 解集为（a1,a2,a3…ak）
//        (n-2)>>1 =  1*a2'+2*a3'+…..+(k/2)*ak'  解集为（a2',a3'….ak'）
//        所以 f(n) = f(n>>1) (n为奇数)
//        f(n) = f(n>>1)+f((n-2)>>1) （n为偶数