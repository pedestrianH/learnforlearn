package 学习;

public class _238除自身以外数组的乘积 {

    public int[] productExceptSelf(int[] nums) {
            int current = 1;
            int l = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] == 0){
                l++;
            }else {
                current *= nums[i];

            }
        }
        int[] result = new  int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            if (l>1){
                result[i] = 0;
            }

            else if (l == 1 && nums[i] != 0){
                result[i] = 0;


            }
            else if (l==1 && nums[i] == 0){

                result[i] = current;

            }
            else {
                result[i] = current/nums[i];
            }
        }
        return result;
    }
}
