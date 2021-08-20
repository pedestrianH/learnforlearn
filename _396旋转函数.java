package 学习;

import java.util.Arrays;

public class _396旋转函数 {

    public int maxRotateFunction(int[] nums) {
        int result1 = 0;
        int charZhi = 0;
        int current = 0;
        int b = 0;
        for (int i = 0; i <nums.length ; i++) {
            current += nums[i] * ((i)%nums.length);
        }
        b = current;
        for (int i = 0; i <nums.length ; i++) {
            result1 += nums[i];
        }
        for (int i = 1; i <nums.length ; i++) {
           //错位相减法

            charZhi = result1 - (nums.length)*nums[nums.length-i];
            current += charZhi;
            b = Math.max(b,current);
        }
return b ;
    }
}
