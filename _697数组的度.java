package 学习;

import java.util.Arrays;

public class _697数组的度 {

    public static int findShortestSubArray(int[] nums) {
        //结果成功但用了两层for超过时间限制了啊
//        if (nums.length == 1){
//            return 1;
//        }
//        int currentZui = 1;
//        int result = 1;
//        int len = 1;
//        int result1 = 1;
//
////        if (nums[0] == nums[nums.length-1]){
////            index = 1;
////        }
//        for (int i = 0; i <nums.length ; i++) {
//            //开始处
//             //结尾处
//            for (int j = i+1; j <nums.length ; j++) {
//
//                if (nums[i] == nums[j]){
//
//                    currentZui++;
//                    len = j - i + 1;
//
//                }
//            }
//            if (result > currentZui){
//
//
//            }else if (currentZui > result){
//                result = currentZui;
//                result1 = len;
//            }
//            else {
//               result1 = Math.min(result1,len);
//            }
//
//            currentZui = 1;
//        }
//return result1;





        //要想要不会超时 要使用多次循环 不要用嵌套的循环 用到了这个统计数组位置出现的频次，可使用令个数组映射索引为原数组的数据 值为其大小
        int[] first = new int[50000];
        int[] last = new int[50000];
        int result = 1;
        int currentZui[] = new int[50000];
        int result1 = Integer.MAX_VALUE;
        //定义所有的数据原来的开始处位置为-1
        Arrays.fill(first, -1);

        for (int i = 0; i <nums.length ; i++) {
            int k = nums[i];
            currentZui[k] ++;
result = Math.max(currentZui[k],result );
            if (first[k] == -1){
                first[k] = i;
            }
            last[k] = i;
        }
        for (int i = 0; i <nums.length ; i++) {
            int k = nums[i];
            if (result == currentZui[k]){
                result1 = Math.min(result1,last[k] - first[k] + 1);

            }
        }
        return result1;
    }
}
