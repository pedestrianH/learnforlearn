package 学习;



public class _12整数转罗马数字 {

    public String intToRoman(int num) {
        /*
        * I             1
V             5
X             10
L             50
C             100
D             500
M             1000

*/


        String[] k = new String[]{
            "I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"
        };
        int[] t = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int result = 0;
        int index = 12;
        String result1 = "";
        int cur = num;
        //把最开始的值变为0
        while (cur!=0){
            if (cur  >= t[index]){
                result1 += k[index];
                cur = cur - t[index];

            }
            else {
                index--;
            }

        }        return result1;
    }
}
