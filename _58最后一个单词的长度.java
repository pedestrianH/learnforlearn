package 学习;

import java.util.Locale;

public class _58最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        String s1 = s.toLowerCase();
        int count = 0;
        for (int i = s1.length()-1; i >=0 ; i--) {
            if (s1.charAt(i) != ' '){
                count++;
            }
            else {
                if (count>0){
                    return count;
                }
            }
        }
        return count;
    }
}
