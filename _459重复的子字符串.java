package 学习;

public class _459重复的子字符串 {

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 2 && s.charAt(0) == s.charAt(1)){
            return true;
        }
        if (s.equals("")) return false;

        int len = s.length();
//        // 原串加个空格(哨兵)，使下标从1开始，这样j从0开始，也不用初始化了
//        s = " " + s;
        char[] chars = s.toCharArray();
        int[] next = new int[len ];
        int j = -1;

        next[0] = j;
        for (int i = 1; i <s.length() ; i++) {
            while (j >=0 && chars[i] != chars[j+1]){
                    //不相等则回退到前个数的next
                j = next[j];


            }


            //重新开始又找到了匹配
            if (chars[i] == chars[j+1]){
                j++;
            }
            next[i] = j; //要保证这时候的j之前的数据和j+1的数据有几位相同
        }
        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len-1] > 0 && len % (len - next[len-1]-1) == 0) {
            return true;
        }
        return false;
    }

}
