package 笔试题.shopee8_19;

public class Main3 {
    public static int calEncodeNumber (int length) {
        // write code here
        boolean[] Bit = new boolean[length + 1];
        long res = 1;
        for(int i = 2; i <= length; i++){
            if(Bit[i]){
                continue;
            }
            for(int j = 2*i; j <= length; j = j+i){
                Bit[j] = true;
            }
            int count = 0;
            long n = i;
            while( n <= length){
                n = n * i;
                count++;
            }
            res = res * (count + 1) % 1000000369;
        }
        return (int) res;
    }
//    static long ans = 0;
//    static StringBuilder sb = new StringBuilder();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        DFS(0, n);
//        System.out.println(ans);
//    }
//
//    public static void DFS(int cur, int target){
//        if(cur == target){
//            if(isOK(sb.toString())){
//                ans = (ans + 1) % 1000000369;
//            }
//            return;
//        }
//        sb.append('Y');
//        DFS(cur+1, target);
//        sb.deleteCharAt(sb.length()-1);
//        if(cur != 0){
//            sb.append('N');
//            DFS(cur+1, target);
//            sb.deleteCharAt(sb.length()-1);
//        }
//    }
//
//    public static boolean isOK(String s){
//        for (int i = 0; i < s.length(); i++) {
//            if(s.charAt(i) == 'N'){
//                continue;
//            }
//            int cur = i + 1;
//            for (int j = 1; j < (int)Math.sqrt(cur) + 1; j++) {
//                if(cur % j == 0){
//                    if(s.charAt(j-1) != 'Y' || s.charAt(cur / j - 1) != 'Y'){
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
}

