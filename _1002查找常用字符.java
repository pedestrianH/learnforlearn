package 学习;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1002查找常用字符 {

    public List<String> commonChars(String[] words) {
    int[] hash = new int[26];
        List<String> result =  new ArrayList<>();

        for (int i = 0; i <words[0].length() ; i++) {

            hash[words[0].charAt(i) - 'a'] ++;
        }
        for (int i = 1; i <words.length ; i++) {
            int[] c  = new int[26];

            for (int j = 0; j <words[i].length() ; j++) {
                c[words[i].charAt(j) - 'a']++;
            }

            for (int j = 0; j <26 ; j++) {
                hash[j] = Math.min(c[j],hash[j]);
            }

        }
        for (int i = 0; i <26 ; i++) {
            if (hash[i] > 0){
                while (hash[i]>0){
                    result.add((char)(i+'a')+"");
                    hash[i] --;
                }
            }
        }
        return result;
    }
}
