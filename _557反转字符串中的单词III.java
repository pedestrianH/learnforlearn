package 学习;

public class _557反转字符串中的单词III {

    public String reverseWords(String s) {

        String result = s;
        int k = 0;
        int c = 0;
        for (int i = 0; i <s.length() ; i++) {
            if ( s.charAt(i) == ' '){

                c = i - 1; //结尾

               result = reverseStr(result, k, c);
                k = i + 1; //下个开始
            }
            else if ((i+1)==s.length() ){
                result = reverseStr(result,k,s.length()-1);
            }
        }
return result;
    }
    public String reverseStr(String s,int k,int c){
        StringBuilder b = new StringBuilder(s);



        char f = ' ';
        for (int i = k, t = c; i <= t ; i++,t--) {
            f = b.charAt(i);
            b.replace(i,i+1,b.charAt(t)+"");
            b.replace(t,t+1,f+"");
        }
        return b.toString();
    }
}
