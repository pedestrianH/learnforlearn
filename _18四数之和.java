package 学习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if (i>0 && nums[i] == nums[i -1 ]){
                continue;
            }
            for (int j = i+1; j <nums.length ; j++) {
                if (j> i +1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int right = nums.length -1;
                for (int k = j+1; k <nums.length ; k++) {
                    if (k> j+1 && nums[k] == nums[k-1]){
                        continue;
                    }
                    while (right>k && nums[i] + nums[j] +nums[k] +nums[right] > target){
                        right --;
                    }
                    if (right == k){
                        break;
                    }
                    if (nums[i] + nums[j] +nums[k] + nums[right] == target){
                        List<Integer> c = new ArrayList<>();
                        c.add(nums[i]);
                        c.add(nums[j]);
                        c.add(nums[k]);
                        c.add(nums[right]);
                        result.add(c);
                    }
                }
            }
        }
            return result;
    }
}
