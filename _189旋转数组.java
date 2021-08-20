package 学习;

public class _189旋转数组 {

    public void rotate(int[] nums, int k) {
int[] result = new int[k];
int index = 0;
if (nums.length <= 1){
    return;
}
        for (int i = Math.abs(nums.length - k%nums.length); i <nums.length ; i++) {
            result[index] = nums[i];
            index++;
        }
        for (int i = nums.length - 1; i >=  k%nums.length; i--) {
            nums[i] = nums[i-k%nums.length];
        }
        for (int i = 0; i <index ; i++) {
            nums[i] = result[i];
        }
    }
}
