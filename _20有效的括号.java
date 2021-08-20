package 学习;

import java.util.ArrayDeque;

public class _20有效的括号 {
    public boolean isValid(String s) {
        ArrayDeque<Character> result = new ArrayDeque<>();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                result.push(s.charAt(i));
            }
            else {
                if (result.size() == 0){
                    return false;
            }
                else   if (s.charAt(i) == ')' ){
                    if ( result.peek() == '('){
                        result.pop();
                    }
                    else {
                        return  false;
                    }
                }
                else if (s.charAt(i) == '}'){
                    if (result.peek() == '{'){
                        result.pop();
                    }else {
                        return false;
                    }
                }
                else if (s.charAt(i) == ']'){
                    if (result.peek() == '['){
                        result.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
return result.size() == 0;
    }
}
