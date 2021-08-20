package 学习;

public class _27移除元素 {

    public int removeElement(int[] nums, int val) {
        //左右指针覆盖 左指针往左全部都未含有val 左指针的值要被有指针的值覆盖
        int slow = 0;
       int fast = 0;
        while (fast < nums.length){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                fast++;
                slow++;
            }else {

                fast++;
            }
        }
return slow;
    }
}
