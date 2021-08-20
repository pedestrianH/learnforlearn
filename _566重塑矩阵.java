package 学习;

public class _566重塑矩阵 {

    public int[][] matrixReshape(int[][] mat, int r, int c) {
            int[][] result = new int[r][c];
            int[] current = new int[mat.length*mat[0].length];
            int index = 0;
            if (mat.length*mat[0].length != r*c){
                return  mat;
            }
            else {
             for (int i = 0; i <mat.length ; i++) {
                for (int j = 0; j <mat[0].length ; j++) {
                    current[index] = mat[i][j];
                    index++;
                }
            }
             int k = 0;
                for (int i = 0; i <r ; i++) {
                    for (int j = 0; j <c ; j++) {
                        result[i][j] = current[k];
                        k++;
                    }
                }
                return result;

            }

    }
}
