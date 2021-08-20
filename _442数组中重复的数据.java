package 学习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _442数组中重复的数据 {
    public static void main(String[] args) {
        int[] k = new int[]{4,3,2,7,8,2,3,1};
        findDuplicates(k);
    }
    public static List<Integer> findDuplicates(int[] nums) {
List<Integer> list = new ArrayList<>();
int[] a = new int[nums.length+1];
        Arrays.fill(a,0);
        for (int i = 0; i <nums.length ; i++) {
            int k = nums[i];
            a[k] ++ ;
        }
        for (int i = 0; i <a.length ; i++) {
            if (a[i]==2){
                list.add(i);
            }
        }
return list;
    }
}
