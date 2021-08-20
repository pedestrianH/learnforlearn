package 学习;

import java.util.HashSet;
import java.util.Set;

public class _202快乐数 {

    public boolean isHappy(int n) {
        String result = n+"";
        int index = 0;
        int c = 0;
        Set<Integer> k = new HashSet<>();
        while (n != 1 && !k.contains(n)){
            k.add(n);
            while (n >0){
                int c1 = n%10 ;
                c += c1 *c1;
                n = n/10;
            }
            n = c;
            c = 0;
        }
        return n == 1;
    }
}
