package 学习;

import java.util.*;

public class _15三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] > 0 ){
                return result;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                    continue;
            }
            int right = nums.length - 1;

            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                //右边加起来超过0 右指针往左移
                    while (right > j &&( nums[right] +nums[j] >  (-1)*nums[i])){
                        right --;
                    }
                    if (right == j){
                        break;
                    }
                    if (nums[i] + nums[j] +nums [right] == 0){
                        List<Integer> c = new ArrayList<>();
                            c.add(nums[i]);
                            c.add(nums[j]);
                            c.add(nums[right]);
                            result.add(c);
                    }
            }
        }
        return result;
    }
}
