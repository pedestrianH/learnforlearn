package 学习;

public class 插入 {

    public static void main(String[] args) {
        int[] result = new int[]{1,3,1,1,1,1,33,1,1,1,3,13,1,1};
        //从当前的位置开始往前找要不要比更大值 有交换 因为其能够让当前位置往左全部能够保持有序 找不到更大的值不用动
        for (int i = 0; i <result.length-1 ; i++) {
            for (int j = i+1; j >0 ; j--) {
                if (result[j] < result[j-1]){
                    int c = result[j];
                    result[j] = result[j-1];
                    result[j-1] = c;


                }
                else {
                    break;
                }
            }
        }


        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }


    }



    //网上的文章写的正解
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i  <n; i++) {
            int value = arr[i];
            int j =0;//插入的位置
            for (j =i-1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];//移动数据
                } else {
                    break;
                }
            }
            arr[j+1] = value; //插入数据
        }
    }
}
