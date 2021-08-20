package 学习;

import java.util.Locale;

public class _541反转字符串II {

    public String reverseStr(String s, int k) {
        String result = s;
        int len = s.length();
        //在2k位置 有多少个间隔能
        int c = 0;
if (len < k){
    return reverStr(result,0,len);
}
        for (int i = 0; i < s.length(); i++) {
            int cur  =len - i -k - 1;
            if ((i+1)%(k) == 0 ){
                c = i - k +1;
               result =  reverStr(result,c,c+k);
                            if ( cur < 2*k && cur >= k ){
                            result = reverStr(result,i+1+k,i+k+1+k);
                            return result;
                        }
                    else if (cur<k && cur >=0){
                        result  = reverStr(result,i+1+k,len);
                        return result;
                    }
                    i = i+ k;
            }
        }
        return result;
    }
    public String reverStr(String s, int k,int b){
        StringBuilder a = new StringBuilder(s);
        char t = ' ';
        for (int i = k,c = b-1; i <=c ; i++,c--) {
            t = s.charAt(i);
a.replace(i,i+1,s.charAt(c)+"");
            a.replace(c,c+1,t+"");
        }
        return a.toString();
    }
}
