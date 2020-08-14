package 笔试题.字节8_9;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
一个长度为n的字母串（均为小写字母），允许对m个位置进行修改，修改完后选取一个连续子串，使得子串中只存在一种字母
计算所能得到的最长子串的长度是多少

8 1
aabaabaa

5

8 2
aabaabaa

8
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();
        char[] ch = str.toCharArray();
        Set<Character> set = new HashSet<>(); //存其中不同的字母
        for (int i = 0; i < n; i++) {
            if(!set.contains(ch[i])){
                set.add(ch[i]);
            }
        }
        int ans = 0;
        for(char c : set){
            int left = 0, right = 0, curuse = 0;
            while(left < n && right < n){
                if(ch[right] == c){
                    right++;
                }else{
                    if(curuse < m){
                        curuse++;
                        right++;
                    }else{
                        if(ch[left] != c){
                            curuse--;
                        }
                        left++;
                    }
                }
            }
            ans = Math.max(right - left, ans);
        }
        System.out.println(ans);
    }
}
