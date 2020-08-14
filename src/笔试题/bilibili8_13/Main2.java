package 笔试题.bilibili8_13;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strin = sc.next();
        String str = strin.substring(1,strin.length()-1);

    }
    public boolean IsValidExp (String s) {
        Deque<Character> deque = new LinkedList<Character>();
        Map<Character,Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                char head = deque.isEmpty() ? '#' : deque.pop();
                if(head != map.get(s.charAt(i))){
                    return false;
                }
            }else{
                deque.push(s.charAt(i));
            }
        }
        return deque.isEmpty();
    }
}

