package 笔试题.广联达7_22;

// 在一个2D横版游戏中，所有的怪物都是在X轴上的，每个怪物有两个属性X和HP，分别代表怪物的位置和生命值。
// 玩家控制的角色有一个AOE（范围攻击）技能，玩家每次释放技能可以选择一个位置x，
// 技能会对[x-y,x+y]范围内的所有怪物造成1点伤害，
// 请问，玩家最少需要使用多少次技能，才能杀死所有怪物，怪物血量清0即视为被杀死


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//输入描述
//输入第一行包含一个两个正整数n和y，分别表示怪物的数量和技能的范围。（1<=n<=100000）
//接下来有n行，每行有两个正整数x和hp分别表示一只怪物的位置和血量。(1<=x,hp<=10^9)
// 3 5 1 10 10 5 22 3                         13
public class 消灭怪物的最少技能次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int range = sc.nextInt();
        int[][] boss = new int[n][2];
        for (int i = 0; i < n; i++) {
            boss[i][0] = sc.nextInt();
            boss[i][1] = sc.nextInt();
        }

        Arrays.sort(boss, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int res = 0;
        for (int i = 0; i < n; i++) {
            if(boss[i][1] > 0){
                int nums = boss[i][1];
                for (int j = i; j < n; j++) {
                    if(boss[j][0] > boss[i][0] + 2 * range){
                        break;
                    }
                    boss[j][1] -= nums;
                }
                res += nums;
            }
        }

        System.out.println(res);
    }
}
