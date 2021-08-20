package 学习;

public class 希尔 {

    public static void main(String[] args) {
        int[] result = new int[]{1,1,1,1,11,1,9,1,13,90,1,91};
        for (int gap =result.length/2 ; gap >=1 ; gap= gap/2) {
            for (int j = gap; j < result.length; j++) {
               int t = j-gap;
               int c= result[j];
               while (t>=0 && result[t] >c ){
                    result[t+gap] = result[t];
                   t = t-gap;
               }
               result[t+gap] = c;
            }
        }
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
        }
    }
}
