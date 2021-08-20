package 学习;

public class _26删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }

        int fast = 1;
        int slow = 1;
        while (fast < nums.length){
            if (nums[fast]!=nums[slow-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
return  nums[slow] ;
    }
}
