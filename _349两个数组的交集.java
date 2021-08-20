package 学习;

import java.util.HashMap;
import java.util.Map;

public class _349两个数组的交集 {

    public int[] intersection(int[] nums1, int[] nums2) {
            int[] result = new int[Integer.MAX_VALUE];

        Map<Integer,Integer> c = new HashMap<>();

        for (int i = 0; i <nums1.length ; i++) {


                c.put(nums1[i],13);

        }
        for (int i = 0; i <nums2.length ; i++) {
            if (c.get(nums2[i])== null){

            }
            else if (c.get(nums2[i]) == 13){
                c.put(nums2[i],3);
            }
        }

        int index = 0;
        for (int i = 0; i <nums1.length ; i++) {
            if (c.get(nums1[i]) == 3){
                result[index] = nums1[i];
                c.put(nums1[i],11);
                index++;
            }
        }
        int[] result1 = new int[index];

        for (int i = 0; i <index ; i++) {
            result1[i] = result[i];
        }
            return result1;
    }
}
