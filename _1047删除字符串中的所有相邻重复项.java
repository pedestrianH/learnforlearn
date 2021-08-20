package 学习;

import java.util.Stack;

public class _1047删除字符串中的所有相邻重复项 {
    public static void main(String[] args) {
        removeDuplicates("abbaca");
    }
    public static String removeDuplicates(String s) {
        Stack<Character> result = new Stack<>();
        String result1 = "";
        for (int i = 0; i <s.length() ; i++) {
            if (result.size() == 0){
                result.push(s.charAt(i));
            }else {
                if (s.charAt(i) == result.peek()){
                    result.pop();
                }
                else {
                    result.push(s.charAt(i));
                }
            }
        }

int len = result.size();
        Stack<Character> current = new Stack<>();
        for (int i = 0; i <len ; i++) {
            current.push(result.pop());


        }

        for (int i = 0; i <len ; i++) {
            result1 += current.pop();

        }
        return result1;
    }
}
