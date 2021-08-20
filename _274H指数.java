package 学习;

import java.util.Arrays;

public class _274H指数 {

    public int hIndex(int[] citations) {

//int[] a =  new int[citations.length+1];
//        Arrays.fill(a,0);
//        for (int i = 0; i <citations.length ; i++) {
//            int k = citations[i];
//            //被引用了多少次的论文有几篇
//            a[k] ++;
//        }
////        题目就想找出有n篇论文被引用了>=n次,求n的最大值，n篇和n次必须是相等的
//return 1;
        //超过当前论文引用次数的论文篇数
        //[1,3,1]
//        if (citations[0]==0 && citations.length == 1){
//            return 0;
//        }
//        else if (citations[0] !=0 && citations.length == 1){
//            return 1;
//        }
//        int current = 1;
//        int result1 = 0;
//        for (int i = 0; i <citations.length ; i++) {
//            for (int j = i+1; j < citations.length; j++) {
//                if (citations[j]>=citations[i]){
//                   current++;
//                }
//            }
//            if (current >= citations[i]){
//                result1 = result1> current ? result1 : current;
//            }
//            current = 1;
//        }
//

        Arrays.sort(citations);
        int result1 = 0;
        int k = citations.length - 1;
while ( k>=0 && citations[k] > result1){
result1 ++;

k--;
}
        return result1;
    }



}
