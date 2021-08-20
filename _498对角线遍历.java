package 学习;

public class _498对角线遍历 {
    public static void main(String[] args) {
        int[][] b = new int[][]{{ 1, 2, 3 } , { 4, 5, 6} , {7, 8, 9}  };
        findDiagonalOrder(b);
    }
    public static int[] findDiagonalOrder(int[][] mat) {
            int [] result = new  int[mat.length*mat[0].length];
            int index = 0;
            int count = 0;
            int t = mat.length + mat[0].length -1;
            int current = 0;

            //列
            int indexZ = 0;
            //行
            int indexA = 0;
            while (count < t){
                switch(count%2){
                    case 0 :
                        //语句
                        for (int i = indexA, j = indexZ; i >=0 && j<mat[0].length; i--,j++) {
                                  result[index] = mat[i][j];

                                  current = j;
                                  index++;
                                  indexA = i;
                                  indexZ = j;
                                }
                        if (current  == mat[0].length-1){
                            indexA++;
                        }else {
                            indexZ++;
                        }
                        break; //可选
                    case 1 :
                        for (int i = indexA,j = indexZ; i < mat.length && j >=0; i++,j--) {
                                    result[index] = mat[i][j];
                            indexA = i;
                            indexZ = j;
                                    current = i;
                                    index++;
                        }
                        if (current == mat.length - 1){
                            indexZ++;
                        }else {
                            indexA++;
                        }
                        //语句
                        break; //可选
                    //你可以有任意数量的case语句
                    default : //可选
                        //语句
                }

                count++;
            }

            return result;
    }
}
