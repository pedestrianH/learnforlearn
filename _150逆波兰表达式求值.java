package 学习;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _150逆波兰表达式求值 {

    public static void main(String[] args) {
        String[] k = new String[]{"2","1","+","3","*"};
        System.out.println(evalRPN(k));
    }
    public static int evalRPN(String[] tokens) {

        //要熟练应用if else 判断该循环下要执行多少条 只要执行一条程序时 用if else if结构 多个 if 判断时 有个if有 会在下次还会判断当未成功会进入else程序内
        Deque<Integer> result = new LinkedList<>();
        int k = 0;
        for (int i = 0; i < tokens.length; i++) {
                if (tokens[i] .equals( "+")){
                    result.push(result.pop() +result.pop());
                }
                else if (tokens[i].equals("-")){
                    Integer pop = result.pop();
                    Integer pop1 = result.pop();

                    result.push(pop1 -pop);
                }
                else if (tokens[i] .equals("*")){
                    result.push(result.pop() * result.pop());
                }
                else if (tokens[i] .equals("/") ){
                    Integer pop = result.pop();
                    Integer pop1 = result.pop();
                    result.push(pop1 /pop);
                }
                else {
                    result.push(Integer.parseInt(tokens[i]));
                }
        }
        return result.pop();
    }
}
