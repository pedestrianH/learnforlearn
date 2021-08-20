package 学习;

import java.util.Arrays;

public class _41缺失的第一个正数 {

    public int firstMissingPositive(int[] nums) {
        //超过了空间限制
//        int[] currentZui = new int[Integer.MAX_VALUE];
//        int result1 = 0;
//        for (int i = 0; i <nums.length ; i++) {
//
//            if (nums[i]>=0){
//                currentZui[nums[i]] ++;
//            }
//
//        }
//        for (int i = 0; i <currentZui.length ; i++) {
//            if (currentZui[i] == 0){
//                result1 = Math.min(result1,currentZui[i]);
//            }
//        }
//
////        Arrays.binarySearch()
//return result1;

        Arrays.sort(nums);

            for (int j = 1; j <nums.length ; j++) {
                        if (Arrays.binarySearch(nums,j)<0){
return j;
                        }
            }

return nums[nums.length-1]+1;
    }
}
