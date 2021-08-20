package 学习;

import java.util.*;

public class _155最小栈 {

    Deque<Integer> stack1 = new ArrayDeque<>();
    Deque<Integer> stack = new ArrayDeque<>();
//Integer zui = 0;
Integer k = 0;
//int[] z1 = new int[128];
List<Integer> result = new ArrayList<>();
int index = 0;
    /** initialize your data structure here. */
    public _155最小栈() {
stack.push(Integer.MAX_VALUE);

    }
    int zui = Integer.MAX_VALUE;


    public void push(int val) {

//        zui = (Integer)stack.peek() > val ? val : (Integer) stack.peek();
//result.add(val);




        stack1.push(val);
        Integer peek = stack.peek();
        //更新最小值的时候只需要一直和保存的最大值相比
         zui = val > peek  ? peek :val;
        stack.push(zui);
//        index++;
    }

    public void pop() {

//        z1[index-1] = Integer.MAX_VALUE;
//result.remove(index-1);

//
            stack1.pop();
            stack.pop();
//            zui = stack.poll();




    }

    public int top() {
        return    stack1.peek();

    }

    public int getMin() {
//Arrays.sort(z1);
//        if (stack.size() > 0 ){
            return  stack.peek();
//        }
//else return -1;
    }
}
