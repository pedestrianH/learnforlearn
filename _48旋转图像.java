package 学习;

public class _48旋转图像 {

    public static void main(String[] args) {
        int[][] b = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(b);
    }
    public static void rotate(int[][] matrix) {
        int count = matrix.length - 2;
        int b = 0;
        int c = 0;
        int current = 0;
        int index = 0;

        int you = matrix.length;
        do {

            for (int i = index,j = index;  j < you - 1 ; j++) {

                            int k = 0;
                current =    matrix[i][j];
                        while (k < 4){
                            b = current;
                            current = matrix[j][matrix.length-i-1];


                            matrix[j][matrix.length-i-1] = b;
                            //行列交换
                            c = j;
                            j = matrix.length-i-1;
                            i = c;
                            k++;
                        }

            }
            you --;
            count--;
            index++;
        }
        while (count > 0 );

    }
}
