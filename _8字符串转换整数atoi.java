package 学习;

public class _8字符串转换整数atoi {


    public static void main(String[] args) {
        String b = "-91283472332";
        System.out.println(myAtoi(b));
    }

    public static int myAtoi(String s) {
        int cur = 0;
        String result = "";
        int count = 0;//计算有多少位 为之后的正数提供百分位
        int k = 0; //正负标志位 正为0 负1
        int result1 = 0;
        int ck = 0;
        for (int i = 0; i < s.length() ; i++) {
            if (ck>=1 && s.charAt(i)== ' ' && result.length() == 0){
               return 0;
            }
            if (ck>=2){
                return 0;
            }
            if (s.charAt(i) != ' ' && s.charAt(i) != '-' && s.charAt(i) != '+' && !(s.charAt(i) >= '0' && s.charAt(i) <= '9') && count == 0){
                return 0;
            }
            if (result.length()>=1 && (s.charAt(i) < '0' || s.charAt(i) > '9')){
                i = s.length();
                break;
            }
            if (s.charAt(i) == '-' ){

                k  = 1;
                if (ck>1) {
                    i =s.length();
                }
                ck++;
            }
            else if (s.charAt(i) == '+' && ck<=1){
                k = 0;
                if (ck>1) {
                    i =s.length();
                }
                ck++;

            }else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                count++;
                result += s.charAt(i);
            }
        }
int t = 0;
        for (int i = 0; i < result.length(); i++) {
            int i1 = result.charAt(i) - 48;
            count--;



            double pow = Math.pow(10,count);
            //"2147483643"
            if (result1 > (Integer.MAX_VALUE - i1)/10) {

                    return k == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result1  = result1*10 + i1;

        }
        int z =(int) Math.pow(2,31);

        int zuo = (-1)*z-1;
        int you = z;
        int result111 = (int) ( result1 * Math.pow(-1.0,k));
//        if (result111<zuo){
//            result111 = zuo;
//        }else if (result111 > you){
//            result111 = you;
//        }

        return result111 ;
    }
}
