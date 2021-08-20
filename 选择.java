package 学习;

public class 选择 {

    public static void main(String[] args) {
        int[] result = new int[]{1,3,1,1,1,1,9,1,1,13,19,3,33};
        for (int i = 0; i <result.length ; i++) {
            int zui = Integer.MIN_VALUE;
            int index = 0;
            //从这里来选择最大值挪到最前的位置 循环往找到最大值
            for (int j = i; j < result.length; j++) {
                if (result[j] > zui){
                    zui = result[j];
                    //存储当前最大值的索引值
                    index = j;
                }
                zui = result[j] > zui ? result[j] : zui;

            }
            //交换最大值和最前的位置
            int c= result[i];
            result[i] = zui;
            result[index] = c;
        }


        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
