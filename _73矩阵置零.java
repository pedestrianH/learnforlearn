package 学习;

public class _73矩阵置零 {

    public void setZeroes(int[][] matrix) {
        int[][] b  =  new int[matrix[0].length*matrix.length][2];
        int index = 0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0){
                        b[index][0] = i;
                        b[index][1] = j;
                        index++;
                    }
            }
        }
        for (int i = 0; i < index; i++) {
            //行0
            for (int j = 0; j <matrix[0].length ; j++) {
                matrix[b[i][0]][j] = 0;
            }



            //列
            for (int j = 0; j <matrix.length ; j++) {
                matrix[j][b[i][1]] = 0;

            }
        }
    }
}
