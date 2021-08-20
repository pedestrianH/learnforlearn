package 学习;

public class _344反转字符串 {

    public void reverseString(char[] s) {
    char c = ' ';
        for (int i = 0, j = s.length-1; i <=j ; i++,j--) {
            c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
    }
}
