package 学习;

import java.util.Arrays;

public class _453最小操作次数使数组元素相等 {

    public int minMoves(int[] nums) {
        //首先要更新n-1个数值加一即要所有的值一样且要执行加一操作 因此最大值不要执行加一操作 
        // 为了加快加一的速度 因为都至少要把最小值加到最大值 因此直接给所有的除最大值的值加上最大值与最小值的差值
        Arrays.sort(nums);
        int result = 0;
        int step = 0;
        for (int i = nums.length-1; i > 0  ; i--) {
            //最小值一直是0位 最大值随着增加步值往前移动一个位置
            step = nums[i] - nums[0];
            nums[0] += step;
            //单次操作只会更新前一数据 而未更新之前的数据 在下次操作的时候更新只加上step值会漏掉数
            result += step;
            nums[i -1] += result;
        }
        return result;
    }
}
