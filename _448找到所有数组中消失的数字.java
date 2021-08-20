package 学习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _448找到所有数组中消失的数字 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        //[1,1]
        int[] a = new int[nums.length+1];
        Arrays.fill(a,-1);
        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            a[k] = 1;
        }
        for (int i = 1; i < a.length; i++) {
            if (a[i] != 1){
                list.add(i);
            }
        }
return list;
    }
}
