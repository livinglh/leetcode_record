package leetcode.editor.cn;

public class inter_code {
    public static void main(String[] args) {
        Solution solution = new inter_code().new Solution();
        int ans = solution.solve("0001111000000011111");
        System.out.println(ans);
    }

    class Solution{
        // 给定任意正整数n，请寻找并输出最小的正整数m（m>9)，使m的各位之积等于n，若不存在则输出-1
        // 36 /49
//        public int solve(int n){
//            int ans = recur(n);
//            if(ans<0) return -1;
//            return ans;
//        }
//        public int recur(int n){
//            if(n<10) return n;
//            for (int i = 9; i > 1; i--) {
//                if (n % i == 0)
//                    return recur(n / i) * 10 + i;
//            }
//            return -1;
//        }
        //第一天1台，接下来两天（第二天，第三天）每天2台，接下来三天每天3台，问，第n天总共多少台？
        //11 /35
//        public int solve(int n){
//            // 法1
////            int day_count = 1;
////            int day = 0;
////            int sum = 0;
////            while(day + day_count < n) {
////                sum += day_count * day_count;
////                day += day_count;
////                day_count ++;
////            }
////            sum += day_count * (n-day);
////            return sum;
//
//            // 法2 dp[i] 为第i天的产量
//            int[] dp = new int[n+1];
//            int day_count = 1;
//            int count = 0;
//            dp[0] = 0;
//            for(int i = 1; i < n+1; i++){
//                dp[i] = dp[i-1] + day_count;
//                count ++;
//                if(count == day_count){
//                    count = 0;
//                    day_count++;
//                }
//            }
//            return dp[n];
//        }
        // 安卓解锁模式
//        我们都知道安卓有个手势解锁的界面，是一个 3 x 3 的点所绘制出来的网格。
//
//        给你两个整数，分别为 m 和 n，其中 1 ≤ m ≤ n ≤ 9，那么请你统计一下有多少种解锁手势，是至少需要经过 m 个点，但是最多经过不超过 n 个点的。
//
//        先来了解下什么是一个有效的安卓解锁手势:
//
//        每一个解锁手势必须至少经过 m 个点、最多经过 n 个点。
//        解锁手势里不能设置经过重复的点。
//        假如手势中有两个点是顺序经过的，那么这两个点的手势轨迹之间是绝对不能跨过任何未被经过的点。
//        经过点的顺序不同则表示为不同的解锁手势
        // 1 1 / 9
//        public int solve(int m, int n){
//            int[][] jumps = new int[10][10]; //利用一个数组记录两点间的跳跃点
//            jumps[1][3] = jumps[3][1] = 2;
//            jumps[4][6] = jumps[6][4] = 5;
//            jumps[7][9] = jumps[9][7] = 8;
//            jumps[1][7] = jumps[7][1] = 4;
//            jumps[2][8] = jumps[8][2] = 5;
//            jumps[3][9] = jumps[9][3] = 6;
//            jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
//
//            boolean[] visited = new boolean[10];
//            int ans = 0; //满足条件的方案数
//            ans += find(1,0,1,m,n,jumps,visited) * 4;
//            ans += find(2,0,1,m,n,jumps,visited) * 4;
//            ans += find(5,0,1,m,n,jumps,visited) * 1;
//            return ans;
//        }
//        public int find(int i, int ans, int step, int m, int n, int[][] jumps, boolean[] visited){
//
//            if(step == n){
//                ans ++;
//                return ans;
//            }
//            if(step >= m) ans++;
//            visited[i] = true;
//            for (int next = 1; next < 10; next++) {
//                if(!visited[next] && (jumps[i][next] == 0 || visited[jumps[i][next]]))
//                    ans = find(next,ans,step+1,m,n,jumps,visited);
//            }
//            visited[i] = false;
//            return ans;
//        }
        public int solve(String str){
            char[] chars = str.toCharArray();
            int max = 0;
            int tempmax = 0;
            for(int i = 0; i < chars.length; i++){
                if(i == 0) tempmax = chars[i]=='1'? 1:0;
                else if(chars[i] == '1' && chars[i-1] == '1') tempmax += 1;
                else if(chars[i] == '1' && chars[i-1] == '0') tempmax=1;
                else if(chars[i] == '0' && chars[i-1] == '1') max = Math.max(max,tempmax);
                else continue;
            }
            return Math.max(max,tempmax);
        }
    }
}
