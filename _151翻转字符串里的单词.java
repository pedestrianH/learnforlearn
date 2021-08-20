package 学习;

import java.util.Locale;

public class _151翻转字符串里的单词 {
    public static void main(String[] args) {
     String b =  "Alice does not even like      bob";
        System.out.println(reverseWords(b));


    }
    public static String reverseWords(String s) {
//        StringBuilder b = new StringBuilder();
        int count = 0;
        String z = "";
        String y = "";

//        String[] result = new String[10^4];
int index = 0;
        for (int i = 0; i <s.length(); i++) {

            if (s.charAt(i) != ' '){
            z += s.charAt(i);
                count++;
                if (i+1 == s.length()){
//                        result[index] = z;
                        z = "";
                        count = 0;
                        index++;
                }
            }
            else {
                if (count>0){

//                    result[index] = z;
                    z = "";
                    count = 0;
                    index++;
                }
            }
        }
//        for (int i = 0; i <s.length() ; i++) {
//            if (s.charAt(i)!= ' '){
//                b.append(s.charAt(i));
//            }
//            b.append(char[],offset,len)
//            else if (s.charAt(i) == ' ' &&)
//        }

        String[] result = new String[index];
        index = 0;
        for (int i = 0; i <s.length(); i++) {

            if (s.charAt(i) != ' '){
                z += s.charAt(i);
                count++;
                if (i+1 == s.length()){
                        result[index] = z;
                    z = "";
                    count = 0;
                    index++;
                }
            }
            else {
                if (count>0){

                    result[index] = z;
                    z = "";
                    count = 0;
                    index++;
                }
            }
        }

        for (int i = 0,j = result.length -1; i <=j ; i++,j--) {
            String c = "";
            c = result[i];
            result[i] = result[j];
            result[j] = c;
        }
        StringBuilder result1 = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            result1.append(result[i]);
            if (i+1 != result.length){
                result1.append(" ");
            }
        }

        return result1.toString();
    }
}
