package 学习;

import java.util.Locale;

public class _520检测大写字母 {

    public boolean detectCapitalUse(String word) {
        int index = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))){
                index++;
            }
        }
    if (index == word.length()){
        return true;
    }else if (index == 1 && Character.isUpperCase(word.charAt(0))){
        return true;
    }else if (index == 0){
        return true;

    }
        return false;
    }
}
