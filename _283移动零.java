package 学习;

public class _283移动零 {

    public void moveZeroes(int[] nums) {
        //[0,1,0,3,12] 1 0 0 3 12      1 3 0 0 12    1 3 12 0 0 [1,0]
        if (nums.length == 1){
            return ;
        }
        int index = 0;
        for (int i = 0; index <nums.length ; i++) {
            while ( index<nums.length && nums[index] == 0 ){

               index++;

           }
           if (index == nums.length){
               return;
           }
           if ( i != index){
               nums[i] = nums[index];
               nums[index] = 0;
           }

            index++;
        }
    }
}
