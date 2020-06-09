package 公司真题.腾讯.后台2020;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class 压缩算法 {

    public static String solve(String str){
        int mutil=0;//乘数
        LinkedList<String> stack_res=new LinkedList();//结果暂存
        LinkedList<Integer> mutil_stack=new LinkedList();
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<str.length();i++) { //toCharArray() 需要O(n)的空间复杂度,不打算使用
            if(str.charAt(i)=='[') {
                stack_res.addLast(temp.toString());//保存上一次的结果 [HG]
                temp=new StringBuilder();//用于接收新的字母[B]
            }else if(str.charAt(i)==']') {
                StringBuilder temp2=new StringBuilder();
                //取出乘数
                int num= mutil_stack.removeLast();
                for(int j=0;j<num;j++) {
                    temp2.append(temp);
                }
                temp=new StringBuilder(stack_res.removeLast()+temp2);
            }else if(str.charAt(i)=='|') {//乘数[3]入栈
                mutil_stack.addLast(mutil);
                mutil=0;//寻找新的乘数比如[2]
            }
            else if(str.charAt(i)>='0'&&str.charAt(i)<='9') {
                //预防数字出现 [ 19  |a]
                mutil=mutil*10+Integer.parseInt(str.charAt(i)+"");
            }else {
                //正常字母
                temp.append(str.charAt(i));
            }
        }
        System.out.print(temp.toString());
        return temp.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        solve(s);
    }

}
