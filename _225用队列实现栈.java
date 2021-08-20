package 学习;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _225用队列实现栈 {

    public _225用队列实现栈() {
        result= new LinkedList<Integer>();
        result1 = new LinkedList<Integer>();
    }
    //只存储一个数据给来pop和peek数据
    Queue<Integer>  result ;
    //这里存储的是除了栈顶数据的数据
    Queue<Integer>  result1 ;
    public void push(int x) {
        result1.offer(x);
        while (result.size() > 0){
            result1.offer(result.poll());
        }
        Queue<Integer> c;
        c = result;
        result = result1;
        result1 = c;
    }
    public int pop() {
        return result.poll();
    }
    public int top() {
        return result.peek();
    }
    public boolean empty() {
        return  result.isEmpty();
    }
}
