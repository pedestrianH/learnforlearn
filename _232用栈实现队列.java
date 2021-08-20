package 学习;

import java.util.Stack;

public class _232用栈实现队列 {
    Stack<Integer> t = new Stack<>();
    Stack<Integer> k = new Stack<>();
    /** Initialize your data structure here. */
    public _232用栈实现队列() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        t.push(x);
    }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (k.size() > 0){
           return k.pop();
        }
       while (t.size() != 0){
          k.push(t.pop()) ;
       }
        return k.pop();
    }
    /** Get the front element. */
    public int peek() {
        if (k.size() > 0 ){
            return k.peek();
        }
        while (t.size() != 0){
            k.push(t.pop()) ;
        }
        return k.peek();

    }
    /** Returns whether the queue is empty. */
    public boolean empty() {

        return t.size() == 0 && k.size() == 0;
    }
}
