package 学习;

public class _28实现strStr {

    public static void main(String[] args) {
        strStr( "hellolwektzlelwekelweke","lweke");
    }
    public static int strStr(String haystack, String needle) {
//        if (needle.length() == 1){
//return haystack.indexOf(needle);
//        }
//        else if (needle.length() == 0){
//            return 0;
//        }
//        int[] result = new int[haystack.length()];
//        int  k = 0; //右指针
//        int t  =0; //needle
//        for (int i = 0; i <haystack.length() ; i++) {
///* "hellolwektzle"
//"lwektzle"*/
//           if (k  != needle.length()){
//
//
//
//               i = result[0] +1;
//               k = 0;
//               t = 0;
//
//
//           }
//           while (haystack.charAt(i) == needle.charAt(t)){
//                result[k] = i;
//                k++;
//                t++;
//                i++;
//                if (t==needle.length())
//                    return result[0];
//                if( i == haystack.length()){
//                    break;
//                }
//            }
//        }
//
//
//        if (k < needle.length()){
//            return -1;
//        }
//        return result[0];
if (needle.length() == 0){
    return 0;
}
        char[] k = haystack.toCharArray();
        char[] t = needle.toCharArray();
        for (int i = 0; i <k.length ; i++) {
            int index = i;
            int b = 0;
            while ( b <t.length &&index<k.length && k[index] == t[b] ){
                index++;
                b++;
            }

            if (b == t.length){
                return i;
            }
        }


        return -1;
    }
}
