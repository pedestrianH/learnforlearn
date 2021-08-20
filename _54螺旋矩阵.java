package 学习;

import java.util.ArrayList;
import java.util.List;

public class _54螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int a = matrix.length;
        int b = 0;
        int c = matrix[0].length;
        int k = 0;

        int e = matrix[0].length;
        int f = 0;
        int l = matrix.length;
        int w = 0;
        int t = matrix.length + 2;
        int count  = 0;
        while (count < t){
            switch(count%3){
                case 0 :



                    //bc
                    for (int i = b; i < c; i++) {



                        list.add(matrix[b][i]);


                    }
b++;
                    c--;
                    break; //可选
                //af
                case 1 :
                    //语句
                    for (int i = f+1; i < a ; i++) {
list.add(matrix[i][a-1]);
                    }
                    a--;
                    f++;
                    break; //可选
                //你可以有任意数量的case语句
                case 2 :
                    for (int i = e - 2; i >= k   ; i--) {
list.add(matrix[e-1][i]);
                }
                    k++;
                    e--;
                    break;
                case 3 :
                    for (int i = l - 2; i > w ; i--) {
list.add(matrix[i][w]);
                    }
                    w++;
                    l--;
                    break;
                default : //可选
                    //语句
            }
count++;
        }



        return list;
    }
}
