package 学习;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class _239滑动窗口最大值 {
    public static void main(String[] args) {
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        //offer和add都为吧数据插入队列的尾部 push插入头部 poll头部
        int[] result = new int[nums.length-(k-1)];
        QueueT queueT = new QueueT();
        int index = 0;
        for (int i = 0; i <k ; i++) {
            queueT.push(nums[i]);
        }
        result[index]= queueT.peek();
        for (int i = k; i <nums.length  ; i++) {
index++;
            queueT.poll(nums[i-k]);
            queueT.push(nums[i]);
            result[index] = queueT.peek();
        }
        //超时了
//        int[] result = new int[nums.length-(k-1)];
//        int zui = Integer.MIN_VALUE;
//        for (int i = 0; i <nums.length-(k-1) ; i++) {
//            zui = Integer.MIN_VALUE;
//            for (int j = i; j < k+i ; j++) {
//            if (nums[j] > zui){
//                zui = nums[j];
//            }
//
//            }
//            result[i] = zui;
//        }

        return result;
    }
}

class QueueT{
    Deque<Integer> k = new LinkedList<>();
    public  QueueT(){
    }
    public int peek (){
        return k.peek();
    }
    public void push(int val){
//获取尾部数据
        while (!k.isEmpty()&& val>k.getLast()){
                        k.removeLast();
        }
        k.add(val);
    }
    public void poll(int val){
        //当删除的值为最大值即peek为只删除一头部数据为队列头部为最开始加入
        if (!k.isEmpty() && val == k.peek()){

            k.poll();
        }

    }
}
