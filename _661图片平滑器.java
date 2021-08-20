package 学习;

import java.util.Random;

public class _661图片平滑器 {
    public static void main(String[] args) {
        int[][] b = new int[][]{{3,1,1}, {1,0,1},{1,1,1}};
        imageSmoother(b);
    }
    public static int[][] imageSmoother(int[][] img) {
            int[][] result = new int[img.length][img[0].length];
int current = 0;
int result1 = 0;
        for (int i = 0; i <img.length ; i++) {
            for (int j = 0; j < img[i].length; j++) {
                result1 += img[i][j];
                current ++;
                //左边
              if (j - 1 >= 0 ){
                  result1 += img[i][j-1];
                  current ++;

              }
              //右边
                if (j + 1 < img[0].length){
                    result1 += img[i][j+1];
                    current ++;

                }
                //上边
                if ( i -1 >= 0 ){
                    result1 += img[i-1][j];
                    current++;
                }
                //下边
                if (i+1 < img.length){
                    result1 += img[i+1][j];
                    current++;
                }
                //左上
                if (i-1 >=0 && j-1 >= 0){
                    result1 += img[i-1][j-1];
                    current++;
                }
                //右上
                if (i-1 >=0 && j+1 < img[0].length){
                    result1 +=img[i-1][j+1];
                    current++;
                }
                //左下
                if (i+1 < img.length && j - 1>=0){
                    result1 += img[i+1][j-1];
                    current++;
                }
                //右下
                if (i+1 < img.length && j+1 < img[0].length){
                    result1 += img[i+1][j+1];
                    current++;
                }
                result[i][j] = (int) Math.floor((double) result1/current);
                result1 = 0;
                current = 0;
            }
        }
            return result;

    }
}
