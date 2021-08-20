package 学习;

import java.util.HashMap;
import java.util.Map;

public class _454四数相加II {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer,Integer> k = new HashMap<>();
        for (int i = 0; i <nums1.length ; i++) {
            for (int j = 0; j <nums2.length ; j++) {

                k.put(nums1[i]+nums2[j],k.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }

        int count = 0;
        for (int i = 0; i <nums3.length ; i++) {

            for (int j = 0; j <nums4.length ; j++) {


                        if (k.containsKey(-nums3[i]-nums4[j])){
                            //成立一次会把之前的value再加一因为要有排列的
                            count += k.get(-nums3[i]-nums4[j]);
                        }
            }
        }
        return count;
    }
}
