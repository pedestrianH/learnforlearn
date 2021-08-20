package 学习;

public class _59螺旋矩阵II {

    public static void main(String[] args) {
        generateMatrix(3);
    }
    public static int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int t = n*2 -1;
            int count = 0;
            int a = 0;
            int b = n;
            int c = 0;
            int k = n;
            int value = 1;
            while (count < t){
                switch(count%4){
                    case 0 :
                        //语句
                        for (int i = c; i < k ; i++) {
                            result[a][i] = value;
                            value++;
                        }
                        a++;
                        break; //可选
                    case 1 :
                        for (int i = a; i < b ; i++) {
                            result[i][k-1] = value;
                            value++;
                        }
                        k--;
                        //语句
                        break; //可选
                    //你可以有任意数量的case语句
                    case 2 :
                        for (int i = k-1; i >= c ; i--) {
                            result[b-1][i] = value;
                            value++;
                        }
                        b--;
                        break;
                    case 3 :
                        for (int i = b-1; i >= a ; i--) {
                            result[i][c] = value;
                            value++;
                        }
                        c++;
                        break;
                    default : //可选
                        //语句
                }
                count++;
            }
            return result;
    }
}
