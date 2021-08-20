package 学习;

import java.util.*;

public class _347前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
       int[] result = new int[k];
        Map<Integer,Integer> t = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            t.put(nums[i],t.getOrDefault(nums[i],0)+1);
        }
        Set<Map.Entry<Integer, Integer>> entries = t.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue() );
        for (Map.Entry<Integer, Integer> entry: entries) {
            queue.add(entry);
            if (queue.size() > k){
                queue.poll();
            }
        }
        for (int i = 0; i <k ; i++) {

            result[i] = queue.poll().getKey();
        }
            return  result;
    }
}
