package 学习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* P       H
A     S I
Y   I   R
P L     I  G
A        N  */
public class _6Z字形变换 {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 5));
    }
    public static String convert(String s, int numRows) {
        if (numRows <= 1){
            return s;
        }
int count = 0;
int current = numRows - 2;
int index = 0;
int lie = 0;
     char[][] result = new char[numRows][1000];


        for (int i = 0; i <numRows ; i++) {
            Arrays.fill(result[i],' ');

        }
        for (int i = 0; index <s.length() ; i++) {
            if (i%(numRows-1)!=0){

                result[current][i] = s.charAt(index);
                current--;
                index++;
                lie = i+1;


            }
            else {
                current = numRows - 2;
                for (int j = 0; j < result.length && index < s.length(); j++) {
                    result[j][i] =s.charAt(index);

                    index++;
                }
                lie = i+1;

            }

        }
        String result1 = "";
        for (int i = 0; i <numRows ; i++) {
            for (int j = 0; j < lie; j++) {
                if (result[i][j] != ' '){
                    result1 += result[i][j];

                }
            }
        }


        return result1;
    }
}
