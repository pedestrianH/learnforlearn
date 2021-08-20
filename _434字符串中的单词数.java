package 学习;

import java.util.Locale;

public class _434字符串中的单词数 {

    public int countSegments(String s) {
        int count = 0;
        int result = 0;
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i) != ' '){
                //最后一个的判断
                if (i == s.length()-1){
                    result++;
                }
                count ++;
            }

            else {
                if (count>0){

                    result++;
                    count = 0;
                }
            }
        }
return result;
    }
}
