package 常用算法;

// 返回字串在主串中的首位置
public class KMP算法 {
    // s[]是长文本，p[]是模式串，n是s的长度，m是p的长度
    public static int kmp(char[] s, char[] p){
        int result = -1;
        int m = p.length, n = s.length;
        //1. 求模式串p的next数组
        int[] next = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while(j !=0 && p[i] != p[j]) j = next[j];
            if(p[j] == p[i]) j++;
            next[i] = j;
        }
        //2. 开始匹配
        for(int i = 0, j = 0; i < n; i++){
            while(j != 0 && s[i] != p[j]) j = next[j-1];
            if(s[i] == p[j]) j++;
            if(j == m){
                result = i - j + 1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String s = "abxabcabcaby";
        String p = "abcaby";
        int ans = kmp(s.toCharArray(), p.toCharArray());
        System.out.println(ans);
    }

}
