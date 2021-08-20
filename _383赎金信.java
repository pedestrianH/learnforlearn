package 学习;

import java.util.HashMap;
import java.util.Map;

public class _383赎金信 {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character,Integer> k = new HashMap<>();
        for (int i = 0; i <ransomNote.length() ; i++) {
            k.put(ransomNote.charAt(i),k.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        for (int i = 0; i <magazine.length() ; i++) {
            if (k.containsKey(magazine.charAt(i))){
                k.put(magazine.charAt(i),k.get(magazine.charAt(i))-1);
            }
        }
        int count = 0;
        for (int i = 0; i <ransomNote.length() ; i++) {
            if (k.get(ransomNote.charAt(i)) <= 0){
                count ++;
            }
        }
        return count == ransomNote.length();
    }
}
