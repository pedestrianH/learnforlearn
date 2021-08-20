package 学习;

public class 冒泡 {

    public static void main(String[] args) {
        int[] result = new int[]{3,1,1,1,1,1,91,13,1,8};
        for (int i = 0; i <result.length - 1 ; i++) {
            //循环一次之后把当前最大值排到了最后 因此在下次循环的时候不要进行最后一个的操作
            for (int j = 0; j <result.length-1 -i ; j++) {
                if (result[j] >result[j+1]){
                    int c = result[j+1];
                    result[j+1] = result[j];
                    result[j] = c;



                }

            }
        }




        //优化 因为当该数组为有序的时候它会进行n*n次排序 而在进入内部循环的时候当所有的if操作都为成功的话直接退出所有的循环
        // 因为内部循环都在吧未实现的数组进行排序
        for (int i = 0; i <result.length - 1 ; i++) {
            boolean flag = true;
            //循环一次之后把当前最大值排到了最后 因此在下次循环的时候不要进行最后一个的操作
            for (int j = 0; j <result.length-1 -i ; j++) {
                if (result[j] >result[j+1]){
                    int c = result[j+1];
                    result[j+1] = result[j];
                    result[j] = c;
                    flag = false;


                }

            }//这里为true则所有的数组为有序
            if (flag){
                break;
            }
        }
    }
}
