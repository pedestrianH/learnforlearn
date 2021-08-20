package 学习;

import java.util.Arrays;

public class 归并 {

    public static void main(String[] args) {
        int[] kkk = new int[]{1,9,1,3,1,1,1,5,9,1,90};
        int[] sort = sort(kkk);

        for (int i = 0; i <sort.length; i++) {
            System.out.println(sort[i]);
        }
    }
    public static int[] sort(int[] v){

        int zhongjian = v.length/2;
        if (v.length<2){

            return v;
        }
        int [] left = Arrays.copyOfRange(v,0,zhongjian);

        int[] right = Arrays.copyOfRange(v,zhongjian,v.length);

        return k(sort(left),sort(right));
    }
    public static int[] k(int[] left,int right[]){





        int[] result = new int[left.length+right.length];
        int index = 0;

        while (left.length > 0 && right.length >0){
            if (left[0] <= right[0]){
                result[index] = left[0];
                index++;
                left = Arrays.copyOfRange(left,1,left.length);
            }
            else {
                result[index] = right[0];
                index++;
                right = Arrays.copyOfRange(right,1,right.length);
            }
        }
        while (left.length > 0){
            result[index] = left[0];
            index++;
            left = Arrays.copyOfRange(left,1,left.length);
        }
        while (right.length > 0 ){
            result[index] = right[0];
            index++;
            right = Arrays.copyOfRange(right,1,right.length);

        }
    return result;
    }
}
