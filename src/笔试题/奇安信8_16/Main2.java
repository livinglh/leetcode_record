package 笔试题.奇安信8_16;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/*
hello word	undo redo	hahha
 */
public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String strin = sc.nextLine();
//        String[] strs = strin.split(" ");
//
//        Deque<String> deque = new LinkedList<String>();
//        List<String> ans = new LinkedList<String>();
//        for(String str : strs){
//            String[] tmp = str.split("\t");
//            for(String s : tmp){
//                if(s.equals("undo")){
//                    String cur = ans.remove(ans.size()-1);
//                    deque.offerFirst(cur);
//                }else if(s.equals("redo")){
//                    String curfirst = deque.pollFirst();
//                    ans.add(curfirst);
//                }else{
//                    ans.add(s);
//                }
//            }
//        }
//        for(String s : ans){
//            if(s.equals("")){
//                continue;
//            }
//            System.out.print(s + " ");
//        }
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s == null || s.trim().length() == 0){
            System.out.println("");
            return;
        }
        String[] strs = s.split("\\s+");
        Stack<String> stack = new Stack<String>();
        ArrayList<String> arr = new ArrayList<String>();
        for(String elem : strs){
            if(elem.equals("undo")){
                int size = arr.size();
                if(size>0){
                    String tmp = arr.get(size-1);
                    arr.remove(size-1);
                    stack.push(tmp);
                }
            }else if(elem.equals("redo")){
                if(!stack.isEmpty()){
                    arr.add(stack.pop());
                }
            }else{
                arr.add(elem);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            ans.append(arr.get(i)+" ");
        }
        String ansstr = ans.toString();
        System.out.println(ansstr.substring(0, ansstr.length()-1));
    }
}
