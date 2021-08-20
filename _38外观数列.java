package 学习;

import java.util.ArrayList;

public class _38外观数列 {
    public static void main(String[] args) {

        String k = "191";
        char[] b = k.toCharArray();
        int c = b[1];
        System.out.println(c);

//        System.out.println(i);

        countAndSay(11);
    }
    public static String countAndSay(int n) {

        if (n==1){
            return 1+"";
        }


            int index = 1;
            String result = "11";
        char[] array = result.toCharArray();
        //存储0位几个1位几
            int[][] k = new int[13000][2];

            int count = 0;
        String cur = "11";
        while (index<n-1){
            result = cur;
             cur = "";

            for (int i = 0,j= 0; j < result.length() ;) {

                    if (result.charAt(i) == result.charAt(j)){
                        k[count][1] =  result.charAt(i) -48;
                        k[count][0] ++;
                        j++;

                        if (j == result.length()){
                            cur +=  k[count][0];
                            cur += k[count][1];
                            i = j;
                            count++;
                        }
                    }else if(result.charAt(i) != result.charAt(j) || (j==result.length()-1) ) {
                        cur +=  k[count][0];
                        cur += k[count][1];
                        i = j;
                        count++;
                    }

            }

//            for (int i = 0; i <= count*2; i+=2) {
//                result +=   k[i/2][0]+"";
//                result += k[i/2][1]+"";
//            }




            k = new int[13000][2];
            index++;
            count = 0;
        }
        return result;
    }
}
