package 学习;

public class _43字符串相乘 {

    public static void main(String[] args) {
        System.out.println(multiply("1", "30"));
    }
    public static String multiply(String num1, String num2) {
        //当数值超过了Java内置数据类型时报错
//   long k = 0;
//        long cur = 0;
//        long t = 0;
//        long c = 0;
//        for (int i = 0; i <num1.length() ; i++) {
//                cur = num1.charAt(i)-'0';
//                k = k*10+cur;
//        }
//        for (int i = 0; i < num2.length(); i++) {
//            c = num2.charAt(i)-'0';
//            t = t*10+c;
//        }
//       System.out.println(k);
//        System.out.println(t);
//   long result =   k*t;
//   System.out.println(result);
//        String result1 = String.valueOf(result);
//   return result1;
int l1 = num1.length();
int l = num2.length();
int cur1 = 0;
int cur = 0;
int current = 0;
int jin = 0;
int[] k = new  int[l+l1];
        for (int i = l1 -1 ; i >=0 ; i--) {
            for (int j = l - 1; j >= 0 ; j--) {
                    cur = num1.charAt(i) - '0';
                    ; //加上前的进位符
                    cur1 = num2.charAt(j) - '0';
                current = cur*cur1;
                current += k[j+i+1];//当前的值和要算上之前的进位
                k[i+j+1] = current%10;//当前的值存储个位数
                k[i+j] += current/10;
            }
        }



        String result = "";
        for (int i = 0; i <k.length ; i++) {
            if (k[i] == 0 && result.length() == 0){
                continue;
            }
            result+=k[i];
        }

        return result == "" ? "0" : result;
    }
}
