package 笔试题.拼多多9_1;//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
///*
//4 4
//1 0 1 1
//1 1 0 1
//0 0 0 0
//1 1 1 1
//
//
//1 0 1 1
//1 1 0 0
//0 0 0 0
//1 1 1 1
//
//8
// */
//public class Main2 {
//    static int[] dx = {0, 0, -1, 1};
//    static int[] dy = {-1, 1, 0, 0};
//    static int N;
//    static int M;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        N = sc.nextInt();
//        M = sc.nextInt();
//        int[][] nums = new int[N][M];
//        int[][] newnums = new int[N][M];
//        List<int[]> value1 = new ArrayList<>();
//        List<int[]> value0 = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                nums[i][j] = sc.nextInt();
//                if(nums[i][j] == 0){
//                    value0.add(new int[]{i,j});
//                }else{
//                    value1.add(new int[]{i,j});
//                }
//            }
//        }
//
////        int ans = 0;
////        for (int i = 0; i < value1.size(); i++) {
////            int x1 = value1.get(i)[0], y1 = value1.get(i)[1];
////            nums[x1][y1] = 0;
////            for (int j = 0; j < value0.size(); j++) {
////                int x0 = value0.get(j)[0], y0 = value0.get(j)[1];
////                nums[x0][y0] = 1;
////                for (int k = 0; k < N; k++) {
////                    for (int l = 0; l < M; l++) {
////                        newnums[k][l] = nums[k][l];
////                    }
////                }
////                int res = findmax(newnums);
////                ans = Math.max(ans, res);
////                nums[x0][y0] = 0;
////            }
////            nums[x1][y1] = 1;
////        }
//
////
////        nums[2][0] = 1;
////        nums[1][3] = 0;
//        int max = findmax(nums);
//
//        System.out.println(max);
//    }
//
//    public static int findmax(int[][] nums){
//        int max = 0;
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if(nums[i][j] == 0){
//                    continue;
//                }
//                max = Math.max(max, DFS(nums, i, j));
//            }
//        }
//        return max;
//    }
//
//
//    public static int DFS(int[][] nums, int i, int j){
//        if(i < 0 || j < 0 || i >= nums.length || j >= nums[i].length || nums[i][j] == 0){
//            return 0;
//        }
//        int sum = 1;
//        nums[i][j] = 0;
//        for (int k = 0; k < 4; k++) {
//            sum += DFS(nums, i+dx[k], j+dy[k]);
//        }
//        return sum;
//    }
//
//
//
//    public static int DFS2(int[][] nums, int i, int j, int use){
//        if(i < 0 || j < 0 || i >= nums.length || j >= nums[i].length){
//            return 0;
//        }
//
//        if(nums[i][j] == 0 && use == 1){
//            int sum1 = 1;
//            nums[i][j] = 0;
//            for (int k = 0; k < 4; k++) {
//                sum1 += DFS2(nums, i+dx[k], j+dy[k], use--);
//            }
//            int sum2 = 1;
//            nums[i][j] = 0;
//            for (int k = 0; k < 4; k++) {
//                sum1 += DFS2(nums, i+dx[k], j+dy[k], use--);
//            }
//
//            return sum;
//        }else{
//            int sum = 1;
//            nums[i][j] = 0;
//            for (int k = 0; k < 4; k++) {
//                sum += DFS(nums, i+dx[k], j+dy[k]);
//            }
//            return sum;
//        }
//    }
//
//
//
////    public static int DFS(int[][] nums, boolean[][] visited, int i, int j, int use){
////        visited[i][j] = true;
////        if(i < 0 || j < 0 || i >= nums.length || j >= nums[i].length){
////            return 0;
////        }
////        if(nums[i][j] == 0 && use == 0){
////            return 0;
////        }else if(nums[i][j] == 0 && use == 1){
////            use --;
////            int sum = 1;
////            nums[i][j] = 0;
////            for (int k = 0; k < 4; k++) {
////                sum += DFS(nums, visited, i+dx[k], j+dy[k], use);
////            }
////            return sum;
////        }else{
////            int sum = 1;
////            nums[i][j] = 0;
////            for (int k = 0; k < 4; k++) {
////                sum += DFS(nums, visited, i+dx[k], j+dy[k], use);
////            }
////            return sum;
////        }
////    }
////
////    public static boolean check(int[][] nums, boolean[][] visited, int i, int j){
////        if(i < 0 || j < 0 || i >= nums.length || j >= nums[i].length || visited[i][j]){
////            return false;
////        }
////        return true;
////    }
//}
