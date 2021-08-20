package 学习;

import java.util.Locale;

public class _125验证回文串 {


    public boolean isPalindrome(String s) {
        String k = s.toLowerCase();

        int i = 0;
        int j = k.length() - 1;
     while (i<=j){
         if (!(Character.isDigit(k.charAt(i))   || k.charAt(i)>='a'&& k.charAt(i)<='z' )){
                    i++;
                    continue;
         }
         if ( !(Character.isDigit(k.charAt(j))   || k.charAt(j)>='a'&& k.charAt(j)<='z' )){
                        j--;
continue;
         }
         else if (k.charAt(i) == k.charAt(j)){
             i++;

             j--;


         }else if (k.charAt(i) != k.charAt(j)){
             return false;
         }

     }


        return true;
    }
}
